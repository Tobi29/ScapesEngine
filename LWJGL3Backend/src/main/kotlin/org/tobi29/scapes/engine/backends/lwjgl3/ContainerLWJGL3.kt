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

package org.tobi29.scapes.engine.backends.lwjgl3

import mu.KLogging
import org.lwjgl.Version
import org.lwjgl.opengl.GL11
import org.lwjgl.opengles.GLES
import org.lwjgl.opengles.GLES20
import org.lwjgl.system.Platform
import org.tobi29.scapes.engine.Container
import org.tobi29.scapes.engine.ScapesEngine
import org.tobi29.scapes.engine.backends.lwjgl3.openal.LWJGL3OpenAL
import org.tobi29.scapes.engine.backends.lwjgl3.opengl.GLLWJGL3GL
import org.tobi29.scapes.engine.backends.lwjgl3.opengl.GOSLWJGL3GL
import org.tobi29.scapes.engine.backends.lwjgl3.opengles.GLLWJGL3GLES
import org.tobi29.scapes.engine.backends.lwjgl3.opengles.GOSLWJGL3GLES
import org.tobi29.scapes.engine.backends.openal.openal.OpenALSoundSystem
import org.tobi29.scapes.engine.graphics.Font
import org.tobi29.scapes.engine.utils.sleep
import org.tobi29.scapes.engine.utils.tag.ReadTagMutableMap
import org.tobi29.scapes.engine.utils.tag.toBoolean
import org.tobi29.scapes.engine.utils.task.Joiner
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.concurrent.ConcurrentLinkedQueue

abstract class ContainerLWJGL3(override val engine: ScapesEngine,
                               protected val useGLES: Boolean = false) : Container {
    protected val tasks = ConcurrentLinkedQueue<() -> Unit>()
    protected val mainThread: Thread = Thread.currentThread()
    override val gos = if (useGLES) GOSLWJGL3GLES(engine) else GOSLWJGL3GL(
            engine)
    protected val gl = if (useGLES) GLLWJGL3GLES(gos) else GLLWJGL3GL(gos)
    override val sounds = OpenALSoundSystem(engine, LWJGL3OpenAL(), 64, 5.0)


    init {
        logger.info { "LWJGL version: ${Version.getVersion()}" }

        // It's 2017 and this is still a thing...
        if (Platform.get() == Platform.WINDOWS) {
            val sleepThread = Thread {
                while (true) {
                    sleep(Long.MAX_VALUE)
                }
            }
            sleepThread.name = "Sleep-Thread"
            sleepThread.isDaemon = true
            sleepThread.start()
        }
    }

    override fun loadFont(asset: String): Font? {
        return STBFont.fromFont(this, engine.files[asset + ".ttf"].get())
    }

    override fun allocate(capacity: Int): ByteBuffer =
            ByteBuffer.allocateDirect(capacity).order(ByteOrder.nativeOrder())

    protected fun <R> exec(runnable: () -> R): R {
        val thread = Thread.currentThread()
        if (thread === mainThread) {
            return runnable()
        }
        val joinable = Joiner.BasicJoinable()
        var output: R? = null
        var exception: Throwable? = null
        tasks.add({
            try {
                output = runnable()
            } catch (e: Throwable) {
                exception = e
            }

            joinable.join()
        })
        joinable.joiner.join()
        if (exception != null) {
            throw IOException(exception)
        }
        return output as R
    }

    companion object : KLogging() {
        fun workaroundLegacyProfile(tagMap: ReadTagMutableMap?): String? {
            if (tagMap?.get("ForceLegacyGL")?.toBoolean() ?: false) {
                logger.warn { "Forcing a legacy profile, this is unsupported!" }
                return "Forced by config"
            }
            if (tagMap?.get("ForceCoreGL")?.toBoolean() ?: false) {
                logger.warn { "Forcing a core profile, this is unsupported!" }
                return null
            }
            val platform = Platform.get()
            val vendor = GL11.glGetString(GL11.GL_VENDOR)
            // AMD Catalyst/Crimson driver on both Linux and MS Windows ©
            // causes JVM crashes in glDrawArrays and glDrawElements without
            // any obvious reason to why, using a legacy context appears to
            // fully get rid of those crashes, so this might be a driver bug
            // as this does not happen on any other driver
            // Note: This does not affect the macOS driver or radeonsi
            // Note: Untested with AMDGPU-Pro
            if ((platform == Platform.LINUX || platform == Platform.WINDOWS) &&
                    vendor == "ATI Technologies Inc.") {
                // AMD is bloody genius with their names
                return "Crashes on AMD Radeon Software Crimson"
            }
            return null
        }

        fun checkContextGL(): String? {
            logger.info {
                "OpenGL: ${GL11.glGetString(
                        GL11.GL_VERSION)} (Vendor: ${GL11.glGetString(
                        GL11.GL_VENDOR)}, Renderer: ${GL11.glGetString(
                        GL11.GL_RENDERER)})"
            }
            val capabilities = org.lwjgl.opengl.GL.getCapabilities()
            if (!capabilities.OpenGL11) {
                return "Your graphics card has no OpenGL 1.1 support!"
            }
            if (!capabilities.OpenGL12) {
                return "Your graphics card has no OpenGL 1.2 support!"
            }
            if (!capabilities.OpenGL13) {
                return "Your graphics card has no OpenGL 1.3 support!"
            }
            if (!capabilities.OpenGL14) {
                return "Your graphics card has no OpenGL 1.4 support!"
            }
            if (!capabilities.OpenGL15) {
                return "Your graphics card has no OpenGL 1.5 support!"
            }
            if (!capabilities.OpenGL20) {
                return "Your graphics card has no OpenGL 2.0 support!"
            }
            if (!capabilities.OpenGL21) {
                return "Your graphics card has no OpenGL 2.1 support!"
            }
            if (!capabilities.OpenGL30) {
                return "Your graphics card has no OpenGL 3.0 support!"
            }
            if (!capabilities.OpenGL31) {
                return "Your graphics card has no OpenGL 3.1 support!"
            }
            if (!capabilities.OpenGL32) {
                return "Your graphics card has no OpenGL 3.2 support!"
            }
            if (!capabilities.OpenGL33) {
                return "Your graphics card has no OpenGL 3.3 support!"
            }
            return null
        }

        fun checkContextGLES(): String? {
            logger.info {
                "OpenGL ES: ${GLES20.glGetString(
                        GLES20.GL_VERSION)} (Vendor: ${GLES20.glGetString(
                        GLES20.GL_VENDOR)}, Renderer: ${GLES20.glGetString(
                        GLES20.GL_RENDERER)})"
            }
            val capabilities = GLES.getCapabilities()
            if (!capabilities.GLES20) {
                return "Your graphics card has no OpenGL ES 2.0 support!"
            }
            if (!capabilities.GLES30) {
                return "Your graphics card has no OpenGL ES 3.0 support!"
            }
            return null
        }
    }
}