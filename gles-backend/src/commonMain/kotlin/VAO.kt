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

package org.tobi29.scapes.engine.backends.opengles

import net.gitout.ktbindings.gles.GLES30
import net.gitout.ktbindings.gles.emptyGLUniformLocation
import net.gitout.ktbindings.gles.glUniformMatrix3fv
import net.gitout.ktbindings.gles.glUniformMatrix4fv
import org.tobi29.scapes.engine.graphics.GL
import org.tobi29.scapes.engine.graphics.GraphicsObjectSupplier
import org.tobi29.scapes.engine.graphics.Model
import org.tobi29.scapes.engine.graphics.Shader

internal abstract class VAO(
    protected val glh: GLESImpl<GLES30>
) : Model {
    override val gos: GraphicsObjectSupplier get() = glh
    protected var used: Long = 0
    override var isStored = false
    protected var markDisposed = false
    override var weak = false
    protected var detach: (() -> Unit)? = null

    override fun markAsDisposed() {
        markDisposed = true
    }

    abstract override fun render(
        gl: GL,
        shader: Shader
    ): Boolean

    abstract override fun render(
        gl: GL,
        shader: Shader,
        length: Int
    ): Boolean

    abstract override fun renderInstanced(
        gl: GL,
        shader: Shader,
        count: Int
    ): Boolean

    abstract override fun renderInstanced(
        gl: GL,
        shader: Shader,
        length: Int,
        count: Int
    ): Boolean

    override fun ensureStored(gl: GL): Boolean {
        if (!isStored) {
            val success = store(gl)
            used = gl.timestamp
            return success
        }
        used = gl.timestamp
        return true
    }

    override fun ensureDisposed(gl: GL) {
        if (isStored) {
            dispose(gl)
        }
    }

    override fun isUsed(time: Long) =
        time - used < 1000000000L && !markDisposed

    protected abstract fun store(gl: GL): Boolean

    protected fun shader(
        gl: GL,
        shader: Shader
    ) {
        gl.check()
        if (shader !is ShaderGL) throw IllegalArgumentException("Shader from different implementation")
        val matrix = gl.matrixStack.current()
        shader.activate(gl)
        shader.updateUniforms(gl)
        var uniformLocation = shader.uniformLocation(0)
        if (uniformLocation != emptyGLUniformLocation) {
            glh.gl.glUniformMatrix4fv(
                uniformLocation, false,
                matrix.modelViewMatrix.array.array
            )
        }
        uniformLocation = shader.uniformLocation(1)
        if (uniformLocation != emptyGLUniformLocation) {
            glh.gl.glUniformMatrix4fv(
                uniformLocation, false,
                matrix.modelViewProjectionMatrix.array.array
            )
        }
        uniformLocation = shader.uniformLocation(2)
        if (uniformLocation != emptyGLUniformLocation) {
            glh.gl.glUniformMatrix3fv(
                uniformLocation, false,
                matrix.normalMatrix.array.array
            )
        }
    }
}
