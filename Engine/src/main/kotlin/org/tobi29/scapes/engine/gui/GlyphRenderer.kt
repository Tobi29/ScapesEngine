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

package org.tobi29.scapes.engine.gui

import java.nio.ByteBuffer

interface GlyphRenderer {
    fun pageInfo(id: Int): GlyphRenderer.GlyphPage

    fun page(id: Int,
             bufferSupplier: (Int) -> ByteBuffer): ByteBuffer

    fun pageID(character: Char): Int

    fun pageCode(character: Char): Int

    class GlyphPage(val width: IntArray,
                    val size: Int,
                    val tiles: Int,
                    val tileSize: Double)
}