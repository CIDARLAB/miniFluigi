/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.netlist;

import org.json.simple.JSONObject;

/**
 *
 * @author krishna
 */
public class LogicalLayer {

    private LogicalLayerType layerType;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public enum LogicalLayerType {
        FLOW,
        CONTROL,
        EXT_INTEGRATION
    }

    private final String id;

    public LogicalLayer(String id) {
        this.id = id;
    }

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
