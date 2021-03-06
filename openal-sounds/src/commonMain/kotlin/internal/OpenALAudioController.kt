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

package org.tobi29.scapes.engine.backends.openal.openal.internal

import net.gitout.ktbindings.al.*
import org.tobi29.scapes.engine.sound.AudioController
import kotlin.math.abs

internal class OpenALAudioController(
    override var pitch: Double,
    override var gain: Double,
    override var referenceDistance: Double,
    override var rolloffFactor: Double
) : AudioController {
    private var pitchAL = 0.0
    private var gainAL = 0.0
    private var referenceDistanceAL = 0.0
    private var rolloffFactorAL = 0.0

    internal fun configure(
        al: AL11,
        source: ALSource,
        gain: Double,
        force: Boolean = false
    ) {
        val gainAL = this.gain * gain
        val pitchAL = pitch
        val referenceDistanceAL = referenceDistanceAL
        val rolloffFactorAL = rolloffFactorAL
        if (force || abs(gainAL - this.gainAL) > 0.001) {
            al.alSourcef(source, AL_GAIN, gainAL.toFloat())
            this.gainAL = gainAL
        }
        if (force || abs(pitchAL - this.pitchAL) > 0.001) {
            al.alSourcef(source, AL_PITCH, pitchAL.toFloat())
            this.pitchAL = pitchAL
        }
        if (force || abs(
                referenceDistanceAL - this.referenceDistanceAL
            ) > 0.001) {
            al.alSourcef(
                source, AL_REFERENCE_DISTANCE, referenceDistanceAL.toFloat()
            )
            this.referenceDistanceAL = referenceDistanceAL
        }
        if (force || abs(rolloffFactorAL - this.rolloffFactorAL) > 0.001) {
            al.alSourcef(source, AL_ROLLOFF_FACTOR, rolloffFactorAL.toFloat())
            this.rolloffFactorAL = rolloffFactorAL
        }
    }
}
