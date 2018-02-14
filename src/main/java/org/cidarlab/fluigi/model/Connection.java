/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.model;

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
    /**
     *   Stores the connectivity as Map :Component ID , Pin Number:
     */
    private HashMap<String, String> terminalMap;
    private ArrayList<String> sinks;
    private String layerID;
    private String technology;


    public Connection(String id) {
        params = new HashMap<>();
        sinks = new ArrayList<>();
        terminalMap = new HashMap<>();
        this.id = id;

    }

    /**
     * Imports the connection object from JSON interchange V1
     * @param jsonconnection
     */
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
     * Returns the layer
     * //TODO: change this to list so that we can allow multilayer routing
     * @return the layerID
     */
    public String getLayerID() {
        return layerID;
    }

    /**
     * Sets the layer id of the connection
     * TODO: Update this to list so that we can do multilayer stuff
     * @param layerID the layerID to set
     */
    public void setLayerID(String layerID) {
        this.layerID = layerID;
    }

    /**
     * Returns sinks (IDs) of the connection
     *
     * @return
     */
    public List<String> getSinks() {
        return sinks;
    }

    /**
     * Adds a sink to the connection
     * @param id
     */
    public void addSinkID(String id) {
        sinks.add(id);
    }

    /**
     * Associates a terminal to the component. This data-structure can be used if we do pin assignment
     * @param id
     * @param sourceterminal
     */
    public void updateTerminalMap(String id, String sourceterminal) {
        terminalMap.put(id, sourceterminal);
    }

    /**
     * Returns the id of the connection
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Get the terminal associated with a source or a sink associated with this connection
     * @param componentID
     * @return
     */
    public String getTerminalLabel(String componentID) {
        return terminalMap.get(componentID);
    }

    /**
     * Returns the params hashmap
     * @return
     */
    public HashMap<String, Object> getParams() {
        return params;
    }

    /**
     * Insert key, value in connection params
     * @param key
     * @param value
     */
    public void addParam(String key, Object value) {
        params.put(key, value);
    }

    /**
     * Returns the technology associated with the connection
     * @return
     */
    public String getTechnology() {
        return technology;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Connection)){
            return false;
        }
        return this.id.equals(((Connection)obj).getId());
    }

    /**
     * Sets the technology associated with the connection
     * @param technology
     */
    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
