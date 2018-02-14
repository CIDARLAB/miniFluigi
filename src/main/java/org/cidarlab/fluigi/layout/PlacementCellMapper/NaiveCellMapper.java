package org.cidarlab.fluigi.layout.PlacementCellMapper;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.model.Component;
import org.cidarlab.fluigi.model.Connection;
import org.cidarlab.fluigi.model.Device;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Create Placement object(Cells and Nets) from Device object and separates disconnected graphs
 *
 * Created by krishna on 7/17/17.
 */
public class NaiveCellMapper extends CellMapper {

    public NaiveCellMapper(Device device){
        super(device);
    }

    @Override
    public Placement generateLayout() {
        throw new UnsupportedOperationException("Need to implement the method to generate the device");
    }

    @Override
    public void importLayout(Placement placement) {
        //Loop through the placement's cells and just import the coordinates to the device's components
        for(Cell c : placement.getCells()){
            //Get the component in the device using the ID
            Component componenttoedit = device.getComponent(c.getID());
            if(null == componenttoedit){
                System.err.println("Could not find the component in the device");
            }
            componenttoedit.setX(c.getX());
            componenttoedit.setY(c.getY());
        }
    }

    @Override
    public List<Placement> generateLayouts() {
        /*
        Do the algorithm and figure out all the unconnected graphs in the device.
         */
        ArrayList<Placement> placementProlems = new ArrayList<>();
        SimpleDirectedGraph<Component, DefaultEdge> devicegraph = new SimpleDirectedGraph(DefaultEdge.class);
        ArrayList<Component> unvisitednodes = new ArrayList<>();
        ArrayList<Component> newgraphnodes = new ArrayList<>();
        Placement placementprolem;

        //Generate Graph from connections and components
        //Keep a list of visited vertices

        for(Component c : device.getComponents()){
            devicegraph.addVertex(c);
            unvisitednodes.add(c);
        }

        for(Connection c: device.getConnections()){
            String source = c.getSourceID();
            for(String target : c.getSinks()){
                //Create connection between each of the targets
                devicegraph.addEdge(device.getComponent(source),device.getComponent(target));
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
                placementprolem.addCell(c.getId(), c.getX(), c.getY(), c.getXSpan(),
                        c.getYSpan());
            }

            //Add all the corresponding connections into the placement problem
            for(Component c: connectedset){
                //Loop through all the nodes in this new graph
                for(DefaultEdge edge : devicegraph.edgesOf(c)){
                    placementprolem.addNet(devicegraph.getEdgeSource(edge).getId(),
                            devicegraph.getEdgeTarget(edge).getId());
                }
            }

            placementProlems.add(placementprolem);
        }

        return placementProlems;

    }

}
