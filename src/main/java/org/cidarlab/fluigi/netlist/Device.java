/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.netlist;

import java.util.*;

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
    private HashMap<Component, Connection> valvemap;
    private List<Component> imports;

    public Device(){
        layersHashMap = new HashMap<>();
        connections = new ArrayList<>();
        components = new ArrayList<>();
        dependencies = new ArrayList<>();
        valvemap = new HashMap<>();
        imports = new ArrayList<>();
    }

    public Device(String string) {
        this();
        this.name = string;
    }

    public void setComments(String string) {
        this.comments = string;
    }

    public void addLayer(LogicalLayer layer) {
        layersHashMap.put(layer.getId(), layer);
    }

    public void addComponent(Component component) {
        if(dependencies.contains(component.getTechnology())){
            imports.add(component);
        }
        components.add(component);
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
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
        this.valvemap.put(component, connection);
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
}
