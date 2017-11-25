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

package org.tobi29.scapes.engine.utils.io

import org.tobi29.scapes.engine.utils.ByteArraySliceRO
import org.tobi29.scapes.engine.utils.splitToBytes
import org.tobi29.scapes.engine.utils.utf8ToArray

/**
 * Interface for blocking write operations, with an extensive set of operations
 * to make implementing protocols easier
 */
interface WritableByteStream : Appendable {
    /**
     * Write the contents of the given buffer to the stream
     * @param buffer Buffer to read from
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun put(buffer: ByteArraySliceRO): WritableByteStream = apply {
        for (i in 0 until buffer.size) {
            put(buffer[i])
        }
    }

    /**
     * Writes `1` into the stream if [value] is `true` or `0` otherwise
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putBoolean(value: Boolean): WritableByteStream =
            put(if (value) 1.toByte() else 0)

    /**
     * Writes the byte into the stream
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun put(b: Byte): WritableByteStream

    /**
     * Writes the big-endian short into the stream
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putShort(value: Short): WritableByteStream =
            value.splitToBytes { b1, b0 ->
                put(b1)
                put(b0)
            }

    /**
     * Writes the big-endian integer into the stream
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putInt(value: Int): WritableByteStream =
            value.splitToBytes { b3, b2, b1, b0 ->
                put(b3)
                put(b2)
                put(b1)
                put(b0)
            }

    /**
     * Writes the big-endian long into the stream
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putLong(value: Long): WritableByteStream =
            value.splitToBytes { b7, b6, b5, b4, b3, b2, b1, b0 ->
                put(b7)
                put(b6)
                put(b5)
                put(b4)
                put(b3)
                put(b2)
                put(b1)
                put(b0)
            }

    /**
     * Writes the big-endian float into the stream
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putFloat(value: Float): WritableByteStream =
            putInt(value.toRawBits())

    /**
     * Writes the big-endian double into the stream
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putDouble(value: Double): WritableByteStream =
            putLong(value.toRawBits())

    /**
     * Writes the byte array to the stream, prefixed by the length
     *
     * Format for length is either a single unsigned byte or 0xFF followed
     * by a big-endian int
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putByteArray(value: ByteArray): WritableByteStream {
        if (value.size < 0xFF) {
            put(value.size.toByte())
        } else {
            put(0xFF.toByte())
            putInt(value.size)
        }
        return put(value.view)
    }

    /**
     * Writes the byte array to the stream, prefixed by the length
     *
     * Format for length is either a big-endian unsigned short or 0xFFFF
     * followed by a big-endian inth
     * @param value The value to write
     * @throws IOException When an IO error occurs
     * @return The current stream
     */
    fun putByteArrayLong(value: ByteArray): WritableByteStream {
        if (value.size < 0xFFFF) {
            putShort(value.size.toShort())
        } else {
            putShort(0xFFFF.toShort())
            putInt(value.size)
        }
        return put(value.view)
    }

    /**
     * Writes the string to the stream, encoded in UTF-8 and prefixes by length
     *
     * The format is consistent to first encoding the string in UTF-8 and then
     * writing the array using [putByteArray]
     * @param value The value to write
     * @throws IOException When an IO error occurs or limit was broken
     * @return The current stream
     */
    fun putString(value: String): WritableByteStream =
            putByteArray(value.utf8ToArray())

    override fun append(c: Char): Appendable {
        put(c.toString().utf8ToArray().view)
        return this
    }

    override fun append(csq: CharSequence?): Appendable =
            append(csq, 0, csq?.length ?: 4) // "null" is of length 4

    override fun append(csq: CharSequence?,
                        start: Int,
                        end: Int): Appendable {
        val str = csq?.toString() ?: "null"
        put(str.utf8ToArray().view)
        return this
    }
}
