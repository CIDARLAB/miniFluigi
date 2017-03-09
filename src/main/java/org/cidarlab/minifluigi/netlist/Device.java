/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.netlist;

import java.util.*;

import org.cidarlab.minifluigi.layout.Placement;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

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

    public Placement getPlacementProblem() {
        /**
         * Loop through all the components in the device and generate rectangles
         * each of the rectangles have a position (x,y) and dimensions (w,h). 
         * Maybe thats all there is to this.
         * 
         * Also make abstract connections for each of the rectangles.
         */
        return getPlacement(components, connections);
    }

    private static Placement getPlacement(ArrayList<Component> components, ArrayList<Connection> connections) {
        Placement placement = new Placement();
        for(Component c : components){
            placement.addCell(
                    c.getId(),
                    c.getX(), c.getY(),
                    c.getW(), c.getH()
            );
        }

        for(Connection c : connections){
            placement.addConnections(
                    c.getSourceID(),
                    c.getTargets()
            );
        }

        return placement;
    }

    public List<Placement> getPlacementProblems(){
        /*
        TODO: Do the floodfill algorithm and figure out all the unconnected graphs in the device.
         */
        ArrayList<Placement> placementProlems = new ArrayList<>();
        SimpleDirectedGraph<Component, DefaultEdge> devicegraph = new SimpleDirectedGraph(DefaultEdge.class);
        ArrayList<Component> unvisitednodes = new ArrayList<>();
        ArrayList<Component> newgraphnodes = new ArrayList<>();
        Placement placementprolem;

        //Generate Graph from connections and components
        //Keep a list of visited vertices

        for(Component c : components){
            devicegraph.addVertex(c);
            unvisitednodes.add(c);
        }

        for(Connection c: connections){
            String source = c.getSourceID();
            for(String target : c.getTargets()){
                //Create connection between each of the targets
                devicegraph.addEdge(getComponent(source),getComponent(target));
            }
        }

        //Run the connectivity inspector and get all the sets of connected components
        ConnectivityInspector<Component, DefaultEdge> connectivityInspector = new ConnectivityInspector<Component, DefaultEdge>(devicegraph);
        List<Set<Component>> connectedsets = connectivityInspector.connectedSets();

        //Loop through the sets
        for(Set<Component> connectedset : connectedsets){
            //Create new placement problem
            placementprolem = new Placement();

            //Add all the components into the placement problem
            for(Component c : connectedset){
                placementprolem.addCell(c.getId(), c.getX(), c.getY(), c.getW(),
                        c.getH());
            }

            //Add all the corresponding connections into the placement problem
            for(Component c: connectedset){
                //Loop through all the nodes in this new graph
                for(DefaultEdge edge : devicegraph.edgesOf(c)){
                    placementprolem.addConnection(devicegraph.getEdgeSource(edge).getId(),
                            devicegraph.getEdgeTarget(edge).getId());
                }
            }

            placementProlems.add(placementprolem);
        }

        return placementProlems;
    }

    public void loadPlacement(Placement placementproblem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Component getComponent(String id){
        for(Component c : components){
            if(c.getId().equals(id)){
                return c;
            }
        }

        return null;
    }

    public List<Component> getComponents() {
        return components;
    }
}
