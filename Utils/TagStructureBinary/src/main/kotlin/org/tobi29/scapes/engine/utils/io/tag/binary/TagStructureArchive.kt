/*
 * Copyright 2012-2016 Tobi29
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

package org.tobi29.scapes.engine.utils.io.tag.binary

import org.tobi29.scapes.engine.utils.BufferCreator
import org.tobi29.scapes.engine.utils.ThreadLocal
import org.tobi29.scapes.engine.utils.io.ByteBufferStream
import org.tobi29.scapes.engine.utils.io.ReadableByteStream
import org.tobi29.scapes.engine.utils.io.WritableByteStream
import org.tobi29.scapes.engine.utils.io.tag.TagStructure
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class TagStructureArchive {
    private val tagStructures = ConcurrentHashMap<String, ByteBuffer>()

    @Synchronized fun setTagStructure(key: String,
                                      tagStructure: TagStructure,
                                      compression: Byte = 1) {
        val byteStream = DATA_STREAM.get()
        byteStream.buffer().clear()
        TagStructureBinary.write(byteStream, tagStructure, compression)
        byteStream.buffer().flip()
        val buffer = BufferCreator.bytes(byteStream.buffer().remaining())
        buffer.put(byteStream.buffer())
        buffer.flip()
        tagStructures.put(key, buffer)
    }

    @Synchronized fun getTagStructure(key: String): TagStructure? {
        val buffer = tagStructures[key] ?: return null
        val tagStructure = TagStructure()
        TagStructureBinary.read(ByteBufferStream(buffer.duplicate()),
                tagStructure)
        return tagStructure
    }

    @Synchronized fun removeTagStructure(key: String) {
        tagStructures.remove(key)
    }

    @Synchronized fun moveTagStructure(from: String,
                                       to: String) {
        val tag = tagStructures.remove(from)
        if (tag != null) {
            tagStructures.put(to, tag)
        }
    }

    fun hasTagStructure(key: String): Boolean {
        return tagStructures.containsKey(key)
    }

    val keys: Collection<String>
        get() = tagStructures.keys

    @Synchronized fun write(stream: WritableByteStream) {
        stream.put(HEADER_MAGIC)
        stream.put(HEADER_VERSION.toInt())
        val buffers = ArrayList<ByteBuffer>()
        for ((key, value) in tagStructures) {
            val array = key.toByteArray(CHARSET)
            if (array.size >= 254) {
                stream.put(254)
                stream.putInt(array.size)
            } else {
                stream.put(array.size)
            }
            stream.put(array)
            val buffer = value.duplicate()
            stream.putInt(buffer.remaining())
            buffers.add(buffer)
        }
        stream.put(255)
        for (buffer in buffers) {
            stream.put(buffer)
        }
    }

    @Synchronized fun read(stream: ReadableByteStream) {
        val entries = readHeader(stream)
        for (entry in entries) {
            val array = BufferCreator.bytes(entry.length)
            stream[array]
            array.flip()
            tagStructures.put(entry.name, array)
        }
    }

    class Entry(val name: String, val length: Int)

    companion object {
        private val HEADER_VERSION: Byte = 1
        private val HEADER_MAGIC = byteArrayOf('S'.toByte(), 'T'.toByte(),
                'A'.toByte(), 'R'.toByte())
        private val CHARSET = StandardCharsets.UTF_8
        private val DATA_STREAM = ThreadLocal {
            ByteBufferStream(growth = { it + 1048576 })
        }

        @Throws(IOException::class) fun extract(name: String,
                                                stream: ReadableByteStream): TagStructure? {
            val entries = readHeader(stream)
            var offset = 0
            for (entry in entries) {
                if (entry.name == name) {
                    stream.skip(offset)
                    return TagStructureBinary.read(stream)
                }
                offset += entry.length
            }
            return null
        }

        fun readHeader(stream: ReadableByteStream): List<Entry> {
            val magic = ByteArray(HEADER_MAGIC.size)
            stream[magic]
            if (!Arrays.equals(magic, magic)) {
                throw IOException("Not in tag-archive format! (Magic-Header: " +
                        Arrays.toString(magic) +
                        ')')
            }
            val version = stream.get()
            if (version > HEADER_VERSION) {
                throw IOException(
                        "Unsupported version or not in tag-container format! (Version: " +
                                version + ')')
            }
            val entries = ArrayList<Entry>()
            while (true) {
                var length = stream.uByte.toInt()
                if (length == 255) {
                    break
                } else if (length == 254) {
                    length = stream.int
                }
                val array = ByteArray(length)
                stream[array]
                val name = String(array, CHARSET)
                length = stream.int
                entries.add(Entry(name, length))
            }
            return entries
        }
    }
}