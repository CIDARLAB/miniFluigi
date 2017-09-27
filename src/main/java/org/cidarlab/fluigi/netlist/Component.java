/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.netlist;

import java.util.HashMap;

import org.json.simple.JSONObject;

/**
 *
 * @author krishna
 */
public class Component {

    private String id;
    private String technology;
    private HashMap<String, Object> params;
    private int x,y,w,h;
    private TechEntity.ComponentType type;
    private Orientation orientation;

    private HashMap<String, Terminal> terminalsHashMap;

    public Component(String id) {
        params = new HashMap<>();
        terminalsHashMap = new HashMap<>();
        this.id = id;
    }

    public void importFromJSON(JSONObject jsoncomponent) {
        this.setTechnology((String) jsoncomponent.get(JSONKeyWords.TECHNOLOGY));
        JSONObject paramsoObject = (JSONObject) jsoncomponent.get(JSONKeyWords.PARAMETERS);
        for(Object key : paramsoObject.keySet()){
            Object value  = jsoncomponent.get(key);
            getParams().put((String)key, value);
        }
    }



    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the technology
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * @param technology the technology to set
     */
    public void setTechnology(String technology) {
        this.technology = technology;
    }

    /**
     * @return the params
     */
    public HashMap<String, Object> getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the w
     */
    public int getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setXSpan(int w) {
        this.w = w;
    }

    /**
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setYSpan(int h) {
        this.h = h;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Component)) {
            return false;
        }
        return this.id.equals(((Component) o).getId());
    }

    public void addParam(String key, Object o) {
        params.put(key, o);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public enum Orientation{
        HORIZONTAL,
        VERTICAL
    }
}
