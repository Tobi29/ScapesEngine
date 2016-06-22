/*
 * Copyright 2012-2015 Tobi29
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
package org.tobi29.scapes.engine.opengl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tobi29.scapes.engine.Container;
import org.tobi29.scapes.engine.GameState;
import org.tobi29.scapes.engine.ScapesEngine;
import org.tobi29.scapes.engine.gui.debug.GuiWidgetDebugValues;
import org.tobi29.scapes.engine.opengl.shader.ShaderManager;
import org.tobi29.scapes.engine.opengl.texture.TextureManager;
import org.tobi29.scapes.engine.utils.graphics.Image;
import org.tobi29.scapes.engine.utils.graphics.PNG;
import org.tobi29.scapes.engine.utils.io.filesystem.FilePath;
import org.tobi29.scapes.engine.utils.io.filesystem.FileUtil;
import org.tobi29.scapes.engine.utils.profiler.Profiler;

import java.io.IOException;

public class GraphicsSystem {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GraphicsSystem.class);
    private final ScapesEngine engine;
    private final GuiWidgetDebugValues.Element fpsDebug, widthDebug,
            heightDebug, textureDebug, vaoDebug, fboDebug;
    private final GL gl;
    private boolean triggerScreenshot;
    private double resolutionMultiplier = 1.0;
    private GameState renderState;

    public GraphicsSystem(ScapesEngine engine, GL gl) {
        this.engine = engine;
        this.gl = gl;
        // Init empty texture as engine can access container now
        gl.textures().init();
        resolutionMultiplier = engine.config().resolutionMultiplier();
        GuiWidgetDebugValues debugValues = engine.debugValues();
        fpsDebug = debugValues.get("Graphics-Fps");
        widthDebug = debugValues.get("Graphics-Width");
        heightDebug = debugValues.get("Graphics-Height");
        textureDebug = debugValues.get("Graphics-Textures");
        vaoDebug = debugValues.get("Graphics-VAOs");
        fboDebug = debugValues.get("Graphics-FBOs");
    }

    public void dispose() {
        engine.halt();
        synchronized (this) {
            GameState state = engine.state();
            state.disposeState(gl);
            gl.dispose();
        }
    }

    public ScapesEngine engine() {
        return engine;
    }

    public TextureManager textures() {
        return gl.textures();
    }

    public ShaderManager shaders() {
        return gl.shaders();
    }

    @SuppressWarnings("CallToNativeMethodWhileLocked")
    public synchronized void render(double delta) {
        engine.unlockUpdate();
        try {
            gl.checkError("Pre-Render");
            Container container = engine.container();
            int containerWidth = container.containerWidth();
            int containerHeight = container.containerHeight();
            boolean fboSizeDirty;
            double resolutionMultiplier =
                    engine.config().resolutionMultiplier();
            if (container.contentResized() ||
                    this.resolutionMultiplier != resolutionMultiplier) {
                this.resolutionMultiplier = resolutionMultiplier;
                int contentWidth = container.contentWidth();
                int contentHeight = container.contentHeight();
                fboSizeDirty = true;
                widthDebug.setValue(contentWidth);
                heightDebug.setValue(contentHeight);
                try (Profiler.C ignored = Profiler.section("Reshape")) {
                    gl.reshape(contentWidth, contentHeight, containerWidth,
                            containerHeight, resolutionMultiplier);
                }
            } else {
                fboSizeDirty = false;
            }
            GameState state = engine.state();
            if (renderState != state) {
                try (Profiler.C ignored = Profiler.section("SwitchState")) {
                    if (renderState != null) {
                        renderState.disposeState(gl);
                        gl.fboTracker().disposeAll(gl);
                        gl.shaders().disposeAll(gl);
                        gl.textures().clearCache();
                    }
                    renderState = state;
                }
            }
            try (Profiler.C ignored = Profiler.section("State")) {
                state.render(gl, delta, fboSizeDirty);
            }
            fpsDebug.setValue(1.0 / delta);
            textureDebug.setValue(gl.textureTracker().textureCount());
            vaoDebug.setValue(gl.vaoTracker().vaoCount());
            fboDebug.setValue(gl.fboTracker().fboCount());
            if (triggerScreenshot) {
                try (Profiler.C ignored = Profiler.section("Screenshot")) {
                    triggerScreenshot = false;
                    int width = gl.contentWidth(), height = gl.contentHeight();
                    Image image = gl.screenShot(0, 0, width, height);
                    FilePath path = engine.home().resolve("screenshots/" +
                            System.currentTimeMillis() +
                            ".png");
                    engine.taskExecutor().runTask(() -> {
                        try {
                            FileUtil.write(path, stream -> PNG
                                    .encode(image, stream, 9, false));
                        } catch (IOException e) {
                            LOGGER.error("Error saving screenshot: {}",
                                    e.toString());
                        }
                    }, "Write-Screenshot");
                }
            }
            try (Profiler.C ignored = Profiler.section("Cleanup")) {
                gl.vaoTracker().disposeUnused(gl);
                gl.textureTracker().disposeUnused(gl);
            }
        } catch (GraphicsException e) {
            LOGGER.warn("Graphics error during rendering: {}", e.toString());
        }
    }

    public void triggerScreenshot() {
        triggerScreenshot = true;
    }

    @OpenGLFunction
    public void clear() {
        gl.dispose();
    }

    @OpenGLFunction
    public void reset() {
        gl.reset();
    }
}
