/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.netlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author krishna
 */
public class Connection {

    private final HashMap<String, Object> params;
    private final String id;
    private String sourceID;
    private HashMap<String, Integer> pinMap;
    private ArrayList<String> targets;
    private String layerID;

    public Connection(String id) {
        params = new HashMap<>();
        targets = new ArrayList<>();
        pinMap = new HashMap<>();
        this.id = id;

    }

    public void importFromJSON(JSONObject jsonconnection) {
        this.sourceID = (String)jsonconnection.get(JSONKeyWords.SOURCE);
        JSONArray sinks = (JSONArray)jsonconnection.get(JSONKeyWords.SINKS);

        for(Object sink : sinks){
            targets.add((String)sink);
        }

        JSONObject paramsObject = (JSONObject) jsonconnection.get(JSONKeyWords.PARAMETERS);
        if (null != paramsObject) {
            JSONObject mapObject = (JSONObject) paramsObject.get(JSONKeyWords.PINMAP);
            if (null != mapObject) {
                for (Object key : mapObject.keySet()) {
                    pinMap.put((String) key, (int) mapObject.get(key));
                }
            }
        }
    }


    /**
     * @return the sourceID
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * @param sourceID the sourceID to set
     */
    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    /**
     * @return the layerID
     */
    public String getLayerID() {
        return layerID;
    }

    /**
     * @param layerID the layerID to set
     */
    public void setLayerID(String layerID) {
        this.layerID = layerID;
    }

    /**
     * Returns targets of the connection
     *
     * @return
     */
    public List<String> getTargets() {
        return targets;
    }

}
