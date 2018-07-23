/*
 * KZLib - Kotlin port of ZLib
 *
 * Copyright of original source:
 *
 * Copyright (C) 1995-2017 Jean-loup Gailly and Mark Adler
 *
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 *    misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 *
 * Jean-loup Gailly        Mark Adler
 * jloup@gzip.org          madler@alumni.caltech.edu
 *
 *
 * The data format used by the zlib library is described by RFCs (Request for
 * Comments) 1950 to 1952 in the files http://tools.ietf.org/html/rfc1950
 * (zlib format), rfc1951 (deflate format) and rfc1952 (gzip format).
 */

@file:Suppress("NOTHING_TO_INLINE")

package org.tobi29.kzlib

import org.tobi29.checksums.computeCrc32
import org.tobi29.checksums.finishChainCrc32
import org.tobi29.checksums.initChainCrc32
import org.tobi29.checksums.tableCrc32

internal inline fun crc32(
    crc: UInt,
    buf: Nothing?,
    buf_i: Int,
    len: Int
): UInt = initChainCrc32().finishChainCrc32()

internal fun crc32(
    crc: UInt,
    buf: ByteArray,
    buf_i: Int,
    len: Int
): UInt = computeCrc32(crc, buf, buf_i, len, table)

private val table = tableCrc32(-0x12477ce0)