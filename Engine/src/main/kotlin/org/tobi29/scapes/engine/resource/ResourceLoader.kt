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

package org.tobi29.scapes.engine.resource

import kotlinx.coroutines.experimental.suspendCancellableCoroutine
import org.tobi29.scapes.engine.utils.Result
import org.tobi29.scapes.engine.utils.task.TaskExecutor
import org.tobi29.scapes.engine.utils.task.TaskLock

class ResourceLoader(private val taskExecutor: TaskExecutor) {
    private val tasks = TaskLock()

    fun <T : Any> load(supplier: suspend () -> T): Resource<T> {
        val reference = ResourceReference<T>()
        tasks.increment()
        taskExecutor.runTask({
            try {
                reference.value = Result.Ok(supplier())
            } catch(e: Throwable) {
                reference.value = Result.Error(e)
            } finally {
                tasks.decrement()
            }
        }, "Load-Resource")
        return reference.resource
    }

    fun onDone(block: () -> Unit) = tasks.onDone(block)

    fun isDone() = tasks.isDone()
}

suspend fun ResourceLoader.awaitDone() {
    return suspendCancellableCoroutine { cont ->
        onDone { cont.resume(Unit) }
    }
}
