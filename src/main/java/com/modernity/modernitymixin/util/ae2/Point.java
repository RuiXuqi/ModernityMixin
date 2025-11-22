package com.modernity.modernitymixin.util.ae2;

/**
 * Represents a x,y coordinate in the UI.
 */
public final class Point {

    public static final Point ZERO = new Point(0, 0);

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromTopLeft(Rect2i bounds) {
        return new Point(bounds.getX(), bounds.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point move(int x, int y) {
        return new Point(this.x + x, this.y + y);
    }

    public boolean isIn(Rect2i rect) {
        return x >= rect.getX()
                && y >= rect.getY()
                && x < rect.getX() + rect.getWidth()
                && y < rect.getY() + rect.getHeight();
    }

}
