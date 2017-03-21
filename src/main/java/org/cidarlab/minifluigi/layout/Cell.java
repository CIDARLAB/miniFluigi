package org.cidarlab.minifluigi.layout;

/**
 * Created by krishna on 3/7/17.
 */
public class Cell {

    private final String id;
    private int x;
    private int y;
    private int w; //width x-span
    private int h; //height x-span

    public Cell(String id, int x, int y, int w, int h) {
        this.id = id;
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
    }

    public String getID() {
        return getId();
    }

    public String getId() {
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
}
