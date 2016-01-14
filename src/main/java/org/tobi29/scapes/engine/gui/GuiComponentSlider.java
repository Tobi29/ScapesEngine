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

import java8.util.function.Function;
import org.tobi29.scapes.engine.opengl.GL;
import org.tobi29.scapes.engine.opengl.VAO;
import org.tobi29.scapes.engine.opengl.shader.Shader;
import org.tobi29.scapes.engine.opengl.texture.Texture;
import org.tobi29.scapes.engine.utils.Pair;
import org.tobi29.scapes.engine.utils.math.FastMath;
import org.tobi29.scapes.engine.utils.math.vector.Vector2;

public class GuiComponentSlider extends GuiComponentSlab {
    protected final GuiComponentText text;
    private final Function<Double, String> textFilter;
    private double value;
    private boolean hover;
    private Pair<VAO, Texture> vao;

    public GuiComponentSlider(GuiLayoutData parent, int textSize, String text,
            double value) {
        this(parent, textSize, text, value, (text1, value1) -> text1 + ": " +
                (int) (value1 * 100) +
                '%');
    }

    public GuiComponentSlider(GuiLayoutData parent, int textSize, String text,
            double value, TextFilter textFilter) {
        super(parent);
        this.value = value;
        this.textFilter = v -> textFilter.filter(text, v);
        this.text = addSubHori(4, 0, -1, textSize,
                p -> new GuiComponentText(p, this.textFilter.apply(value)));
        onDragLeft(event -> {
            setValue(FastMath.clamp(
                    (event.x() - 8) / (event.size().doubleX() - 16.0), 0, 1));
        });
        onClick((event, engine) -> engine.sounds()
                .playSound("Engine:sound/Click.ogg", "sound.GUI", 1.0f, 1.0f));
        onHover(event -> {
            switch (event.state()) {
                case ENTER:
                    hover = true;
                    dirty.set(true);
                    break;
                case LEAVE:
                    hover = false;
                    dirty.set(true);
                    break;
            }
        });
    }

    @Override
    public void renderComponent(GL gl, Shader shader, double delta,
            double width, double height) {
        vao.b.bind(gl);
        vao.a.render(gl, shader);
    }

    @Override
    protected void updateMesh(Vector2 size) {
        vao = gui.style().slider(size, true, (float) value, 16.0f, hover);
    }

    public double value() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        dirty.set(true);
        text.setText(textFilter.apply(value));
    }

    public interface TextFilter {
        String filter(String text, double value);
    }
}
