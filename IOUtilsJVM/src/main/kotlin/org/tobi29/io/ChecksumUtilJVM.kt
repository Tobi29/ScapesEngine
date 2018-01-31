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

package org.tobi29.io

import org.tobi29.checksums.Algorithm
import org.tobi29.checksums.Checksum
import java.nio.ByteBuffer

/**
 * Creates a checksum from the given array
 * @param array     Byte array that will be used to create the checksum
 * @param algorithm The algorithm that will be used to create the checksum
 * @return A [Checksum] containing the checksum
 */
fun checksum(array: ByteArray,
             algorithm: Algorithm = Algorithm.SHA256): Checksum {
    val digest = algorithm.digest()
    digest.update(array)
    return Checksum(algorithm, digest.digest())
}

/**
 * Creates a checksum from the given [ByteBuffer]
 * @param buffer    [ByteBuffer] that will be used to create the checksum
 * @param algorithm The algorithm that will be used to create the checksum
 * @return A [Checksum] containing the checksum
 */
fun checksum(buffer: ByteBuffer,
             algorithm: Algorithm = Algorithm.SHA256): Checksum {
    val digest = algorithm.digest()
    digest.update(buffer)
    return Checksum(algorithm, digest.digest())
}

/**
 * Creates a checksum from the given [ReadableByteStream]
 * @param input     [ReadableByteStream] that will be used to create the checksum
 * @param algorithm The algorithm that will be used to create the checksum
 * @return A [Checksum] containing the checksum
 * @throws IOException When an IO error occurs
 */
fun checksum(input: ReadableByteStream,
             algorithm: Algorithm = Algorithm.SHA256): Checksum {
    val digest = algorithm.digest()
    input.process { digest.update(it.readAsByteBuffer()) }
    return Checksum(algorithm, digest.digest())
}
