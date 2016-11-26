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

package org.tobi29.scapes.engine.backends.lwjgl3.opengles

import mu.KLogging
import org.lwjgl.opengles.GLES20
import org.lwjgl.opengles.GLES30
import org.lwjgl.system.MemoryStack
import org.tobi29.scapes.engine.backends.lwjgl3.push
import org.tobi29.scapes.engine.graphics.FramebufferStatus
import org.tobi29.scapes.engine.graphics.RenderType
import org.tobi29.scapes.engine.utils.ThreadLocal
import org.tobi29.scapes.engine.utils.shader.CompiledShader
import org.tobi29.scapes.engine.utils.shader.ShaderGenerateException
import org.tobi29.scapes.engine.utils.shader.glsl.GLSLGenerator
import java.io.IOException

internal object GLUtils : KLogging() {
    private val SHADER_GENERATOR = ThreadLocal {
        GLSLGenerator(GLSLGenerator.Version.GLES_300)
    }

    fun renderType(renderType: RenderType): Int {
        when (renderType) {
            RenderType.TRIANGLES -> return GLES20.GL_TRIANGLES
            RenderType.LINES -> return GLES20.GL_LINES
            else -> throw IllegalArgumentException(
                    "Unknown render type: " + renderType)
        }
    }

    fun status(): FramebufferStatus {
        val status = GLES20.glCheckFramebufferStatus(GLES20.GL_FRAMEBUFFER)
        when (status) {
            GLES20.GL_FRAMEBUFFER_COMPLETE -> return FramebufferStatus.COMPLETE
            GLES20.GL_FRAMEBUFFER_UNSUPPORTED -> return FramebufferStatus.UNSUPPORTED
            else -> return FramebufferStatus.UNKNOWN
        }
    }

    fun drawbuffers(attachments: Int) {
        if (attachments < 0 || attachments > 15) {
            throw IllegalArgumentException(
                    "Attachments must be 0-15, was " + attachments)
        }
        val stack = MemoryStack.stackGet()
        stack.push {
            val attachBuffer = stack.mallocInt(attachments)
            for (i in 0..attachments - 1) {
                attachBuffer.put(GLES20.GL_COLOR_ATTACHMENT0 + i)
            }
            attachBuffer.rewind()
            GLES30.glDrawBuffers(attachBuffer)
        }
    }

    fun printLogShader(id: Int) {
        val stack = MemoryStack.stackGet()
        val length = GLES20.glGetShaderi(id, GLES20.GL_INFO_LOG_LENGTH)
        if (length > 1) {
            stack.push {
                val lengthBuffer = stack.mallocInt(1)
                lengthBuffer.put(0, length)
                val buffer = stack.malloc(length)
                GLES20.glGetShaderInfoLog(id, lengthBuffer, buffer)
                val infoBytes = ByteArray(length)
                buffer.get(infoBytes)
                val out = String(infoBytes)
                logger.info { "Shader log: $out" }
            }
        }
    }

    fun printLogProgram(id: Int) {
        val stack = MemoryStack.stackGet()
        val length = GLES20.glGetProgrami(id, GLES20.GL_INFO_LOG_LENGTH)
        if (length > 1) {
            stack.push {
                val lengthBuffer = stack.mallocInt(1)
                lengthBuffer.put(0, length)
                val buffer = stack.malloc(length)
                GLES20.glGetProgramInfoLog(id, lengthBuffer, buffer)
                val infoBytes = ByteArray(length)
                buffer.get(infoBytes)
                val out = String(infoBytes)
                logger.info { "Program log: $out" }
            }
        }
    }

    @Throws(IOException::class)
    fun createProgram(shader: CompiledShader,
                      properties: Map<String, String>): Pair<Int, IntArray> {
        try {
            val shaderGenerator = SHADER_GENERATOR.get()
            val fragmentSource = shaderGenerator.generateFragment(shader.scope,
                    shader, properties)
            val vertexSource = shaderGenerator.generateVertex(shader.scope,
                    shader, properties)
            val vertex = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER)
            GLES20.glShaderSource(vertex, vertexSource)
            GLES20.glCompileShader(vertex)
            printLogShader(vertex)
            val fragment = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER)
            GLES20.glShaderSource(fragment, fragmentSource)
            GLES20.glCompileShader(fragment)
            printLogShader(fragment)
            val program = GLES20.glCreateProgram()
            GLES20.glAttachShader(program, vertex)
            GLES20.glAttachShader(program, fragment)
            GLES20.glLinkProgram(program)
            if (GLES20.glGetProgrami(program,
                    GLES20.GL_LINK_STATUS) != GLES20.GL_TRUE) {
                logger.error { "Failed to link status bar!" }
                printLogProgram(program)
            }
            val uniforms = shader.uniforms()
            val uniformLocations = IntArray(uniforms.size)
            for (i in uniforms.indices) {
                val uniform = uniforms[i]
                if (uniform == null) {
                    uniformLocations[i] = -1
                } else {
                    uniformLocations[i] = GLES20.glGetUniformLocation(program,
                            uniform.identifier.name)
                }
            }
            GLES20.glDetachShader(program, vertex)
            GLES20.glDetachShader(program, fragment)
            GLES20.glDeleteShader(vertex)
            GLES20.glDeleteShader(fragment)
            return Pair(program, uniformLocations)
        } catch (e: ShaderGenerateException) {
            throw IOException(e)
        }

    }
}