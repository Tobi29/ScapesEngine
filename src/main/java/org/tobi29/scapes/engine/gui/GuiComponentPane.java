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
import org.tobi29.scapes.engine.utils.math.vector.Vector2;
import org.tobi29.scapes.engine.utils.math.vector.Vector2d;

public class GuiComponentPane extends GuiComponent implements GuiContainerRow {
    public GuiComponentPane(GuiLayoutData parent) {
        super(parent);
    }

    public <T extends GuiComponent> T add(double x, double y, double width,
            double height, Function<GuiLayoutDataAbsolute, T> child) {
        return add(new Vector2d(x, y), new Vector2d(width, height), 0, child);
    }

    public <T extends GuiComponent> T add(double x, double y, double width,
            double height, long priority,
            Function<GuiLayoutDataAbsolute, T> child) {
        return add(new Vector2d(x, y), new Vector2d(width, height), priority,
                child);
    }

    public <T extends GuiComponent> T add(Vector2 pos, Vector2 size,
            long priority, Function<GuiLayoutDataAbsolute, T> child) {
        GuiLayoutDataAbsolute layoutData =
                new GuiLayoutDataAbsolute(this, pos, size, priority);
        T component = child.apply(layoutData);
        append(component);
        return component;
    }

    @Override
    public <T extends GuiComponent> T addVert(Vector2 marginStart,
            Vector2 marginEnd, Vector2 size, long priority,
            Function<GuiLayoutDataVertical, T> child) {
        GuiLayoutDataVertical layoutData =
                new GuiLayoutDataVertical(this, marginStart, marginEnd, size,
                        priority);
        T component = child.apply(layoutData);
        append(component);
        return component;
    }

    protected <T extends GuiComponent> T addSubVert(double marginX,
            double marginY, double width, double height,
            Function<GuiLayoutDataVertical, T> child) {
        return addSubVert(marginX, marginY, marginX, marginY, width, height,
                child);
    }

    public <T extends GuiComponent> T addSubVert(double marginStartX,
            double marginStartY, double marginEndX, double marginEndY,
            double width, double height,
            Function<GuiLayoutDataVertical, T> child) {
        return addSubVert(marginStartX, marginStartY, marginEndX, marginEndY,
                width, height, 0, child);
    }

    public <T extends GuiComponent> T addSubVert(double marginStartX,
            double marginStartY, double marginEndX, double marginEndY,
            double width, double height, long priority,
            Function<GuiLayoutDataVertical, T> child) {
        return addSubVert(new Vector2d(marginStartX, marginStartY),
                new Vector2d(marginEndX, marginEndY),
                new Vector2d(width, height), priority, child);
    }

    public <T extends GuiComponent> T addSubVert(Vector2 marginStart,
            Vector2 marginEnd, Vector2 size, long priority,
            Function<GuiLayoutDataVertical, T> child) {
        GuiLayoutDataVertical layoutData =
                new GuiLayoutDataVertical(this, marginStart, marginEnd, size,
                        priority, true);
        T component = child.apply(layoutData);
        append(component);
        return component;
    }

    public GuiComponentGroup spacer() {
        return spacer(0);
    }

    public GuiComponentGroup spacer(long priority) {
        return addVert(0, 0, 0, 0, -1, -1, priority, GuiComponentGroup::new);
    }

    @Override
    protected GuiLayoutManager newLayoutManager(Vector2 size) {
        return new GuiLayoutManagerVertical(Vector2d.ZERO, size, components);
    }
}
