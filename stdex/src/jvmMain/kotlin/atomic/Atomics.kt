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

@file:JvmName("AtomicsJVMKt")

package org.tobi29.stdex.atomic

actual typealias AtomicReference<T> = java.util.concurrent.atomic.AtomicReference<T>

actual typealias AtomicArray<E> = java.util.concurrent.atomic.AtomicReferenceArray<E>

actual inline fun <reified E> AtomicArray(
    length: Int,
    crossinline init: (Int) -> E
): AtomicArray<E> = AtomicArray<E>(length).apply {
    for (i in 0 until length) this[i] = init(i)
}

actual inline fun <reified E> atomicArrayOf(size: Int) = AtomicArray<E?>(size)

actual typealias AtomicBoolean = java.util.concurrent.atomic.AtomicBoolean

actual typealias AtomicInt = java.util.concurrent.atomic.AtomicInteger

actual typealias AtomicLong = java.util.concurrent.atomic.AtomicLong
