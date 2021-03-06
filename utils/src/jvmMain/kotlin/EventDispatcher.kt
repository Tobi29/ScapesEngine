/*
 * Copyright 2012-2019 Tobi29
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

package org.tobi29.utils

import org.tobi29.stdex.ConcurrentHashSet
import org.tobi29.stdex.atomic.AtomicBoolean
import org.tobi29.stdex.atomic.AtomicLong
import org.tobi29.stdex.computeAbsent
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListSet
import kotlin.reflect.KClass

actual class EventDispatcher internal actual constructor(
    private val parent: EventDispatcher?
) {
    private val root = findRoot()
    private val children = ConcurrentHashSet<EventDispatcher>()
    private val activeListeners =
        ConcurrentHashMap<KClass<*>, MutableSet<Listener<*>>>()
    internal val listeners =
        ConcurrentHashMap<KClass<*>, MutableSet<Listener<*>>>()
    private val enabled = AtomicBoolean(parent == null)

    actual constructor() : this(null)

    @Synchronized
    actual fun enable() {
        val parent = parent ?: return
        if (!enabled.getAndSet(true)) {
            parent.children.add(this)
            var toRoot: EventDispatcher? = parent
            while (toRoot != null) {
                if (!toRoot.enabled.get()) {
                    return
                }
                toRoot = toRoot.parent
            }
            activate()
        }
    }

    @Synchronized
    actual fun disable() {
        val parent = parent ?: return
        if (enabled.getAndSet(false)) {
            parent.children.remove(this)
            deactivate()
        }
    }

    private fun activate() {
        for ((clazz, set) in listeners) {
            val activeList = root.activeListeners.computeAbsent(
                clazz
            ) { ConcurrentSkipListSet<Listener<*>>() }
            activeList.addAll(set)
        }
        children.forEach { it.activate() }
    }

    private fun deactivate() {
        for ((clazz, set) in listeners) {
            root.activeListeners[clazz]?.removeAll(set)
        }
        children.forEach { it.deactivate() }
    }

    actual fun <E : Any> fire(event: E) {
        root.activeListeners[event::class]?.let {
            @Suppress("UNCHECKED_CAST")
            (it as Iterable<Listener<E>>).forEach {
                if (it.accepts(event)) {
                    it(event)
                }
            }
        }
    }

    private fun findRoot(): EventDispatcher {
        var root = this
        var parent = root.parent
        while (parent != null) {
            root = parent
            parent = root.parent
        }
        return root
    }
}

actual class ListenerRegistrar internal actual constructor(actual val events: EventDispatcher) {
    fun <E : Any> listen(
        clazz: KClass<E>,
        priority: Int,
        accepts: (E) -> Boolean,
        listener: (E) -> Unit
    ) {
        val list = events.listeners.computeAbsent(clazz) {
            ConcurrentSkipListSet<Listener<*>>()
        }
        val reference = Listener(priority, accepts, listener)
        list.add(reference)
    }

    actual inline fun <reified E : Any> listen(
        noinline listener: (E) -> Unit
    ) {
        listen(0, listener)
    }

    actual inline fun <reified E : Any> listen(
        priority: Int,
        noinline listener: (E) -> Unit
    ) {
        listen(priority, { true }, listener)
    }

    actual inline fun <reified E : Any> listen(
        noinline accepts: (E) -> Boolean,
        noinline listener: (E) -> Unit
    ) {
        listen(0, accepts, listener)
    }

    actual inline fun <reified E : Any> listen(
        priority: Int,
        noinline accepts: (E) -> Boolean,
        noinline listener: (E) -> Unit
    ) {
        listen(E::class, priority, accepts, listener)
    }
}

internal data class Listener<in E : Any>(
    internal val priority: Int,
    internal val accepts: (E) -> Boolean,
    internal val listener: (E) -> Unit
) : Comparable<Listener<*>> {
    private val uid = UID_COUNTER.andIncrement

    @Suppress("KDocMissingDocumentation")
    override fun compareTo(other: Listener<*>): Int {
        if (priority > other.priority) {
            return -1
        }
        if (priority < other.priority) {
            return 1
        }
        if (uid > other.uid) {
            return 1
        }
        if (uid < other.uid) {
            return -1
        }
        return 0
    }

    internal operator fun invoke(event: E) {
        listener(event)
    }

    companion object {
        private val UID_COUNTER = AtomicLong(Long.MIN_VALUE)
    }
}
