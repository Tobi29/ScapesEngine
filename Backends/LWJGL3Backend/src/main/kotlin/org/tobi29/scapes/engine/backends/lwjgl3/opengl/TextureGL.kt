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
package org.tobi29.scapes.engine.backends.lwjgl3.opengl

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL12
import org.tobi29.scapes.engine.ScapesEngine
import org.tobi29.scapes.engine.graphics.GL
import org.tobi29.scapes.engine.graphics.Texture
import org.tobi29.scapes.engine.graphics.TextureFilter
import org.tobi29.scapes.engine.graphics.TextureWrap
import org.tobi29.scapes.engine.utils.graphics.generateMipMaps
import org.tobi29.scapes.engine.utils.math.max
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicBoolean

internal open class TextureGL(override val engine: ScapesEngine, width: Int, height: Int,
                              buffer: ByteBuffer?, protected val mipmaps: Int, minFilter: TextureFilter,
                              magFilter: TextureFilter, wrapS: TextureWrap, wrapT: TextureWrap) : Texture {
    protected val dirtyFilter = AtomicBoolean(true)
    protected val dirtyBuffer = AtomicBoolean(true)
    protected var textureID = 0
    protected var minFilter = TextureFilter.NEAREST
    protected var magFilter = TextureFilter.NEAREST
    protected var wrapS = TextureWrap.REPEAT
    protected var wrapT = TextureWrap.REPEAT
    override var isStored = false
    protected var markAsDisposed = false
    protected var used: Long = 0
    protected var detach: Function0<Unit>? = null
    protected var buffer = TextureBuffer(emptyArray(), width, height)

    init {
        this.minFilter = minFilter
        this.magFilter = magFilter
        this.wrapS = wrapS
        this.wrapT = wrapT
        setBuffer(buffer)
    }

    override fun bind(gl: GL) {
        ensureStored(gl)
        gl.check()
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID)
        if (dirtyFilter.getAndSet(false)) {
            if (mipmaps > 0) {
                when (minFilter) {
                    TextureFilter.NEAREST -> GL11.glTexParameteri(
                            GL11.GL_TEXTURE_2D,
                            GL11.GL_TEXTURE_MIN_FILTER,
                            GL11.GL_NEAREST_MIPMAP_LINEAR)
                    TextureFilter.LINEAR -> GL11.glTexParameteri(
                            GL11.GL_TEXTURE_2D,
                            GL11.GL_TEXTURE_MIN_FILTER,
                            GL11.GL_LINEAR_MIPMAP_LINEAR)
                    else -> throw IllegalArgumentException(
                            "Illegal texture-filter!")
                }
            } else {
                when (minFilter) {
                    TextureFilter.NEAREST -> GL11.glTexParameteri(
                            GL11.GL_TEXTURE_2D,
                            GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST)
                    TextureFilter.LINEAR -> GL11.glTexParameteri(
                            GL11.GL_TEXTURE_2D,
                            GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR)
                    else -> throw IllegalArgumentException(
                            "Illegal texture-filter!")
                }
            }
            when (magFilter) {
                TextureFilter.NEAREST -> GL11.glTexParameteri(
                        GL11.GL_TEXTURE_2D,
                        GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST)
                TextureFilter.LINEAR -> GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
                        GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR)
                else -> throw IllegalArgumentException(
                        "Illegal texture-filter!")
            }
            when (wrapS) {
                TextureWrap.REPEAT -> GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
                        GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT)
                TextureWrap.CLAMP -> GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
                        GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE)
                else -> throw IllegalArgumentException("Illegal texture-wrap!")
            }
            when (wrapT) {
                TextureWrap.REPEAT -> GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
                        GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT)
                TextureWrap.CLAMP -> GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
                        GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE)
                else -> throw IllegalArgumentException("Illegal texture-wrap!")
            }
        }
    }

    override fun markDisposed() {
        markAsDisposed = true
    }

    override fun width(): Int {
        return buffer.width
    }

    override fun height(): Int {
        return buffer.height
    }

    override fun setWrap(wrapS: TextureWrap,
                         wrapT: TextureWrap) {
        this.wrapS = wrapS
        this.wrapT = wrapT
        dirtyFilter.set(true)
    }

    override fun setFilter(magFilter: TextureFilter,
                           minFilter: TextureFilter) {
        this.magFilter = magFilter
        this.minFilter = minFilter
        dirtyFilter.set(true)
    }

    override fun buffer(i: Int): ByteBuffer? {
        return buffer.buffers[i]
    }

    override fun setBuffer(buffer: ByteBuffer?) {
        setBuffer(buffer, this.buffer.width, this.buffer.height)
    }

    override fun setBuffer(buffer: ByteBuffer?,
                           width: Int,
                           height: Int) {
        this.buffer = buffer(buffer, width, height)
        dirtyBuffer.set(true)
    }

    override fun ensureStored(gl: GL): Boolean {
        if (dirtyBuffer.getAndSet(false) && isStored) {
            texture(gl)
        }
        if (!isStored) {
            store(gl)
        }
        used = System.currentTimeMillis()
        return true
    }

    override fun ensureDisposed(gl: GL) {
        if (isStored) {
            dispose(gl)
            reset()
        }
    }

    override fun isUsed(time: Long): Boolean {
        return time - used < 1000 && !markAsDisposed
    }

    override fun dispose(gl: GL) {
        assert(isStored)
        gl.check()
        GL11.glDeleteTextures(textureID)
    }

    override fun reset() {
        assert(isStored)
        isStored = false
        detach?.invoke()
        detach = null
        markAsDisposed = false
    }

    protected open fun store(gl: GL) {
        assert(!isStored)
        isStored = true
        gl.check()
        textureID = GL11.glGenTextures()
        texture(gl)
        dirtyFilter.set(true)
        detach = gl.textureTracker().attach(this)
    }

    protected open fun texture(gl: GL) {
        assert(isStored)
        gl.check()
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID)
        if (buffer.buffers.size > 1) {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL12.GL_TEXTURE_MAX_LEVEL,
                    buffer.buffers.size - 1)
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, buffer.width,
                    buffer.height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
                    buffer.buffers[0])
            for (i in 1..buffer.buffers.size - 1) {
                GL11.glTexImage2D(GL11.GL_TEXTURE_2D, i, GL11.GL_RGBA,
                        max(buffer.width shr i, 1),
                        max(buffer.height shr i, 1), 0, GL11.GL_RGBA,
                        GL11.GL_UNSIGNED_BYTE, buffer.buffers[i])
            }
        } else {
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, buffer.width,
                    buffer.height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
                    buffer.buffers[0])
        }
    }

    private fun buffer(buffer: ByteBuffer?,
                       width: Int,
                       height: Int): TextureBuffer {
        return TextureBuffer(
                generateMipMaps(buffer, { engine.allocate(it) }, width,
                        height, mipmaps, minFilter === TextureFilter.LINEAR),
                width, height)
    }

    protected class TextureBuffer(val buffers: Array<ByteBuffer?>,
                                  val width: Int,
                                  val height: Int)
}