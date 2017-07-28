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

@file:Suppress("NOTHING_TO_INLINE")

package org.tobi29.scapes.engine.utils

/**
 * Filters out elements of the wrong type and casts them
 * @param T The type to cast to
 * @receiver The sequence of elements to map
 * @returns A lazy sequence
 */
inline fun <reified T : Any> Sequence<*>.filterMap(): Sequence<T> {
    return mapNotNull { it as? T }
}

/**
 * Find the first element of correct type and casts it
 * @param T The type to cast to
 * @receiver The elements to search in
 * @returns The first casted element or `null`
 */
inline fun <reified T : Any> Sequence<*>.findMap(): T? {
    return find { it is T } as? T
}

/**
 * Find the first element of correct type and casts it
 * @param T The type to cast to
 * @receiver The elements to search in
 * @returns The first casted element or `null`
 */
inline fun <reified T : Any> Iterable<*>.findMap(): T? {
    return find { it is T } as? T
}

/**
 * Find the first element of correct type and casts it
 * @param T The type to cast to
 * @receiver The elements to search in
 * @returns The first casted element or `null`
 */
inline fun <reified T : Any> Array<*>.findMap(): T? {
    return find { it is T } as? T
}

/**
 * Takes all elements of a sequence and puts them into an array
 * @param T The type of elements
 * @receiver The sequence of elements to collect
 * @returns A new array containing
 */
inline fun <reified T> Sequence<T>.toArray(): Array<T> {
    return toList().toTypedArray()
}

/**
 * Constructs an infinite sequence starting with all the elements in the given
 * one and filling the rest with `null`
 * @receiver The sequence to start with
 * @returns An infinite sequence
 */
fun <T> Sequence<T>.andNull() = Sequence {
    val iterator = iterator()
    object : Iterator<T?> {
        override fun hasNext() = true

        override fun next(): T? {
            return if (iterator.hasNext()) iterator.next() else null
        }
    }
}

/**
 * Accumulates value starting with the first element and applying [operation]
 * from left to right to current accumulator value and each element.
 * @param S Element type
 * @param T Element type
 * @param operation Function that takes the current accumulator value and the element itself and calculates the next accumulator value
 * @receiver The sequence of elements to reduce
 * @returns The resulting element or null if called on empty sequence
 */
inline fun <S, T : S> Sequence<T>.reduceOrNull(operation: (S, T) -> S): S? {
    val iterator = this.iterator()
    if (!iterator.hasNext()) {
        return null
    }
    var accumulator: S = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation]
 * from left to right to current accumulator value and each element with its
 * index in the original sequence.
 * @param S Element type
 * @param T Element type
 * @param operation Function that takes the index of an element, current accumulator value and the element itself and calculates the next accumulator value
 * @receiver The sequence of elements to reduce
 * @returns The resulting element or null if called on empty sequence
 */
inline fun <S, T : S> Sequence<T>.reduceIndexedOrNull(operation: (Int, S, T) -> S): S? {
    val iterator = this.iterator()
    if (!iterator.hasNext()) {
        return null
    }
    var index = 1
    var accumulator: S = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(index++, accumulator, iterator.next())
    }
    return accumulator
}

inline fun <T> Iterator(crossinline block: () -> T?): Iterator<T> {
    return object : Iterator<T> {
        private var next: T? = null
        private var init = false

        // We have this in a function to only inline once, but still have a
        // non-virtual call
        private fun iterate() {
            next = block()
        }

        // Used to avoid having to call invoke() before actually evaluating
        // Makes this properly lazy
        private fun touch() {
            if (!init) {
                init = true
                iterate()
            }
        }

        override fun hasNext(): Boolean {
            touch()
            return next != null
        }

        override fun next(): T {
            touch()
            val element = next ?: throw NoSuchElementException(
                    "No more elements in iterator")
            iterate()
            return element
        }
    }
}

fun <T : Comparable<T>> comparator(): Comparator<T> =
        object : Comparator<T> {
            override fun compare(a: T,
                                 b: T) = a.compareTo(b)
        }
