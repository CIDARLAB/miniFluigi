package org.cidarlab.minifluigi.layout;

import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class Cell {

    private final String id;
    private int x;
    private int y;
    private int w; //width x-span
    private int h; //height y-span

    private HashMap<String, Object> annotation;

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

    @Override
    public boolean equals(Object obj) {
        return id.equals(((Cell)obj).getID());
    }

    public void addAnnotation(String key, Object value){
        if(null == annotation){
            annotation = new HashMap<>();
        }
        annotation.put(key,value);
    }

    public Object getAnnotion(String key){
        if(null == annotation){
            return null;
        }
        return annotation.get(key);
    }

}
