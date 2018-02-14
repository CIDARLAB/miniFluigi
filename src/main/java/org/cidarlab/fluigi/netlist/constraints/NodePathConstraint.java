package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.layout.Point;
import org.cidarlab.fluigi.model.Component;
import org.cidarlab.fluigi.model.Connection;
import org.cidarlab.fluigi.model.Device;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class NodePathConstraint extends Constraint{

    public NodePathConstraint(List<Component> contextComponents){
        super(contextComponents);
        //TODO: Now we need to figure out how the thing breaks down in terms of
    }

    @Override
    public HashMap<Component, Point> getRelativePositions() {
        return null;
    }

    @Override
    public HashMap<Component, Float> getRelativeRotations() {
        return null;
    }

    public void findNodeNetworkComponents(Device device, ArrayList<String> nodelist, ArrayList<Component> contextcomponents) {
        //TODO: Implement algorithm that will find all the nearest neighbours

        //TODO: Generate the Netlist that has to be traversed by the algorithm
        SimpleDirectedGraph<Component, Connection> simplenetlist = new SimpleDirectedGraph<>(Connection.class);

        for(Component component : device.getComponents()){
            simplenetlist.addVertex(component);
        }

        for(String nodename : nodelist){
            Component node = device.getComponent(nodename);
            findNodeNeighbours(node , device.getGlobalGraph(), contextcomponents);
        }

    }

    private void findNodeNeighbours(Component node, DirectedMultigraph devicegraph, List<Component> nodeneighbours) {

        /*
        Find all the components connected to the node and add them if they are not already present
        in the nodeneighbours list
         */

        List<Component> neighbours = Graphs.neighborListOf(devicegraph, node);

        for(Component component : neighbours){
            if(!nodeneighbours.contains(component)){
                //Add to the nodeneighbour
                nodeneighbours.add(component);
            }
        }



    }
}
