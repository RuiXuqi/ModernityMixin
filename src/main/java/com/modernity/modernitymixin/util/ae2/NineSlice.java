package com.modernity.modernitymixin.util.ae2;

import com.github.bsideup.jabel.Desugar;

// Info of the texture
@Desugar
public record NineSlice(int width, int height, Border border) {
    @Desugar
    public record Border(int left, int top, int right, int bottom) {
        public Border(int border) {
            this(border, border, border, border);
        }
    }

    public NineSlice(int width, int height, int border) {
        this(width, height, new Border(border));
    }
}
