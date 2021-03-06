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

package org.tobi29.assertions.suites

import org.tobi29.arrays.sliceOver
import org.tobi29.math.Random

fun createByteArrays(
    amount: Int = 64,
    sizeBits: Int = 4,
    seed: Long = 0L
): Sequence<ByteArray> = sequence {
    val random = Random(seed)
    for (it in 0 until amount) {
        val array = ByteArray(it shl sizeBits)
        random.nextBytes(array.sliceOver())
        yield(array)
    }
}
