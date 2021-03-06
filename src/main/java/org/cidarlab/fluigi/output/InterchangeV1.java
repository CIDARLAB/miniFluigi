package org.cidarlab.fluigi.output;

/**
 * Created by krishna on 8/21/17.
 */

import org.cidarlab.fluigi.netlist.Component;
import org.cidarlab.fluigi.netlist.Connection;
import org.cidarlab.fluigi.netlist.Device;
import org.cidarlab.fluigi.netlist.LogicalLayer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Class that will have the ability to generate the JSON outputs in the standard interchange formats
 */
public class InterchangeV1 {

    public Device getRootDeviceObject() {
        return rootDeviceObject;
    }

    public void setRootDeviceObject(Device rootDeviceObject) {
        this.rootDeviceObject = rootDeviceObject;
    }

    private Device rootDeviceObject;
    private JSONObject rootJSONObject;
    private JSONArray connectionArray;
    private JSONArray layersArray;
    private HashMap<String, JSONObject> componentsMap;

    public InterchangeV1(){
        rootJSONObject = new JSONObject();
        connectionArray = new JSONArray();
        layersArray = new JSONArray();
        componentsMap = new HashMap<>();
    }

    /**
     *
     * @param device
     */
    public InterchangeV1(Device device){
        this();
        this.rootDeviceObject = device;
        generateNetlist();
    }

    /**
     *
     */
    private void generateNetlist() {
        rootJSONObject.put("version",1);
        rootJSONObject.put("name", rootDeviceObject.getName());

        //Generate the layers
        for(LogicalLayer layer : rootDeviceObject.getLogicalLayers()) {

            insertLayer(layer);

            //Generate each of the components in the layer
            for(Component component : layer.getComponents()){
                insertComponent(component, layer.getId());
            }
            //Generate each of the connections in the layer
            for(Connection connection : layer.getConnections()){
                insertConnection(connection);
            }
        }

        JSONArray componentlist = new JSONArray();
        for (String key: componentsMap.keySet()) {
            componentlist.add(componentsMap.get(key));
        }

        rootJSONObject.put("components", componentlist);
        rootJSONObject.put("connections", connectionArray);
        rootJSONObject.put("layers", layersArray);
    }

    /**
     * Fields to use
     */
    JSONObject tempJSONObject;

    /**
     *
     * @param connection
     */
    private void insertConnection(Connection connection) {
        tempJSONObject = new JSONObject();
        tempJSONObject.put("id",connection.getId());
        tempJSONObject.put("name", connection.getId());
        tempJSONObject.put("source", new TerminalJSON(connection.getSourceID(), connection.getTerminalLabel(connection.getSourceID())).getJSONObject());
        JSONArray sinks = new JSONArray();
        //Loop through the sinks
        for(String componentid : connection.getSinks()){
            sinks.add(new TerminalJSON(componentid, connection.getTerminalLabel(componentid)));
        }
        tempJSONObject.put("sinks",sinks);
        //TODO: Create the JSON params of the connection
        connectionArray.add(tempJSONObject);

    }

    /**
     *
     * @param component
     * @param layerid
     */
    private void insertComponent(Component component, String layerid) {
        //Check if it already exists
        if(componentsMap.containsKey(component.getId())){
            //Update the layers for this component
            ((JSONArray)
                    (componentsMap.get(layerid))
                            .get("layers"))
                    .add(layerid);

        } else {
            //Create the JSON of the component
            tempJSONObject.put("id", component.getId());
            tempJSONObject.put("name", component.getId());
            JSONArray layers = new JSONArray();
            layers.add(layerid);
            tempJSONObject.put("layers",layers);

            AbstractJSONMap abstractJSONMap = new AbstractJSONMap(component.getParams());

            tempJSONObject.put("params", abstractJSONMap);
            componentsMap.put(component.getId(), tempJSONObject);
        }
    }

    /**
     *
     * @param layer
     */
    private void insertLayer(LogicalLayer layer) {
        //Create the JSON of the layer
        tempJSONObject = new JSONObject();
        tempJSONObject.put("name", layer.getId());
        tempJSONObject.put("id", layer.getId());
        tempJSONObject.put("type", layer.getLayerType());
        layersArray.add(tempJSONObject);
    }

    public String getJSONString() {
        return rootJSONObject.toJSONString();
    }

    /**
     * Archetype class for generating JSON maps
     */
    private class AbstractJSONMap{
        protected HashMap<String, Object> map;
        public AbstractJSONMap(){
            map = new HashMap<>();
        }
        public AbstractJSONMap(HashMap<String, Object> maptoconvert){ map = maptoconvert; }
        public void put(String key, Object value){
            map.put(key,value);
        }
        public JSONObject getJSONObject(){
            return new JSONObject(map);
        }
    }

    /**
     * This is the class that will be used to generate the sink and source JSON
     */
    private class TerminalJSON extends AbstractJSONMap {
        public TerminalJSON(String sourceID, String teminallabel) {
            super();
            map.put("component", sourceID);
            map.put("port", teminallabel);
        }
    }
}
