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

package org.tobi29.stdex

import org.khronos.webgl.*

@PublishedApi
internal actual fun ByteArray.utf8ToStringImpl(
    offset: Int,
    size: Int
): String {
    val buffer = ArrayBuffer(size)
    val byteBuffer = Uint8Array(buffer)
    var j = offset
    repeat(size) {
        byteBuffer[it] = this[j++]
    }
    return TextDecoder().decode(byteBuffer)
}

@PublishedApi
internal actual fun String.utf8ToArrayImpl(
    destination: ByteArray?,
    offset: Int,
    size: Int
): ByteArray {
    val byteBuffer = TextEncoder().encode(this)
    val array = destination ?: ByteArray(
        if (size < 0) byteBuffer.length else size
    )
    var j = offset
    repeat(size.coerceAtMost(array.size)) {
        array[j++] = byteBuffer[it]
    }
    return array
}

@PublishedApi
internal actual fun CharArray.copyToStringImpl(
    offset: Int,
    size: Int
) = StringBuilder(size).apply {
    for (i in offset until offset + size) {
        append(this@copyToStringImpl[i])
    }
}.toString()

@PublishedApi
internal actual fun String.copyToArrayImpl(
    destination: CharArray,
    offset: Int,
    startIndex: Int,
    endIndex: Int
): CharArray {
    val destOffset = offset - startIndex
    for (i in startIndex until endIndex) {
        destination[i + destOffset] = this[i]
    }
    return destination
}

private external class TextDecodeOptions {
    var stream: Boolean
}

private external class TextDecoder {
    val encoding: String
    fun decode(
        input: BufferDataSource? = definedExternally,
        options: TextDecodeOptions? = definedExternally
    ): String
}

private external class TextEncoder(
    label: String? = definedExternally,
    options: TextDecodeOptions? = definedExternally
) {
    val encoding: String
    fun encode(input: String? = definedExternally): Uint8Array
}

@Suppress("NOTHING_TO_INLINE")
private inline fun TextDecodeOptions(stream: Boolean): dynamic {
    val options = object {}.asDynamic()
    options.stream = stream
    return options
}