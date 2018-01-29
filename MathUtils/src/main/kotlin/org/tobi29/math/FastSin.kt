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

/*
 * Taken from http://www.java-gaming.org/index.php?topic=24191.0
 */
package org.tobi29.math

import org.tobi29.stdex.math.HALF_PI
import org.tobi29.stdex.math.TWO_PI
import org.tobi29.stdex.math.mix
import org.tobi29.stdex.math.remP

val FastSin = SinLUT(12)

class SinLUT(bits: Int) {
    private val mask = (-1 shl bits).inv()
    private val rad2IndexF: Float
    private val rad2IndexD: Double
    private val sin: FloatArray

    init {
        val count = mask + 1
        rad2IndexD = count / TWO_PI
        rad2IndexF = rad2IndexD.toFloat()
        sin = FloatArray(count)
        for (i in 0 until count) {
            sin[i] = kotlin.math.sin(i.toFloat() / count * TWO_PI.toFloat())
        }
        // Set exact values
        sin[0] = 0.0f
        sin[count shr 2] = 1.0f
        sin[count shr 1] = 0.0f
        sin[(count shr 2) * 3] = -1.0f
    }

    fun sin(value: Float): Float {
        val fi = (value remP TWO_PI.toFloat()) * rad2IndexF
        val i = fi.toInt()
        val i1 = i and mask
        val i2 = (i + 1) and mask
        return mix(sin[i1], sin[i2], fi - i)
    }

    fun cos(value: Float): Float = sin(value + HALF_PI.toFloat())

    fun sin(value: Double): Double {
        val fi = (value remP TWO_PI) * rad2IndexD
        val i = fi.toInt()
        val i1 = i and mask
        val i2 = (i + 1) and mask
        return mix(sin[i1].toDouble(), sin[i2].toDouble(), fi - i)
    }

    fun cos(value: Double): Double = sin(value + HALF_PI)
}