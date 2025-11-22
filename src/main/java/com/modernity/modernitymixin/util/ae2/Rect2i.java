package com.modernity.modernitymixin.util.ae2;

import com.github.bsideup.jabel.Desugar;

@Desugar
public record Rect2i(int x, int y, int width, int height) {
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
}
