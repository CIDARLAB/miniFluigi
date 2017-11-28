package org.cidarlab.fluigi.manufacturing;

import java.util.HashMap;
import java.util.UUID;

public class Feature {

    private final String id;
    private String referenceid;
    private String drawmacro;
    private FeatureType type;
    private HashMap<String, Object> mparams;
    private int y;

    public Feature(){
        this.id = UUID.randomUUID().toString();
    }

    public Feature(String reference, FeatureType type){
        this();
        mparams = new HashMap<>();
        this.type = type;
        this.referenceid = reference;
    }

    public void setMParam(String key, Object value){
        mparams.put(key, value);
    }

    public FeatureType getType() {
        return type;
    }

    public int getX() {
        return ((int[])mparams.get("position"))[0];
    }

    public int getY() {
        return ((int[])mparams.get("position"))[1];
    }

    public int getHeight() {
        return (int)mparams.get("height");
    }
}
