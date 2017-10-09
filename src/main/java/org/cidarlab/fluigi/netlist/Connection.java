/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.netlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.cidarlab.fluigi.netlist.json.JSONKeyWords;
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
    // Component ID , Pin Number
    private HashMap<String, String> terminalMap;
    private ArrayList<String> sinks;
    private String layerID;



    public Connection(String id) {
        params = new HashMap<>();
        sinks = new ArrayList<>();
        terminalMap = new HashMap<>();
        this.id = id;

    }

    public void importFromJSON(JSONObject jsonconnection) {
        this.sourceID = (String)jsonconnection.get(JSONKeyWords.SOURCE);
        JSONArray sinks = (JSONArray)jsonconnection.get(JSONKeyWords.SINKS);

        for(Object sink : sinks){
            this.sinks.add((String)sink);
        }

        JSONObject paramsObject = (JSONObject) jsonconnection.get(JSONKeyWords.PARAMETERS);
        if (null != paramsObject) {
            JSONObject mapObject = (JSONObject) paramsObject.get(JSONKeyWords.PINMAP);
            if (null != mapObject) {
                for (Object key : mapObject.keySet()) {
                    terminalMap.put((String) key, (String) mapObject.get(key));
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
     * Returns sinks of the connection
     *
     * @return
     */
    public List<String> getSinks() {
        return sinks;
    }

    public void addSinkID(String id) {
        sinks.add(id);
    }

    public void updateTerminalMap(String id, String sourceterminal) {
        terminalMap.put(id, sourceterminal);
    }

    public String getId() {
        return id;
    }

    public String getTerminalLabel(String sourceID) {
        throw new UnsupportedOperationException();
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void addParam(String key, Object value) {
        params.put(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Connection)){
            return false;
        }
        return this.id.equals(((Connection)obj).getId());
    }
}
