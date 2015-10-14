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
package org.tobi29.scapes.engine.gui;

import org.tobi29.scapes.engine.ScapesEngine;
import org.tobi29.scapes.engine.opengl.FontRenderer;
import org.tobi29.scapes.engine.opengl.GL;
import org.tobi29.scapes.engine.opengl.VAO;
import org.tobi29.scapes.engine.opengl.shader.Shader;
import org.tobi29.scapes.engine.opengl.texture.Texture;
import org.tobi29.scapes.engine.utils.Pair;
import org.tobi29.scapes.engine.utils.math.FastMath;

public class GuiComponentSlider extends GuiComponent {
    private final String text;
    private final float textSize;
    private final int textX, textY;
    private final TextFilter textFilter;
    private double value;
    private boolean hover, dragging;
    private FontRenderer.Text vaoText;
    private Pair<VAO, Texture> vao;

    public GuiComponentSlider(GuiComponent parent, int x, int y, int width,
            int height, int textSize, String text, double value) {
        this(parent, x, y, width, height, textSize, text, value,
                (text1, value1) -> text1 + ": " +
                        (int) (value1 * 100) +
                        '%');
    }

    public GuiComponentSlider(GuiComponent parent, int x, int y, int width,
            int height, int textSize, String text, double value,
            TextFilter textFilter) {
        super(parent, x, y, width, height);
        this.text = text;
        this.textSize = textSize;
        this.value = value;
        this.textFilter = textFilter;
        textX = 4;
        textY = (height - textSize) / 2;
        updateMesh();
        updateText();
    }

    @Override
    public void clickLeft(GuiComponentEvent event, ScapesEngine engine) {
        super.clickLeft(event, engine);
        dragging = true;
    }

    @Override
    public void renderComponent(GL gl, Shader shader, double delta) {
        vao.b.bind(gl);
        vao.a.render(gl, shader);
        vaoText.render(gl, shader);
    }

    @Override
    public void setHover(boolean hover, ScapesEngine engine) {
        if (this.hover != hover) {
            this.hover = hover;
            updateMesh();
        }
    }

    @Override
    public void update(double mouseX, double mouseY, boolean mouseInside,
            ScapesEngine engine) {
        super.update(mouseX, mouseY, mouseInside, engine);
        if (dragging) {
            if (engine.guiController().leftDrag()) {
                value = FastMath.clamp((mouseX - 8) / (width - 16.0), 0, 1);
                updateText();
                updateMesh();
                if (hovering) {
                    hover(new GuiComponentHoverEvent(mouseX, mouseY,
                            GuiComponentHoverEvent.State.HOVER));
                } else {
                    hover(new GuiComponentHoverEvent(mouseX, mouseY,
                            GuiComponentHoverEvent.State.ENTER));
                    hovering = true;
                }
            } else {
                dragging = false;
            }
        }
        if (checkInside(mouseX, mouseY)) {
            if (engine.guiController().leftClick()) {
                engine.sounds()
                        .playSound("Engine:sound/Click.ogg", "sound.GUI", 1.0f,
                                1.0f);
            }
        }
    }

    private void updateText() {
        FontRenderer font = gui.style().font();
        vaoText = font.render(textFilter.filter(text, value), textX, textY,
                textSize, width, 1.0f, 1.0f, 1.0f, 1);
    }

    private void updateMesh() {
        vao = gui.style()
                .slider(width, height, true, (float) value, 16.0f, hover);
    }

    public double value() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        updateMesh();
    }

    public interface TextFilter {
        String filter(String text, double value);
    }
}
