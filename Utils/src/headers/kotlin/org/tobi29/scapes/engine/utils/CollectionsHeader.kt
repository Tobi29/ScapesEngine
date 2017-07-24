package org.tobi29.scapes.engine.utils

header class ConcurrentLinkedQueue<E> : Queue<E> {
    override val size: Int

    override fun contains(element: E): Boolean
    override fun containsAll(elements: Collection<E>): Boolean
    override fun isEmpty(): Boolean
    override fun offer(element: E): Boolean
    override fun remove(): E
    override fun poll(): E?
    override fun element(): E
    override fun peek(): E
    override fun add(element: E): Boolean
    override fun addAll(elements: Collection<E>): Boolean
    override fun clear()
    override fun iterator(): MutableIterator<E>
    override fun remove(element: E): Boolean
    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
}

header class ArrayDeque<E : Any> : Deque<E> {
    constructor()
    constructor(size: Int)

    override val size: Int

    override fun contains(element: E): Boolean
    override fun containsAll(elements: Collection<E>): Boolean
    override fun isEmpty(): Boolean
    override fun offer(element: E): Boolean
    override fun remove(): E
    override fun poll(): E?
    override fun element(): E
    override fun peek(): E
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
    override fun removeFirstOccurrence(element: E): Boolean
    override fun removeLastOccurrence(element: E): Boolean
    override fun push(element: E)
    override fun pop(): E
    override fun descendingIterator(): MutableIterator<E>
    override fun add(element: E): Boolean
    override fun addAll(elements: Collection<E>): Boolean
    override fun clear()
    override fun iterator(): MutableIterator<E>
    override fun remove(element: E): Boolean
    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
}

header class ConcurrentHashMap<K, V> : ConcurrentMap<K, V> {
    override val size: Int
    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
    override val keys: MutableSet<K>
    override val values: MutableCollection<V>

    override fun containsKey(key: K): Boolean
    override fun containsValue(value: V): Boolean
    override fun get(key: K): V?
    override fun isEmpty(): Boolean
    override fun clear()
    override fun putAll(from: Map<out K, V>)
    override fun remove(key: K): V?
    override fun put(key: K,
                     value: V): V?

    open fun replace(key: K,
                     oldValue: V,
                     newValue: V): Boolean
}

header class ConcurrentHashSet<E> : MutableSet<E> {
    override fun add(element: E): Boolean
    override fun addAll(elements: Collection<E>): Boolean
    override fun clear()
    override fun iterator(): MutableIterator<E>
    override fun remove(element: E): Boolean
    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
    override val size: Int
    override fun contains(element: E): Boolean
    override fun containsAll(elements: Collection<E>): Boolean
    override fun isEmpty(): Boolean
}

header class ConcurrentSortedMap<K : Comparable<K>, V> : AbstractMap<K, V>(), ConcurrentMap<K, V> {
    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
    override val keys: MutableSet<K>
    override val values: MutableCollection<V>

    override fun put(key: K,
                     value: V): V?

    override fun putAll(from: Map<out K, V>)

    override fun remove(key: K): V?

    override fun clear()
}

header class ConcurrentSortedSet<T : Comparable<T>> : AbstractSet<T>(), MutableSet<T> {
    override val size: Int
    override fun isEmpty(): Boolean
    override fun iterator(): MutableIterator<T>
    override fun add(element: T): Boolean
    override fun addAll(elements: Collection<T>): Boolean
    override fun clear()
    override fun remove(element: T): Boolean
    override fun removeAll(elements: Collection<T>): Boolean
    override fun retainAll(elements: Collection<T>): Boolean
    override fun contains(element: T): Boolean
    override fun containsAll(elements: Collection<T>): Boolean
}
