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
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public String getID() {
        return id;
    }
}
