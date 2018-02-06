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

package org.tobi29.math.vector

import org.tobi29.arrays.Doubles
import org.tobi29.io.tag.ReadTagMutableMap
import org.tobi29.io.tag.toDouble

data class MutableVector2d(
    override var x: Double = 0.0,
    override var y: Double = 0.0
) : ReadVector2d, Doubles {
    constructor(vector: Vector2d) : this(vector.x, vector.y)

    constructor(vector: Vector2i) : this(
        vector.x.toDouble(),
        vector.y.toDouble()
    )

    constructor(vector: MutableVector2d) : this(vector.x, vector.y)

    constructor(vector: MutableVector2i) : this(
        vector.x.toDouble(),
        vector.y.toDouble()
    )

    fun now(): Vector2d = Vector2d(x, y)

    override fun set(
        index: Int,
        value: Double
    ): Unit = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("$index")
    }

    fun setX(x: Double) = apply {
        this.x = x
    }

    fun setY(y: Double) = apply {
        this.y = y
    }

    fun setXY(
        x: Double,
        y: Double
    ) = apply {
        this.x = x
        this.y = y
    }

    fun set(a: Vector2d) = apply {
        x = a.x
        y = a.y
    }

    fun set(a: MutableVector2d) = apply {
        x = a.x
        y = a.y
    }

    fun negate() = apply {
        x = -x
        y = -y
    }

    fun add(a: Double) = apply {
        x += a
        y += a
    }

    fun addX(x: Double) = apply {
        this.x += x
    }

    fun addY(y: Double) = apply {
        this.y += y
    }

    fun add(vector: Vector2d) = apply {
        x += vector.x
        y += vector.y
    }

    fun add(vector: MutableVector2d) = apply {
        x += vector.x
        y += vector.y
    }

    fun subtract(a: Double) = apply {
        x -= a
        y -= a
    }

    fun subtract(vector: Vector2d) = apply {
        x -= vector.x
        y -= vector.y
    }

    fun subtract(vector: MutableVector2d) = apply {
        x -= vector.x
        y -= vector.y
    }

    fun multiply(a: Double) = apply {
        x *= a
        y *= a
    }

    fun multiply(vector: Vector2d) = apply {
        x *= vector.x
        y *= vector.y
    }

    fun multiply(vector: MutableVector2d) = apply {
        x *= vector.x
        y *= vector.y
    }

    fun divide(a: Double) = apply {
        x /= a
        y /= a
    }

    fun divide(vector: Vector2d) = apply {
        x /= vector.x
        y /= vector.y
    }

    fun divide(vector: MutableVector2d) = apply {
        x /= vector.x
        y /= vector.y
    }

    fun set(map: ReadTagMutableMap) {
        map["X"]?.toDouble()?.let { x = it }
        map["Y"]?.toDouble()?.let { y = it }
    }
}
