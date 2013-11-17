/**
 * 
 */
package com.funzio.pure2D.uni;

import com.funzio.pure2D.gl.gl10.textures.TextureCoordBuffer;

/**
 * @author long
 */
public class UniRect extends UniObject {
    public static final int NUM_VERTICES = 4;

    public UniRect() {
        super();

        mVertices = new float[NUM_VERTICES * 2];
        mTextureCoords = new float[NUM_VERTICES * 2];
        TextureCoordBuffer.getDefault(mTextureCoords);
    }

    protected void setTextureCoords(final float[] source) {
        mTextureCoords[0] = source[0];
        mTextureCoords[1] = source[1];
        mTextureCoords[2] = source[2];
        mTextureCoords[3] = source[3];
        mTextureCoords[4] = source[4];
        mTextureCoords[5] = source[5];
        mTextureCoords[6] = source[6];
        mTextureCoords[7] = source[7];
    }

    @Override
    protected void resetVertices() {
        final float x = 0;
        final float y = 0;
        final float width = mSize.x;
        final float height = mSize.y;

        mVertices[0] = x;
        mVertices[1] = y + height;
        mVertices[2] = x;
        mVertices[3] = y;
        mVertices[4] = x + width;
        mVertices[5] = y + height;
        mVertices[6] = x + width;
        mVertices[7] = y;
    }
}