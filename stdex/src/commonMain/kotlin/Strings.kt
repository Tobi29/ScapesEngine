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

/**
 * Reads UTF-8 data from the given array and returns a string
 *
 * **Note:** The conversion might skip invalid bytes or codepoints unavailable
 * in UTF-16
 * @param offset First byte in the array to read
 * @param size Amount of bytes in the array to read
 * @receiver Array to read from
 * @return A string containing the encoded characters
 */
@InlineUtility
@Suppress("NOTHING_TO_INLINE")
inline fun ByteArray.utf8ToString(
    offset: Int = 0,
    size: Int = this.size - offset
): String = utf8ToStringImpl(offset, size)

/**
 * Encodes the given string into an array
 * @param destination Array to write to or `null` to allocate one
 * @param offset First byte in the array to write into
 * @param size Maximum amount of bytes to write or `-1` to write everything or throw
 * @receiver The string to encode
 */
@InlineUtility
@Suppress("NOTHING_TO_INLINE")
inline fun String.utf8ToArray(
    destination: ByteArray? = null,
    offset: Int = 0,
    size: Int = -1
): ByteArray = utf8ToArrayImpl(destination, offset, size)

/**
 * Encodes the given string into an array
 * @param destination Array to write to or `null` to allocate one
 * @param offset First byte in the array to write into
 * @param size Maximum amount of bytes to write or `-1` to write everything or throw
 * @receiver The string to encode
 */
// TODO: Optimize non-string cases
@Suppress("IfThenToElvis") // The result is disgusting
fun CharSequence.utf8ToArray(
    destination: ByteArray? = null,
    offset: Int = 0,
    size: Int = -1
): ByteArray = toString().utf8ToArray(destination, offset, size)

/**
 * Copies the characters of the given string into an array
 * @param destination Array to write to
 * @param offset First index to write into in the array
 * @param startIndex First index to copy from (inclusive)
 * @param endIndex Last index to copy from (exclusive)
 * @receiver String to read from
 * @return A new string containing the copied characters
 */
@InlineUtility
@Suppress("NOTHING_TO_INLINE")
inline fun String.copyToArray(
    destination: CharArray = CharArray(length),
    offset: Int = 0,
    startIndex: Int = 0,
    endIndex: Int = length
): CharArray = copyToArrayImpl(destination, offset, startIndex, endIndex)

/**
 * Copies the characters of the given string into an array
 * @param destination Array to write to
 * @param offset First index to write into in the array
 * @param startIndex First index to copy from (inclusive)
 * @param endIndex Last index to copy from (exclusive)
 * @receiver String to read from
 * @return A new string containing the copied characters
 */
@Suppress("IfThenToElvis") // The result is disgusting
fun CharSequence.copyToArray(
    destination: CharArray = CharArray(length),
    offset: Int = 0,
    startIndex: Int = 0,
    endIndex: Int = length
): CharArray = if (this is String)
    copyToArray(destination, offset, startIndex, endIndex)
else destination.also {
    for (i in startIndex until endIndex) {
        destination[i + offset] = this[i + offset]
    }
}

/**
 * Ensures a certain length of the string by prefixing or throwing an exception
 * @param char Character to fill with
 * @param minLength Minimum length of resulting string
 * @param maxLength Maximum length of resulting string
 * @receiver String to use
 * @throws IllegalArgumentException If initial string was already too long
 * @return String with length between minLength and maxLength (inclusive)
 */
fun String.prefixToLength(
    char: Char,
    minLength: Int,
    maxLength: Int = Int.MAX_VALUE
): String {
    if (length > maxLength) throw IllegalArgumentException(
        "String already too long"
    )
    if (length >= minLength) return this
    val output = StringBuilder(minLength)
    repeat(minLength - length) {
        output.append(char)
    }
    output.append(this)
    return output.toString()
}

/**
 * Ensures a certain length of the string by suffixing or throwing an exception
 * @param char Character to fill with
 * @param minLength Minimum length of resulting string
 * @param maxLength Maximum length of resulting string
 * @receiver String to use
 * @throws IllegalArgumentException If initial string was already too long
 * @return String with length between minLength and maxLength (inclusive)
 */
fun String.suffixToLength(
    char: Char,
    minLength: Int,
    maxLength: Int = Int.MAX_VALUE
): String {
    if (length > maxLength) throw IllegalArgumentException(
        "String already too long"
    )
    if (length >= minLength) return this
    val output = StringBuilder(minLength)
    output.append(this)
    repeat(minLength - length) {
        output.append(char)
    }
    return output.toString()
}

// Nullable versions of functions in Kotlin stdlib
/**
 * Returns a substring before the first occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringBeforeOrNull(delimiter: Char): String? {
    val index = indexOf(delimiter)
    return if (index == -1) null else substring(0, index)
}

/**
 * Returns a substring before the first occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringBeforeOrNull(delimiter: String): String? {
    val index = indexOf(delimiter)
    return if (index == -1) null else substring(0, index)
}

/**
 * Returns a substring after the first occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringAfterOrNull(delimiter: Char): String? {
    val index = indexOf(delimiter)
    return if (index == -1) null else substring(index + 1, length)
}

/**
 * Returns a substring after the first occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringAfterOrNull(delimiter: String): String? {
    val index = indexOf(delimiter)
    return if (index == -1) null else substring(
        index + delimiter.length,
        length
    )
}

/**
 * Returns a substring before the last occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringBeforeLastOrNull(delimiter: Char): String? {
    val index = lastIndexOf(delimiter)
    return if (index == -1) null else substring(0, index)
}

/**
 * Returns a substring before the last occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringBeforeLastOrNull(delimiter: String): String? {
    val index = lastIndexOf(delimiter)
    return if (index == -1) null else substring(0, index)
}

/**
 * Returns a substring after the last occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`
 */
fun String.substringAfterLastOrNull(delimiter: Char): String? {
    val index = lastIndexOf(delimiter)
    return if (index == -1) null else substring(index + 1, length)
}

/**
 * Returns a substring after the last occurrence of [delimiter].
 * If the string does not contain the delimiter, returns `null`.
 */
fun String.substringAfterLastOrNull(delimiter: String): String? {
    val index = lastIndexOf(delimiter)
    return if (index == -1) null else substring(
        index + delimiter.length,
        length
    )
}

/**
 * Returns a [Readable] reading through the given string
 * @receiver String to read from
 * @return A [Readable] returning the contents of the given string
 */
fun CharSequence.toReadable(): Readable = object : Readable {
    private var i = 0

    override fun read(): Char {
        if (i >= length) throw IndexOutOfBoundsException("End of string")
        return this@toReadable[i++]
    }

    override fun readTry(): Int {
        if (i >= length) return -1
        return this@toReadable[i++].toInt()
    }
}

@PublishedApi
internal expect fun ByteArray.utf8ToStringImpl(
    offset: Int,
    size: Int
): String

@PublishedApi
internal expect fun String.utf8ToArrayImpl(
    destination: ByteArray?,
    offset: Int,
    size: Int
): ByteArray

@PublishedApi
internal expect fun String.copyToArrayImpl(
    destination: CharArray,
    offset: Int,
    startIndex: Int,
    endIndex: Int
): CharArray
