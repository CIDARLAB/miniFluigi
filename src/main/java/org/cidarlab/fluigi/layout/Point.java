package org.cidarlab.fluigi.layout;

/**
 * Created by krishna on 7/25/17.
 */
public class Point {
    private int x;
    private int y;

    public Point() {

    }

    public Point(int ix, int iy) {
        x = ix;
        y = iy;
    }

    /**
     * Returns the X coordinate of the point
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the X coordinate of the point
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the Y coordinate of the point
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Y coordinate of the point
     * @param y
     */
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
