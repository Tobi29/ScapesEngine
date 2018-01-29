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

package org.tobi29.stdex

private const val MIN_HIGH_SURROGATE = '\uD800'
private const val MIN_LOW_SURROGATE = '\uDC00'
private const val MIN_SUPPLEMENTARY_CODE_POINT = 0x010000

actual inline fun Char.isISOControl(): Boolean =
    toInt().isISOControl()

actual fun Codepoint.isISOControl(): Boolean =
    this <= 0x9F && (this >= 0x7F || (this.ushr(5) == 0))

actual fun Codepoint.isBmpCodepoint(): Boolean =
    this in 0 until MIN_SUPPLEMENTARY_CODE_POINT

actual fun Codepoint.highSurrogate(): Char =
    ((this ushr 10) + MIN_HIGH_SURROGATE.toInt()
            - (MIN_SUPPLEMENTARY_CODE_POINT ushr 10)).toChar()

actual fun Codepoint.lowSurrogate(): Char =
    ((this and 0x3ff) + MIN_LOW_SURROGATE.toInt()).toChar()

actual fun surrogateCodepoint(high: Char, low: Char): Codepoint =
    (((high - MIN_HIGH_SURROGATE) shl 10)
            + (low - MIN_LOW_SURROGATE)
            + MIN_SUPPLEMENTARY_CODE_POINT)