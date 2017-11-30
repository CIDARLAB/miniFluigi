/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.model;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krishna
 */
public class LogicalLayer {

    private LogicalLayerType layerType;

    private List<Component> components;

    private List<Connection> connections;

    public LogicalLayerType getLayerType() {
        return layerType;
    }

    public void setLayerType(LogicalLayerType layerType) {
        this.layerType = layerType;
    }

    /**
     * Returns the id of Logical Layer
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the component list
     * @return
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * Returns the connection list
     * @return
     */
    public List<Connection> getConnections() {
        return connections;
    }

    /**
     * Add a component to the logical layer
     * @param component
     */
    public void addComponent(Component component) {
        this.components.add(component);
    }

    /**
     * Add a connection to the logical layer
     * @param connection
     */
    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }

    public enum LogicalLayerType {
        FLOW,
        CONTROL,
        EXT_INTEGRATION
    }

    private final String id;

    public LogicalLayer(String id) {
        this.id = id;
        components = new ArrayList<>();
        connections = new ArrayList<>();
    }

    /**
     * Import Logical Layer from the JSON Interchange V1
     * @param jsonlayer
     */
    public void importFromJSON(JSONObject jsonlayer) {
        JSONObject paramsObject = (JSONObject) jsonlayer.get("params");
        String layertype = (String) paramsObject.get("type");
        if (null != layertype) {
            switch (layertype) {
                case "FLOW":
                    this.layerType = LogicalLayerType.FLOW;
                    break;
                case "CONTROL":
                    this.layerType = LogicalLayerType.CONTROL;
                    break;
                case "EXT":
                    this.layerType = LogicalLayerType.EXT_INTEGRATION;
                    break;
                default:
                    this.layerType = LogicalLayerType.FLOW;
            }
        }

    }

}
