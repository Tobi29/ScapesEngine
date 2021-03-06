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

@file:JvmName("RandomJVMKt")

package org.tobi29.math

import org.tobi29.stdex.ThreadLocal
import org.tobi29.stdex.isAndroidAPI
import java.util.concurrent.ThreadLocalRandom

internal open class RandomJVM(private val random: java.util.Random) : Random {
    override fun nextBoolean() = random.nextBoolean()

    override fun nextInt() = random.nextInt()

    override fun nextInt(bound: Int) = random.nextInt(bound)

    override fun nextLong() = random.nextLong()

    override fun nextFloat() = random.nextFloat()

    override fun nextDouble() = random.nextDouble()
}

internal class SecureRandomJVM(
    random: java.security.SecureRandom
) : RandomJVM(random), SecureRandom

actual fun Random(): Random = RandomJVM(java.util.Random())

actual fun Random(seed: Long): Random = RandomJVM(java.util.Random(seed))

actual fun threadLocalRandom(): Random = tlRandom.get()

actual fun SecureRandom(
    highQuality: Boolean
): SecureRandom = SecureRandomJVM(
    if (highQuality && isAndroidAPI(26))
        java.security.SecureRandom.getInstanceStrong()
    else java.security.SecureRandom()
)

private val tlRandom = ThreadLocal {
    RandomJVM(ThreadLocalRandom.current())
}
