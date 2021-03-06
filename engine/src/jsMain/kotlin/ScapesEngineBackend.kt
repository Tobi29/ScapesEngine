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

package org.tobi29.scapes.engine

import org.tobi29.io.TypedView
import org.tobi29.io.viewBE
import org.tobi29.io.viewLE
import org.tobi29.stdex.BIG_ENDIAN
import org.tobi29.stdex.NATIVE_ENDIAN

actual typealias MemoryBuffer = TypedView
actual typealias MemoryBufferPinned = TypedView

actual inline fun MemoryBufferPinned.close() {}

actual inline fun MemoryBufferPinned.asMemoryBuffer(): MemoryBuffer = this

actual inline fun allocateMemoryBuffer(size: Int): MemoryBuffer =
    ByteArray(size).run { if (NATIVE_ENDIAN == BIG_ENDIAN) viewBE else viewLE }

actual inline fun allocateMemoryBufferPinned(size: Int): MemoryBuffer =
    allocateMemoryBuffer(size)
