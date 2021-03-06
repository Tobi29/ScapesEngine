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

@file:Suppress("NOTHING_TO_INLINE")

package org.tobi29.io

import org.tobi29.arrays.Bytes
import org.tobi29.arrays.BytesRO
import org.tobi29.arrays.HeapBytes
import org.tobi29.stdex.BIG_ENDIAN
import org.tobi29.stdex.LITTLE_ENDIAN
import org.tobi29.stdex.NATIVE_ENDIAN
import java.nio.Buffer
import java.nio.ByteBuffer

/**
 * Returns a view on the given array
 * @param offset Offset in the array
 * @param size Length in the array
 * @receiver The array to back into
 * @return A [ByteBuffer] using the array for storage
 */
inline fun ByteArray.asByteBuffer(offset: Int = 0,
                                  size: Int = this.size - offset): ByteBuffer =
        ByteBuffer.wrap(this, offset, size)

/**
 * Creates a [ByteBuffer] with big-endian byte-order
 * @param size Capacity of the buffer
 * @return A [ByteBuffer] with big-endian byte-order
 */
inline fun ByteBuffer(size: Int): ByteBuffer =
        ByteBuffer.allocate(size)

fun ByteBufferNative(capacity: Int): ByteBuffer =
        ByteBuffer.allocateDirect(capacity).order(NATIVE_ENDIAN)

/**
 * Fills a buffer with the given value
 * @receiver Buffer to fill
 * @param supplier Supplier called for each value written to the buffer
 * @return The given buffer
 */
inline fun ByteBuffer.fill(supplier: () -> Byte): ByteBuffer {
    while (hasRemaining()) {
        put(supplier())
    }
    return this
}

inline fun <R> Bytes.mutateAsByteBuffer(block: (ByteBuffer) -> R): R {
    var buffer = asByteBuffer()
    val view = if (buffer == null) {
        buffer = ByteBuffer(size)
        if (this is MemorySegmentE) {
            buffer.order(if (isBigEndian) BIG_ENDIAN else LITTLE_ENDIAN)
        }
        buffer.viewE.also { getBytes(0, it) }
    } else this
    return try {
        block(buffer)
    } finally {
        if (view !== this) view.getBytes(0, this)
    }
}

fun BytesRO.readAsByteBuffer(): ByteBuffer =
        asByteBuffer() ?: ByteBuffer(size).also { buffer ->
            if (this is MemorySegmentE) {
                buffer.order(if (isBigEndian) BIG_ENDIAN else LITTLE_ENDIAN)
            }
            getBytes(0, buffer.viewE)
        }

fun BytesRO.asByteBuffer(): ByteBuffer? = when (this) {
    is ByteBufferView -> byteBuffer.slice().order(byteBuffer.order())
    is HeapBytes -> array.asByteBuffer(offset, size).slice().also {
        if (this is MemorySegmentE) {
            it.order(if (isBigEndian) BIG_ENDIAN else LITTLE_ENDIAN)
        }
    }
    else -> null
}

inline fun <R> Bytes.mutateAsNativeByteBuffer(block: (ByteBuffer) -> R): R {
    var buffer = asNativeByteBuffer()
    val view = if (buffer == null) {
        buffer = ByteBufferNative(size)
        if (this is MemorySegmentE) {
            buffer.order(if (isBigEndian) BIG_ENDIAN else LITTLE_ENDIAN)
        }
        buffer.viewE.also { getBytes(0, it) }
    } else this
    return try {
        block(buffer)
    } finally {
        if (view !== this) view.getBytes(0, this)
    }
}

fun BytesRO.readAsNativeByteBuffer(): ByteBuffer =
    asNativeByteBuffer()?.let {
        if (!it.isDirect) {
            val buffer = ByteBuffer.allocateDirect(it.remaining())
            if (this is MemorySegmentE) {
                buffer.order(if (isBigEndian) BIG_ENDIAN else LITTLE_ENDIAN)
            }
            buffer.put(it)
            buffer._flip()
            buffer
        } else it
    } ?: java.nio.ByteBuffer.allocateDirect(size)
        .order(NATIVE_ENDIAN).also { buffer ->
        getBytes(0, buffer.viewE)
    }

fun BytesRO.asNativeByteBuffer(): ByteBuffer? = when (this) {
    is ByteBufferView ->
        if (byteBuffer.isDirect) byteBuffer.slice().order(byteBuffer.order())
        else null
    else -> null
}

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._position(newPosition: Int): B =
        apply { position(newPosition) }

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._limit(newLimit: Int): B =
        apply { limit(newLimit) }

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._mark(): B =
        apply { mark() }

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._reset(): B =
        apply { reset() }

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._clear(): B =
        apply { clear() }

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._flip(): B =
        apply { flip() }

/**
 * Compatibility extension avoiding the overridden versions added in Java 9
 */
inline fun <B : Buffer> B._rewind(): B =
        apply { rewind() }
