/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.model;

import org.cidarlab.fluigi.manufacturing.DrawLayer;
import org.cidarlab.fluigi.manufacturing.Feature;
import org.cidarlab.fluigi.netlist.constraints.Constraint;
import org.cidarlab.fluigi.netlist.technology.TechEntity;
import org.cidarlab.fluigi.netlist.technology.TechLibrary;
import org.jgrapht.graph.DirectedMultigraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author krishna
 */
public class Device {

    private List<String> dependencies;
    private String name;
    private String comments;
    private HashMap<String,LogicalLayer> layersHashMap;
    private ArrayList<Component> components;
    private ArrayList<Connection> connections;
    private HashMap<Connection, Component> valvemap;
    private List<Component> imports;
    private List<LayerBlock> layerBlocks;
    private List<Constraint> constraintList;
    private List<Feature> features;
    private List<DrawLayer> drawLayers;
    private DirectedMultigraph<Component, Connection> globalConnectionGraph;

    public Device(){
        layerBlocks = new ArrayList<>();
        layersHashMap = new HashMap<>();
        connections = new ArrayList<>();
        components = new ArrayList<>();
        dependencies = new ArrayList<>();
        valvemap = new HashMap<>();
        imports = new ArrayList<>();
        constraintList = new ArrayList<>();
        globalConnectionGraph = new DirectedMultigraph<>(Connection.class);
    }

    public Device(String string) {
        this();
        this.name = string;
    }

    /**
     * Sets string comments associated with the device. This is a TBA function that still needs to be figured out into
     * the interchange standard
     * @param string
     */
    public void setComments(String string) {
        this.comments = string;
    }

    /**
     * Adds a logical layer to the device
     * @param layer
     */
    public void addLayer(LogicalLayer layer) {
        layersHashMap.put(layer.getId(), layer);
    }

    /**
     * Adds a component to the device (with regards to the respective layer id)
     * @param component
     * @param layerid
     */
    public void addComponent(Component component, String layerid) {
        if(dependencies.contains(component.getTechnology())){
            imports.add(component);
        }
        components.add(component);

        //Register component in the given layer
        if(!layersHashMap.containsKey(layerid)){
            throw new UnsupportedOperationException("It seems like the layer does not exist");
        }
        LogicalLayer layer = layersHashMap.get(layerid);
        layer.addComponent(component);

        //Also add something to the global graph
        globalConnectionGraph.addVertex(component);
    }

    /**
     * Adds a connection to the device with regards to the respective logical layerid
     * @param connection
     * @param layerid
     */
    public void addConnection(Connection connection, String layerid) {
        connections.add(connection);
        if(!layersHashMap.containsKey(layerid)){
            throw new UnsupportedOperationException("It seems like the layer does not exist");
        }
        LogicalLayer layer = layersHashMap.get(layerid);
        layer.addConnection(connection);

        for(String sinkid : connection.getSinks()){
            //TODO: Change this if it breaks
            globalConnectionGraph.addEdge(this.getComponent(connection.getSourceID()), this.getComponent(sinkid), connection);
        }

    }

    /**
     * Gets component with the given ID
     * @param id
     * @return
     */
    public Component getComponent(String id){
        for(Component c : components){
            if(c.getId().equals(id)){
                return c;
            }
        }

        return null;
    }

    /**
     * Gets the connection with the given ID
     * @param id
     * @return
     */
    public Connection getConnection(String id) {
        for(Connection c : connections){
            if(c.getId().equals(id)){
                return c;
            }
        }

        return null;
    }

    /**
     * Adds a Valve Component onto a connection
     * @param component
     * @param connection
     */
    public void addValve(Component component, Connection connection) {
        this.valvemap.put(connection, component);
    }


    /**
     * Removes a valve from the valvemap in the device object
     * @param connection
     */
    public void removeValve(Connection connection){
        this.valvemap.remove(connection);
    }

    /**
     * Returns the name of the device
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of all the components in the device
     * @return
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * Returns a list of all the imports used in the device
     * @return
     */
    public List<Component> getImports() {
        return imports;
    }

    /**
     * Returns a list of all the connections in the device
     * @return
     */
    public List<Connection> getConnections() {
        return connections;
    }

    public List<LogicalLayer> getLogicalLayers() {
        List<LogicalLayer> ret = new ArrayList<>();
        for(String key : layersHashMap.keySet()){
            ret.add(layersHashMap.get(key));
        }
        return ret;
    }

    /**
     * Adds a layerblock to the device
     * @param layerblock
     */
    public void addLayerBlock(LayerBlock layerblock) {
        layerBlocks.add(layerblock);
    }

    /**
     * Adds a constraint to the device
     * @param constraint
     */
    public void addConstraint(Constraint constraint) {
        //Add in LIFO order
        this.constraintList.add(0, constraint);
    }

    /**
     * Updates the XY spans for each of the components - this is important because some of the components can be
     * declared using IMPORT. Which means that the components XY span cannot be determined during parsing.
     * @param techLibrary
     */
    public void updateXYSpans(TechLibrary techLibrary){
        //TODO: Implement method that will go through all the components and update the x and y spans
        TechEntity currententity;
        for (Component componenttoupdate : getComponents()) {
            currententity = techLibrary.getMINTEntity(componenttoupdate.getTechnology());

            //Check if this is null, if it is then we need to rethink how this is working
            if(null == currententity){
                throw new UnsupportedOperationException("Need to handle the situation where there is no technology " +
                        "entity described for the component");
            }

            HashMap<String, String> paramstopass = new HashMap<>();
            for(String key : componenttoupdate.getParams().keySet()){
                String payload = componenttoupdate.getParams().get(key).toString();
                paramstopass.put(key, payload);
            }
            componenttoupdate.setXSpan(currententity.getXSpan(paramstopass));
            componenttoupdate.setYSpan(currententity.getYSpan(paramstopass));
        }
    }

    /**
     * Sets the features assocated with the device
     * @param features
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    /**
     * Returns the layer blocks
     * @return
     */
    public List<LayerBlock> getLayerBlocks() {
        return layerBlocks;
    }

    /**
     * Adds a feature to the device
     * //TODO: Update this to include draw layers and so forth
     * @param features
     */
    public void addFeatures(List<Feature> features) {
        throw new UnsupportedOperationException("Implement method to add features to the device's list of features");
    }

    /**
     * Returns the Valve associtated with a connection
     * TODO: Update definiton to list of valves
     * @param connection
     * @return
     */
    public Component getValveComponent(Connection connection) {
        if (valvemap.containsKey(connection)){
            return this.valvemap.get(connection);
        }else{
            return null;
        }
    }

    public List<DrawLayer> getDrawLayers() {
        return drawLayers;
    }

    public DirectedMultigraph getGlobalGraph() {
        return globalConnectionGraph;
    }
}
