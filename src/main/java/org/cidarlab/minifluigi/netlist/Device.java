/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.netlist;

import java.util.ArrayList;
import java.util.HashMap;
import org.cidarlab.minifluigi.layout.Placement;

/**
 *
 * @author krishna
 */
public class Device {
     
    private final String name;
    private String comments;
    private HashMap<String,LogicalLayer> layersHashMap;
    private ArrayList<Component> components;
    private ArrayList<Connection> connections;
    
    public Device(String string) {
        this.name = string;
        layersHashMap = new HashMap<>();
        connections = new ArrayList<>();
        components = new ArrayList<>();
    }

    public void setComments(String string) {
        this.comments = string;
    }

    public void addLayer(LogicalLayer layer) {
        layersHashMap.put(layer.getId(), layer);
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public Placement getPlacement() {
        /**
         * Loop through all the components in the device and generate rectangles
         * each of the rectangles have a position (x,y) and dimensions (w,h). 
         * Maybe thats all there is to this.
         * 
         * Also make abstract connections for each of the rectangles.
         */
        Placement placement = new Placement();
        for(Component c : components){
            placement.addCell(
                    c.getId(),
                    c.getX(), c.getY(),
                    c.getW(), c.getH()
            );
        }
        
        for(Connection c : connections){
            placement.addConnection(
                    c.getSourceID(),
                    c.getTargets()
            );
        }
        
        return placement;
    }

    public void loadPlacement(Placement placementproblem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
