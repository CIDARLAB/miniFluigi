/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.layout;

import org.cidarlab.fluigi.core.ErrorCodes;
import org.jgrapht.graph.SimpleDirectedGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author krishna
 */
public class Placement {

    SimpleDirectedGraph<Cell, Net> placementGraph;

    //These are the global offsets for the positions for this entire placement
    private int xoffset = 0;
    private int yoffset = 0;

    public Placement(){
        placementGraph = new SimpleDirectedGraph<>(Net.class);
    }

    public void addCell(String id, int x, int y, int w, int h) {
        Cell cell = new Cell(id, x, y, w, h);
        placementGraph.addVertex(cell);
    }

    public void addNet(String sourceID, String targetID){

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

    public void addNets(String sourceID, List<String> targets) {
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

    public ArrayList<Cell> getCells(){
        return new ArrayList<>(this.placementGraph.vertexSet());
    }

    public void updateCellCoordinates(String id, int x, int y){
        for(Cell cell : placementGraph.vertexSet()){
            if(cell.getID().equals(id)){
                cell.setX(x);
                cell.setY(y);
            }
        }
    }

    /**
     * Get all the nets in the current placement
     * @return
     */
    public Set<Net> getNets(){
        return placementGraph.edgeSet();
    }

    /**
     * Returns the source Cell of the Net
     * @param net
     * @return
     */
    public Cell getNetSource(Net net){
        return placementGraph.getEdgeSource(net);
    }

    /**
     * Returns the target Cell of the Net
     * @param net
     * @return
     */
    public Cell getNetTarget(Net net){
        return placementGraph.getEdgeTarget(net);
    }

    /**
     * Translates the positions of each of the cells in the device by the deltax and deltay values
     * @param deltax
     * @param deltay
     */
    public void translateCells(int deltax, int deltay) {
        for(Cell c : this.getCells()){
            c.setX(c.getX() + deltax);
            c.setY(c.getY() + deltay);
        }
    }

    public int getWidth() {
        int maxX = 0;
        for(Cell c  : getCells()){
            if(c.getMaxX() > maxX){
                maxX = c.getX();
            }
        }

        return maxX;
    }

    public int getHeight() {
        int maxY = 0;
        for(Cell c  : getCells()){
            if(c.getMaxY() > maxY){
                maxY = c.getX();
            }
        }

        return maxY;
    }


    /*
    TODO: Need to figure out a way to retrieve the connection offset for the pins
     */
}
