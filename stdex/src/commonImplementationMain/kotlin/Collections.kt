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

package org.tobi29.stdex

actual interface Queue<E> : MutableCollection<E> {
    actual fun offer(element: E): Boolean
    actual fun remove(): E
    actual fun poll(): E?
    actual fun element(): E
    actual fun peek(): E?
}

actual abstract class AbstractQueue<E> /* protected actual constructor(
) */ : AbstractCollection<E>(), Queue<E> {
    actual override fun add(element: E): Boolean =
        offer(element) || throw IllegalStateException("Queue full")

    actual override fun addAll(elements: Collection<E>): Boolean {
        require(elements !== this)
        var modified = false
        for (e in elements) {
            if (add(e)) modified = true
        }
        return modified
    }

    actual override fun remove(): E =
        poll() ?: throw NoSuchElementException()

    actual override fun element(): E =
        peek() ?: throw NoSuchElementException()

    actual override fun clear() {
        while (true) {
            poll() ?: break
        }
    }
}

actual interface Deque<E> : Queue<E> {
    actual fun addFirst(element: E)
    actual fun addLast(element: E)
    actual fun offerFirst(element: E): Boolean
    actual fun offerLast(element: E): Boolean
    actual fun removeFirst(): E
    actual fun removeLast(): E
    actual fun pollFirst(): E?
    actual fun pollLast(): E?
    actual fun getFirst(): E
    actual fun getLast(): E
    actual fun peekFirst(): E
    actual fun peekLast(): E
    actual fun removeFirstOccurrence(element: Any): Boolean
    actual fun removeLastOccurrence(element: Any): Boolean
    actual fun push(element: E)
    actual fun pop(): E
    actual fun descendingIterator(): MutableIterator<E>
}

actual interface ConcurrentMap<K, V> : MutableMap<K, V> {
    actual fun replace(key: K, value: V): V?
    actual fun replace(key: K, oldValue: V, newValue: V): Boolean
    actual fun putIfAbsent(key: K, value: V): V?
    actual fun remove(key: K, value: V): Boolean
}

actual class ConcurrentHashSet<E> : MutableSet<E> {
    private val map = ConcurrentHashMap<E, Unit>()

    override fun addAll(elements: Collection<E>): Boolean {
        var added = false
        for (element in elements) {
            added = add(element) || added
        }
        return added
    }

    override fun removeAll(elements: Collection<E>) =
        map.keys.removeAll(elements)

    override fun retainAll(elements: Collection<E>) =
        map.keys.retainAll(elements)

    override fun contains(element: E) = map.keys.contains(element)
    override fun containsAll(elements: Collection<E>) =
        map.keys.containsAll(elements)

    override fun isEmpty() = map.isEmpty()

    override val size get() = map.size

    override fun add(element: E) = map.put(element, Unit) == null
    override fun remove(element: E) = map.remove(element) != null
    override fun clear() = map.clear()
    override fun iterator(): MutableIterator<E> = map.keys.iterator()

    override fun equals(other: Any?) = map.keys == other
    override fun hashCode() = map.keys.hashCode()
    override fun toString() = map.keys.toString()
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> Collection<T>.readOnly(): Collection<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> List<T>.readOnly(): List<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> Set<T>.readOnly(): Set<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> Map<K, V>.readOnly(): Map<K, V> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> Collection<T>.synchronized(): Collection<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> MutableCollection<T>.synchronized(): MutableCollection<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> List<T>.synchronized(): List<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> MutableList<T>.synchronized(): MutableList<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> Set<T>.synchronized(): Set<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <T> MutableSet<T>.synchronized(): MutableSet<T> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> Map<K, V>.synchronized(): Map<K, V> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> MutableMap<K, V>.synchronized(): MutableMap<K, V> =
    this

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <reified E : Enum<E>, V> EnumMap(): MutableMap<E, V> =
    HashMap()

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V : Any> MutableMap<K, V>.computeAlways(
    key: K, block: (K, V?) -> V
): V {
    val old = this[key]
    val new = block(key, old)
    this[key] = new
    return new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V : Any> ConcurrentMap<K, V>.computeAlways(
    key: K, block: (K, V?) -> V
): V {
    val old = this[key]
    val new = block(key, old)
    this[key] = new
    return new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> MutableMap<K, V>.computeAlways(
    key: K, block: (K, V?) -> V?
): V? {
    val old = this[key]
    val new = block(key, old)
    if (new != null) {
        this[key] = new
    } else if (old != null || containsKey(key)) {
        remove(key)
    }
    return new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> ConcurrentMap<K, V>.computeAlways(
    key: K, block: (K, V?) -> V?
): V? {
    val old = this[key]
    val new = block(key, old)
    if (new != null) {
        this[key] = new
    } else if (old != null || containsKey(key)) {
        remove(key)
    }
    return new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V : Any> MutableMap<K, V>.computeAbsent(
    key: K, block: (K) -> V
): V {
    this[key]?.let { return it }
    val new = block(key)
    return putIfAbsent(key, new) ?: new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V : Any> ConcurrentMap<K, V>.computeAbsent(
    key: K, block: (K) -> V
): V {
    this[key]?.let { return it }
    val new = block(key)
    return putIfAbsent(key, new) ?: new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> MutableMap<K, V>.computeAbsent(
    key: K, block: (K) -> V?
): V? {
    this[key]?.let { return it }
    val new = block(key) ?: return null
    return putIfAbsent(key, new) ?: new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> ConcurrentMap<K, V>.computeAbsent(
    key: K, block: (K) -> V?
): V? {
    this[key]?.let { return it }
    val new = block(key) ?: return null
    return putIfAbsent(key, new) ?: new
}

@InlineUtility
@Suppress("NOTHING_TO_INLINE")
actual inline fun <K, V> MutableMap<K, V>.removeEqual(
    key: K, value: V
): Boolean = if (this[key] == value) {
    remove(key)
    true
} else false
