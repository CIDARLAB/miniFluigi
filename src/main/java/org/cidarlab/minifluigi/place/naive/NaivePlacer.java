package org.cidarlab.minifluigi.place.naive;

import org.cidarlab.minifluigi.layout.Cell;
import org.cidarlab.minifluigi.place.Placer;
import org.jgrapht.GraphPath;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import org.jgrapht.graph.*;

/**
 * Created by krishna on 3/7/17.
 */
public class NaivePlacer extends Placer {

    private int maxwidth;
    private int maxheight;

    public void loadContraints(int maxwidth, int maxheight) {
        this.maxheight = maxheight;
        this.maxwidth = maxwidth;
    }

    @Override
    public void place() {
        /*
        Overall Find the damn ports and fluid lines. Make levels for each of the fluid lines and start placing them
        based on the symmetries of the children.

        Because finding ports will not be easy when inside a module, we look for composites also.
        Each of the fluid lines can be found by getting the djikstra shortest paths.
        take the longest line and put it in the multiple levels.
        repeat in descending order of fluid line sizes.

        Might not be relevant
        Step 1. Find the damn ports
        Step 2. Find ports with the largest distance between them and then use those as the start and end points
        Step 2.5. Find a way to organize all these different start and end point distances.
        Step 3. Place the first port at origin circle.
        Step 3.5. Make levels list
        Step 4. Look at the children of this first node, if they are the same type of components then put them into a
        symmetric group.
        Step 5. Follow these simple rules to decide adjecency:
            - if child = 1 then child occupies south
            - if child = 2 then occupies south east, south west
            - if child = 3 and belongs to symmetric group then occupies southeast, southwest
            - if child = 4 and belongs to symmetric group then (cant handle it)
            - if child = 3 and 2 belong to symmetric group then similar take southeast, southwest and odd takes south
            -
        */

        //Assume annotation are only for terminal nodes (i.e. contain ports)


        //Now that we only have ports left we can shortest paths between all the ports

        //This is the data structure that stores teh distances between these cells.
        SimpleWeightedGraph<Cell, DefaultWeightedEdge> lengthgraph = new SimpleWeightedGraph<Cell, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        SimpleDirectedGraph<Cell, DefaultEdge> problemgraph = problem.getDirectedGraph();

        // Populate the lengthgraph vertices
        for (Cell c : problemgraph.vertexSet()) {
            if (null == c.getAnnotion("isterminalcomponent")) {
                continue;
            }
            if (c.getAnnotion("isterminalcomponent").equals(true)) {
                lengthgraph.addVertex(c);
            }
        }

        // Populate teh lengthgraph edges find distances between all the graph components
        UndirectedGraph<Cell, DefaultEdge> undirectedGraph = new AsUndirectedGraph<>(problemgraph);
        DijkstraShortestPath<Cell, DefaultEdge> shortestPath = new DijkstraShortestPath<>(undirectedGraph);
        DefaultWeightedEdge weightedEdge;
        // Find distances between each pair of vertices
        for (Cell c1 : lengthgraph.vertexSet()) {
            for (Cell c2 : lengthgraph.vertexSet()) {

                //Skip if c1 == c2
                if (c1.equals(c2)) {continue;}
                //Skip if there's and edge between c1, c2
                if (lengthgraph.containsEdge(c1, c2)) {continue;}

                //Compute shortest path between components
                GraphPath<Cell, DefaultEdge> path = shortestPath.getPath(c1,c2);
                weightedEdge = lengthgraph.addEdge(c1,c2);
                lengthgraph.setEdgeWeight(weightedEdge,path.getLength());
            }
        }


    }
}
