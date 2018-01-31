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

package org.tobi29.io.filesystem

import org.tobi29.arrays.toHexadecimal
import org.tobi29.logging.KLogging
import org.tobi29.checksums.Algorithm
import org.tobi29.utils.DurationNanos
import org.tobi29.io.*
import org.tobi29.utils.systemClock
import org.tobi29.utils.toInt128

object FileCache : KLogging() {
    fun store(root: FilePath,
              stream: ReadableByteStream): Location {
        val write = createTempFile("CacheWrite", ".tmp")
        try {
            channel(write, options = arrayOf(OPEN_READ, OPEN_WRITE, OPEN_CREATE,
                    OPEN_TRUNCATE_EXISTING)).use { channel ->
                val digest = Algorithm.SHA256.digest()
                val streamOut = BufferedWriteChannelStream(channel)
                stream.process { buffer ->
                    buffer.readAsByteArray { array, offset, size ->
                        digest.update(array, offset, size)
                    }
                    streamOut.put(buffer)
                }
                streamOut.flush()
                channel.position(0)
                val checksum = digest.digest()
                createDirectories(root)
                val name = checksum.toHexadecimal()
                val streamIn = BufferedReadChannelStream(channel)
                val destination = root.resolve(name)
                if (exists(destination)) {
                    setLastModifiedTime(destination, systemClock())
                } else {
                    write(destination) { output ->
                        streamIn.process { output.put(it) }
                    }
                }
                return Location(checksum)
            }
        } finally {
            delete(write)
        }
    }

    fun retrieve(root: FilePath,
                 location: Location): FilePath? {
        val file = root.resolve(location.array.toHexadecimal())
        if (exists(file)) {
            try {
                setLastModifiedTime(file, systemClock())
            } catch (e: IOException) {
            }
            return file
        }
        return null
    }

    fun delete(root: FilePath,
               location: Location) {
        val file = root.resolve(location.array.toHexadecimal())
        deleteIfExists(file)
    }

    fun check(root: FilePath,
              time: DurationNanos = (16L * 24L * 60L * 60L * 1000L).toInt128()) {
        val currentTime = systemClock() - time
        list(root) {
            filter { isRegularFile(it) }.filter(::isNotHidden).filter { file ->
                try {
                    getLastModifiedTime(file) < currentTime
                } catch (e: IOException) {
                    false
                }
            }.forEach { file ->
                deleteIfExists(file)
                logger.debug { "Deleted old cache entry: $file" }
            }
        }
    }

    class Location(val array: ByteArray)
}