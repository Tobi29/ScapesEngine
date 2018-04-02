/*
 * Copyright 2012-2018 Tobi29
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

package org.tobi29.scapes.engine.backends.js

import kotlinx.coroutines.experimental.awaitAnimationFrame
import org.tobi29.scapes.engine.Container
import org.tobi29.scapes.engine.ScapesEngine
import org.tobi29.scapes.engine.gui.GuiController
import org.tobi29.utils.steadyClock
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.window
import org.khronos.webgl.WebGLRenderingContext as WGL1
import org.khronos.webgl2.WebGL2RenderingContext as WGL2

class ContainerCanvas(
    val canvas: HTMLCanvasElement,
    wgl: WGL2
) : ContainerWebGL2(wgl) {
    // TODO: Detect this?
    override val formFactor = Container.FormFactor.DESKTOP
    // TODO: HiDPI
    override val containerWidth get() = canvas.width
    override val containerHeight get() = canvas.height

    fun render(
        delta: Double,
        engine: ScapesEngine
    ) = renderCall { gl ->
        engine.graphics.render(
            gl,
            delta,
            canvas.width,
            canvas.height,
            canvas.width,
            canvas.height
        )
    }

    // TODO: Implement?
    override fun stop() {}

    override fun message(
        messageType: Container.MessageType,
        title: String,
        message: String
    ) {
    }

    override fun dialog(
        title: String,
        text: GuiController.TextFieldData,
        multiline: Boolean
    ) {
    }
}

suspend fun ContainerCanvas.run(engine: ScapesEngine): Nothing {
    engine.start()
    var lastTime = steadyClock.timeSteadyNanos()
    while (true) {
        window.awaitAnimationFrame()
        val time = steadyClock.timeSteadyNanos()
        val delta = (time - lastTime) / 1000000000.0
        lastTime = time

        val style = window.getComputedStyle(canvas)
        val width = style.getPropertyValue("width").removeSuffix(
            "px"
        ).toDouble().toInt()
        val height = style.getPropertyValue("height").removeSuffix(
            "px"
        ).toDouble().toInt()

        if (canvas.width != width) canvas.width = width
        if (canvas.height != height) canvas.height = height

        render(delta, engine)
    }
}
