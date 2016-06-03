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
package org.tobi29.scapes.engine.opengl.texture;

import org.tobi29.scapes.engine.ScapesEngine;
import org.tobi29.scapes.engine.opengl.GL;
import org.tobi29.scapes.engine.opengl.OpenGLFunction;

public class TextureFBODepth extends Texture {
    private boolean attached = true;

    public TextureFBODepth(ScapesEngine engine, int width, int height,
            TextureFilter minFilter, TextureFilter magFilter, TextureWrap wrapS,
            TextureWrap wrapT) {
        super(engine, width, height, null, 0, minFilter, magFilter, wrapS,
                wrapT);
    }

    public void resize(int width, int height, GL gl) {
        if (stored) {
            dispose(gl);
        }
        this.width = width;
        this.height = height;
        store(gl);
    }

    @OpenGLFunction
    public void attachDepth(GL gl) {
        ensureStored(gl);
        gl.attachDepth(textureID);
    }

    public void detached() {
        attached = false;
    }

    @Override
    protected void store(GL gl) {
        assert !stored;
        textureID = gl.createTexture();
        gl.bindTexture(textureID);
        gl.bufferTextureDepth(width, height, null);
        dirtyFilter = true;
        detach = gl.textureTracker().attach(this);
        stored = true;
    }

    @Override
    protected boolean used(long time) {
        return attached;
    }
}
