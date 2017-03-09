/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.layout;

import org.cidarlab.minifluigi.core.ErrorCodes;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedGraphUnion;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krishna
 */
public class Placement {

    SimpleDirectedGraph<Cell, DefaultEdge> placementGraph;

    //These are the global offsets for the positions for this entire placement
    private int xoffset = 0;
    private int yoffset = 0;

    public Placement(){
        placementGraph = new SimpleDirectedGraph<>(DefaultEdge.class);
    }

    public void addCell(String id, int x, int y, int w, int h) {
        Cell cell = new Cell(id, x, y, w, h);
        placementGraph.addVertex(cell);
    }

    public Cell getCell(String id){
        for(Cell c : placementGraph.vertexSet()){
            if(c.getID().equals(id)){
                return c;
            }
        }
        return null;
    }


    public void addConnection(String sourceID, String targetID){

        Cell sourceCell = null;
        Cell targetCell = null;

        for(Cell c : placementGraph.vertexSet()){

            //Find the source cell
            if(c.getID().equals(sourceID)){
                sourceCell = c;
            }

            //Find target
            if(c.getID().equals(targetID)) {
                targetCell = c;
            }

        }

        if((null == sourceCell)||(null==targetCell)){
            System.exit(ErrorCodes.PROBLEM_GENERATION_ERROR);
        }

        placementGraph.addEdge(sourceCell,targetCell);
    }

    public void addConnections(String sourceID, List<String> targets) {
        Cell sourceCell = null;
        ArrayList<Cell> targetCells = new ArrayList<>();
        //Find the source and targets ID
        for(Cell c : placementGraph.vertexSet()){

            //Find the source cell
            if(c.getID().equals(sourceID)){
                sourceCell = c;
            }

            //Find targets
            for(String target : targets){
                if(c.getID().equals(target)){
                    targetCells.add(c);
                }
            }

        }

        if((null == sourceCell)||(targetCells.isEmpty())){
            System.exit(ErrorCodes.PROBLEM_GENERATION_ERROR);
        }

        for(Cell target: targetCells){
            placementGraph.addEdge(sourceCell, target);
        }



    }

    public SimpleDirectedGraph<Cell, DefaultEdge> getDirectedGraph() {
        return placementGraph;
    }

    public SimpleGraph<Cell, DefaultEdge> getSimpleGraph(){
        throw new UnsupportedOperationException("Need to convert directed to undirected graph manually");
    }
}
