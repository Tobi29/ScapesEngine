/*
 * Copyright 2017, Gray Watson
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.j256.simplemagik.types

import com.j256.simplemagik.endian.EndianType
import com.j256.simplemagik.endian.convert
import com.j256.simplemagik.entries.MagicFormatter
import com.j256.simplemagik.entries.MagicMatcher
import com.j256.simplemagik.entries.getCompactLong
import com.j256.simplemagik.entries.putCompactLong
import org.tobi29.arrays.BytesRO
import org.tobi29.io.HeapViewByteBE
import org.tobi29.io.IOException
import org.tobi29.io.MemoryViewReadableStream
import org.tobi29.io.WritableByteStream
import org.tobi29.stdex.combineToLong
import org.tobi29.stdex.maskAt
import org.tobi29.stdex.setAt
import org.tobi29.stdex.splitToBytes
import kotlin.experimental.or

data class LongType(
    val comparison: Pair<Long, TestOperator>?,
    val andValue: Long,
    val unsignedType: Boolean,
    val endianType: EndianType
) : MagicMatcher {
    override fun canStartWithByte(value: Byte): Boolean =
        comparison?.second?.isBitwise != true
                || comparison.second.compare(
            value, (comparison.first.convert(endianType) and andValue)
                .splitToBytes { b, _, _, _, _, _, _, _ -> b },
            unsignedType
        )

    override fun isMatch(
        bytes: BytesRO,
        required: Boolean
    ): Pair<Int, (Appendable, MagicFormatter) -> Unit>? =
        if (bytes.size >= 8)
            (combineToLong(
                bytes[0], bytes[1], bytes[2], bytes[3],
                bytes[4], bytes[5], bytes[6], bytes[7]
            ).convert(endianType) and andValue).let { extracted ->
                if (comparison == null || comparison.second.compare(
                        extracted, comparison.first, unsignedType
                    )) 8 to
                        { sb: Appendable, formatter: MagicFormatter ->
                            formatter.format(
                                sb, extracted // TODO: Unsigned
                            )
                        } else null
            } else null
}

@Suppress("UNUSED_PARAMETER")
fun LongType(
    typeStr: String,
    testStr: String?,
    andValue: Long?,
    unsignedType: Boolean,
    endianType: EndianType
): LongType = (andValue ?: -1).let { andValue2 ->
    LongType(decodeComparison(testStr), andValue2, unsignedType, endianType)
}

fun LongTypeBE(
    typeStr: String,
    testStr: String?,
    andValue: Long?,
    unsignedType: Boolean
): LongType = LongType(
    typeStr, testStr, andValue, unsignedType, EndianType.BIG
)

fun LongTypeLE(
    typeStr: String,
    testStr: String?,
    andValue: Long?,
    unsignedType: Boolean
): LongType = LongType(
    typeStr, testStr, andValue, unsignedType, EndianType.LITTLE
)

fun LongTypeME(
    typeStr: String,
    testStr: String?,
    andValue: Long?,
    unsignedType: Boolean
): LongType = LongType(
    typeStr, testStr, andValue, unsignedType, EndianType.MIDDLE
)

fun LongTypeNE(
    typeStr: String,
    testStr: String?,
    andValue: Long?,
    unsignedType: Boolean
): LongType = LongType(
    typeStr, testStr, andValue, unsignedType, EndianType.NATIVE
)

internal fun LongType.write(stream: WritableByteStream) {
    stream.put(
        0.toByte()
            .setAt(0, comparison != null)
            .setAt(1, unsignedType)
            .let {
                if (comparison == null) it
                else it or (comparison.second.id shl 2).toByte()
            } or (endianType.id shl 5).toByte()
    )
    stream.putCompactLong(andValue)
    if (comparison != null) {
        stream.putCompactLong(comparison.first)
    }
}

internal fun readLongType(stream: MemoryViewReadableStream<HeapViewByteBE>): LongType {
    val flags = stream.get()
    val comparisonHas = flags.maskAt(0)
    val unsignedType = flags.maskAt(1)
    val andValue = stream.getCompactLong()
    val comparison = if (comparisonHas) {
        val first = stream.getCompactLong()
        val second = TestOperator.of((flags.toInt() ushr 2) and 7)
                ?: throw IOException("Invalid test operator")
        first to second
    } else null
    val endianType = EndianType.of((flags.toInt() ushr 5) and 3)
            ?: throw IOException("Invalid endian type")
    return LongType(
        comparison,
        andValue,
        unsignedType,
        endianType
    )
}
