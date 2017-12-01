package org.cidarlab.fluigi.layout;

/**
 * Created by krishna on 7/25/17.
 */
public class Point {
    private int x;
    private int y;

    public Point(int ix, int iy) {
        x = ix;
        y = iy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point add(Point that) {
        return new Point(x + that.x, y + that.y);
    }

    public Point subtract(Point that) {
        return new Point(x - that.x, y - that.y);
    }

    public Point midPoint(Point that) {
        return new Point(
                (x + that.x) / 2,
                (y + that.y) / 2
        );
    }

    public int manhattanDistance(Point that) {
        return Math.abs(x - that.x) + Math.abs(y - that.y);
    }

    public static Point zero() {
        return new Point(0, 0);
    }
}
