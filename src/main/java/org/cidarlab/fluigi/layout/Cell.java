package org.cidarlab.fluigi.layout;

/**
 * Created by krishna on 3/7/17.
 */
public class Cell {

    private final String id;
    private int x;
    private int y;
    private int w; //width x-span
    private int h; //height y-span

    public Cell(String id, int x, int y, int w, int h) {
        this.id = id;
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
    }

    public String getID() {
        return id;
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getCenterX(){ return (x+w)/2; }

    public double getCenterY(){ return (y+h)/2; }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Cell) && ((Cell) obj).getID().equals(this.getID());
    }

    public int getMaxX() {
        return x + w;
    }

    public int getMaxY() {
        return y + h;
    }
}
