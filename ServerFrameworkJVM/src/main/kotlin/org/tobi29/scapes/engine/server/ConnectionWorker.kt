/*
 * Copyright 2012-2017 Tobi29
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tobi29.scapes.engine.server

import kotlinx.coroutines.experimental.*
import org.tobi29.scapes.engine.utils.*
import org.tobi29.scapes.engine.utils.io.IOException
import org.tobi29.scapes.engine.utils.logging.KLogging
import java.nio.channels.ClosedSelectorException
import java.nio.channels.Selector
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Class for processing non-blocking connections
 * @param connection The [ConnectionManager] that holds this worker
 * @param maxWorkerSleep Maximum sleep time in milliseconds
 */
class ConnectionWorker(
        /**
         * The [ConnectionManager] that holds this worker
         */
        val connection: ConnectionManager,
        private val maxWorkerSleep: Long
) : CoroutineDispatcher(), AutoCloseable {
    private val connectionQueue = ConcurrentLinkedQueue<Pair<Long, suspend CoroutineScope.(Connection) -> Unit>>()
    private val connections = ArrayList<ConnectionHandle>()
    private val queue = TaskQueue<() -> Unit>()
    val selector = Selector.open()

    /**
     * Returns an estimate for how many connections this worker is processing
     *
     * Note: This technically violates thread-safety, hence the value should be
     * taken with a grain of salt
     * @return The amount of connections on this worker
     */
    val connectionCount: Int
        get() = connections.size

    /**
     * Adds a new connection to this worker
     * @param timeout Initial timeout of the connection, negative for no timeout
     * @param block Code that will be executed on this worker's thread
     */
    fun addConnection(timeout: Long,
                      block: suspend CoroutineScope.(Connection) -> Unit) {
        connectionQueue.add(Pair(timeout, block))
        wake()
    }

    /**
     * Executes this worker on the current thread
     *
     * **Note:** Should never be called twice or concurrently
     */
    fun run(stop: AtomicBoolean) {
        while (!stop.get()) {
            queue.processCurrent()
            if (connectionQueue.isNotEmpty()) {
                while (connectionQueue.isNotEmpty()) {
                    val (initialTimeout, coroutine) = connectionQueue.poll()
                            ?: continue
                    val requestClose = AtomicBoolean()
                    val timeout = if (initialTimeout < 0) {
                        null
                    } else {
                        AtomicLong(systemClock.timeMillis() + initialTimeout)
                    }
                    val connection = Connection(requestClose, timeout)
                    val job = launch(this) {
                        coroutine(connection)
                    }
                    val close = ConnectionHandle(job, requestClose)
                    connections.add(close)
                    if (timeout != null) {
                        launch(this) {
                            while (job.isActive) {
                                if (systemClock.timeMillis() > timeout.get()) {
                                    job.cancel(CancellationException("Timeout"))
                                }
                                yield()
                            }
                        }
                    }
                    job.invokeOnCompletion {
                        connections.remove(close)
                    }
                }
            } else if (!stop.get()) {
                val sleep = if (connections.isEmpty()) 0 else maxWorkerSleep
                sleep(sleep)
            }
        }
        connections.forEach { it.requestClose.set(true) }
        val stopTimeout = System.nanoTime()
        while (connections.isNotEmpty() && System.nanoTime() - stopTimeout < 10000000000L) {
            queue.processCurrent()
            if (!stop.get()) {
                sleep(10)
            }
        }
        connections.forEach {
            queue.add {
                it.job.cancel(CancellationException("Killing worker"))
            }
        }
        while (connections.isNotEmpty()) {
            queue.processDrain()
        }
    }

    fun wake() {
        try {
            selector.wakeup()
        } catch (e: ClosedSelectorException) {
        }
    }

    fun sleep(time: Long) {
        try {
            selector.select(time)
            selector.selectedKeys().clear()
        } catch (e: IOException) {
            logger.warn { "Error when waiting with selector: $e" }
        } catch (e: ClosedSelectorException) {
        }
    }

    override fun close() {
        selector.close()
    }

    override fun dispatch(context: CoroutineContext,
                          block: Runnable) {
        queue.add {
            try {
                block.run()
            } catch (e: CancellationException) {
                logger.warn { "Job cancelled: ${e.message}" }
            }
        }
    }

    companion object : KLogging()

    private class ConnectionHandle(val job: Job,
                                   val requestClose: AtomicBoolean)
}
