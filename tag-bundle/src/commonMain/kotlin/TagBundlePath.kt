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

package org.tobi29.io.tag.bundle

import org.tobi29.io.*

data class TagBundlePath(
    private val bundle: TagBundle,
    private val path: String
) : PathLocalT<SeekableReadByteChannel> {
    private val data by lazy { bundle.resolve(path) }

    override fun get(path: String): PathLocal {
        UnixPathEnvironment.run {
            return TagBundlePath(
                bundle,
                this@TagBundlePath.path.resolve(path)
            )
        }
    }

    override val parent
        get() = UnixPathEnvironment.run {
            (path.parent ?: if (path.isNotEmpty()) "" else null)
                ?.let { TagBundlePath(bundle, it) }
        }

    override fun channel() = dataNow().viewBE.let(::MemoryViewReadableStream)
        .let(::RandomReadableByteStreamChannel)

    override fun <R> readNow(reader: (ReadableByteStream) -> R): R {
        val stream = dataNow().viewBE.let(::MemoryViewReadableStream)
        return reader(stream)
    }

    override fun dataNow() = data ?: throw IOException("Entry does not exist")
}
