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

import kotlin.properties.ReadWriteProperty

/**
 * Constructor for creating a [ThreadLocal] from a lambda expression
 * @param initial: Supplier that will be called once per thread
 * @param T: The type of the elements in the [ThreadLocal]
 */
expect class ThreadLocal<T>(
    initial: () -> T
) : ReadWriteProperty<Any?, T> {
    fun set(value: T)
    fun get(): T
    fun remove()
}
