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

package org.tobi29.scapes.engine.utils

expect interface Queue<E> : MutableCollection<E> {
    fun offer(element: E): Boolean
    fun remove(): E
    fun poll(): E?
    fun element(): E
    fun peek(): E
}

expect interface Deque<E> : Queue<E> {
    fun addFirst(element: E)
    fun addLast(element: E)
    fun offerFirst(element: E): Boolean
    fun offerLast(element: E): Boolean
    fun removeFirst(): E
    fun removeLast(): E
    fun pollFirst(): E?
    fun pollLast(): E?
    fun getFirst(): E
    fun getLast(): E
    fun peekFirst(): E
    fun peekLast(): E
    fun removeFirstOccurrence(element: Any): Boolean
    fun removeLastOccurrence(element: Any): Boolean
    fun push(element: E)
    fun pop(): E
    fun descendingIterator(): MutableIterator<E>
}

expect class ArrayDeque<E : Any>() : Deque<E> {
    constructor(size: Int)

    override val size: Int
    override fun contains(element: E): Boolean
    override fun isEmpty(): Boolean
    override fun iterator(): MutableIterator<E>
    override fun remove(element: E): Boolean
    override fun clear()

    override fun offer(element: E): Boolean
    override fun remove(): E
    override fun poll(): E?
    override fun element(): E
    override fun peek(): E

    override fun containsAll(elements: Collection<E>): Boolean
    override fun addAll(elements: Collection<E>): Boolean
    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
    override fun add(element: E): Boolean

    override fun addFirst(element: E)
    override fun addLast(element: E)
    override fun offerFirst(element: E): Boolean
    override fun offerLast(element: E): Boolean
    override fun removeFirst(): E
    override fun removeLast(): E
    override fun pollFirst(): E?
    override fun pollLast(): E?
    override fun getFirst(): E
    override fun getLast(): E
    override fun peekFirst(): E
    override fun peekLast(): E
    override fun removeFirstOccurrence(element: Any): Boolean
    override fun removeLastOccurrence(element: Any): Boolean
    override fun push(element: E)
    override fun pop(): E
    override fun descendingIterator(): MutableIterator<E>
}

expect interface ConcurrentMap<K, V> : MutableMap<K, V> {
    fun putIfAbsent(key: K,
                    value: V): V?

    fun remove(key: K,
               value: V): Boolean

    fun replace(key: K,
                oldValue: V,
                newValue: V): Boolean

    fun replace(key: K,
                value: V): V?
}

expect class ConcurrentHashMap<K, V>() : ConcurrentMap<K, V> {
    override val size: Int
    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
    override val keys: MutableSet<K>
    override val values: MutableCollection<V>
    override fun isEmpty(): Boolean
    override fun containsKey(key: K): Boolean
    override fun containsValue(value: V): Boolean
    override fun get(key: K): V?
    override fun put(key: K,
                     value: V): V?

    override fun putAll(from: Map<out K, V>)
    override fun putIfAbsent(key: K,
                             value: V): V?

    override fun remove(key: K): V?

    override fun remove(key: K,
                        value: V): Boolean

    override fun replace(key: K,
                         value: V): V?

    override fun replace(key: K,
                         oldValue: V,
                         newValue: V): Boolean

    override fun clear()
}

expect class ConcurrentHashSet<E>() : MutableSet<E> {
    override val size: Int
    override fun isEmpty(): Boolean
    override fun contains(element: E): Boolean
    override fun containsAll(elements: Collection<E>): Boolean
    override fun iterator(): MutableIterator<E>
    override fun add(element: E): Boolean
    override fun addAll(elements: Collection<E>): Boolean
    override fun remove(element: E): Boolean
    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
    override fun clear()
}

expect class ConcurrentSortedMap<K : Comparable<K>, V>() : ConcurrentMap<K, V> {
    override val size: Int
    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
    override val keys: MutableSet<K>
    override val values: MutableCollection<V>
    override fun isEmpty(): Boolean
    override fun containsKey(key: K): Boolean
    override fun containsValue(value: V): Boolean
    override fun get(key: K): V?
    override fun put(key: K,
                     value: V): V?

    override fun putAll(from: Map<out K, V>)
    override fun putIfAbsent(key: K,
                             value: V): V?

    override fun remove(key: K): V?

    override fun remove(key: K,
                        value: V): Boolean

    override fun replace(key: K,
                         value: V): V?

    override fun replace(key: K,
                         oldValue: V,
                         newValue: V): Boolean

    override fun clear()
}

expect class ConcurrentSortedSet<T : Comparable<T>>() : MutableSet<T> {
    override val size: Int
    override fun isEmpty(): Boolean
    override fun contains(element: T): Boolean
    override fun containsAll(elements: Collection<T>): Boolean
    override fun iterator(): MutableIterator<T>
    override fun add(element: T): Boolean
    override fun addAll(elements: Collection<T>): Boolean
    override fun remove(element: T): Boolean
    override fun removeAll(elements: Collection<T>): Boolean
    override fun retainAll(elements: Collection<T>): Boolean
    override fun clear()
}
