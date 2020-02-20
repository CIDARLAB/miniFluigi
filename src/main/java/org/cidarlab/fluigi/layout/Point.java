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



    /*
    https://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle
    ----
    float sign (fPoint p1, fPoint p2, fPoint p3)
    {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    bool PointInTriangle (fPoint pt, fPoint v1, fPoint v2, fPoint v3)
    {
        float d1, d2, d3;
        bool has_neg, has_pos;

        d1 = sign(pt, v1, v2);
        d2 = sign(pt, v2, v3);
        d3 = sign(pt, v3, v1);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }
     */

    /**
     * Checks if the Point is within a Triangle described by their vertices
     * @param v1
     * @param v2
     * @param v3
     * @return
     */
    public boolean isPointInTriangle(Point v1, Point v2, Point v3){
        float d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = Point.sign(this, v1, v2);
        d2 = Point.sign(this, v2, v3);
        d3 = Point.sign(this, v3, v1);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }


    private static float sign(Point p1, Point p2, Point p3){
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }
}
