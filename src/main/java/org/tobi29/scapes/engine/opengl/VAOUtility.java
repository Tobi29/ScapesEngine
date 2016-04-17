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

import java.util.ArrayList;
import java.util.List;

public class VAOUtility {
    public static VAOFast createV(float[] vertex, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVI(float[] vertex, int[] index,
            RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }

    public static VAOFast createVN(float[] vertex, float[] normal,
            RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.NORMAL_ATTRIBUTE, 3, normal,
                        true, 0, VertexType.BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVNI(float[] vertex, float[] normal,
            int[] index, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.NORMAL_ATTRIBUTE, 3, normal,
                        true, 0, VertexType.BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }

    public static VAOFast createVC(float[] vertex, float[] color,
            RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes.add(new VBO.VBOAttribute(OpenGL.COLOR_ATTRIBUTE, 4, color,
                true, 0, VertexType.UNSIGNED_BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVCI(float[] vertex, float[] color,
            int[] index, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes.add(new VBO.VBOAttribute(OpenGL.COLOR_ATTRIBUTE, 4, color,
                true, 0, VertexType.UNSIGNED_BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }

    public static VAOFast createVT(float[] vertex, float[] texture,
            RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVTI(float[] vertex, float[] texture,
            int[] index, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }

    public static VAOFast createVTN(float[] vertex, float[] texture,
            float[] normal, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.NORMAL_ATTRIBUTE, 3, normal,
                        true, 0, VertexType.BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVTNI(float[] vertex, float[] texture,
            float[] normal, int[] index, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.NORMAL_ATTRIBUTE, 3, normal,
                        true, 0, VertexType.BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }

    public static VAOFast createVCT(float[] vertex, float[] color,
            float[] texture, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes.add(new VBO.VBOAttribute(OpenGL.COLOR_ATTRIBUTE, 4, color,
                true, 0, VertexType.UNSIGNED_BYTE));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVCTI(float[] vertex, float[] color,
            float[] texture, int[] index, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes.add(new VBO.VBOAttribute(OpenGL.COLOR_ATTRIBUTE, 4, color,
                true, 0, VertexType.UNSIGNED_BYTE));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }

    public static VAOFast createVCTN(float[] vertex, float[] color,
            float[] texture, float[] normal, RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes.add(new VBO.VBOAttribute(OpenGL.COLOR_ATTRIBUTE, 4, color,
                true, 0, VertexType.UNSIGNED_BYTE));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.NORMAL_ATTRIBUTE, 3, normal,
                        true, 0, VertexType.BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOFast(vbo, renderType);
    }

    public static VAOStatic createVCTNI(float[] vertex, float[] color,
            float[] texture, float[] normal, int[] index,
            RenderType renderType) {
        List<VBO.VBOAttribute> vboAttributes = new ArrayList<>();
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.VERTEX_ATTRIBUTE, 3, vertex,
                        false, 0, VertexType.HALF_FLOAT));
        vboAttributes.add(new VBO.VBOAttribute(OpenGL.COLOR_ATTRIBUTE, 4, color,
                true, 0, VertexType.UNSIGNED_BYTE));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.TEXTURE_ATTRIBUTE, 2, texture,
                        false, 0, VertexType.FLOAT));
        vboAttributes
                .add(new VBO.VBOAttribute(OpenGL.NORMAL_ATTRIBUTE, 3, normal,
                        true, 0, VertexType.BYTE));
        VBO vbo = new VBO(vboAttributes, vertex.length / 3);
        return new VAOStatic(vbo, index, renderType);
    }
}
