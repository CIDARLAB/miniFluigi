/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.route.hadlock;

import static org.cidarlab.fluigi.route.hadlock.DefaultParams.bendCost;
import static org.cidarlab.fluigi.route.hadlock.DefaultParams.blockingCost;
import static org.cidarlab.fluigi.route.hadlock.DefaultParams.startingCost;

/**
 *
 * @author cassie
 */
public class GridPoint implements Comparable {

    //direction in which previous thing was
    protected static final String NORTH = "north";
    protected static final String SOUTH = "south";
    protected static final String WEST = "west";
    protected static final String EAST = "east";

    static Grid myGrid;

    private int x;
    private int y;
    private int[] coords;
    private boolean enqueued = false;
    private boolean isSource = false;
    private boolean isTarget = false;
    private String prev = "";

    public int[] getCoords() {
        coords[0] = x;
        coords[1] = y;
        return coords;
    }

    boolean isEnqueued() {
        return enqueued;
    }

    void setEnqueued(boolean e) {
        enqueued = e;
    }

    /**
     * gVal - distance of expanded node from src
     */
    private int baseCost = startingCost;

    public void setBaseCost(int i) {
        baseCost = i;
    }

    private int pathCost = 0;

    /**
     * fVal - Hadlock "detour nummber" of this node
     */
    private int detourCost = 0;

    /**
     * used to break ties in priority queue - bias expansion of "recent" nodes
     */
    private int qVal = 0;

    public void setQVal(int qv) {
        qVal = qv;
    }

    /**
     * return to total cost value f = g + h
     */
    public int getDetourCost() {
        return detourCost;
    }

    /**
     * return path cost g
     */
    public int getBaseCost() {
        return baseCost;
    }

    public int getPathCost() {
        return pathCost;
    }

    /**
     * set f & g costs based on g cost input
     */
    public void setCosts(int detour, int path) {
        detourCost = detour;
        pathCost = path;
    }

    public GridPoint(int a, int b) {
        coords = new int[2];
        x = a;
        y = b;
        pathCost = -1;
    }

    /**
     * return the north neighbor of this point. returns null if this point is on
     * the northern edge of the grid
     */
    public GridPoint northNeighbor() {
        return myGrid.gridPointAt(x, y - 1);
    }

    /**
     * return the south neighbor of this point. returns null if this point is on
     * the southern edge of the grid
     */
    public GridPoint southNeighbor() {
        return myGrid.gridPointAt(x, y + 1);
    }

    /**
     * return the east neighbor of this point. returns null if this point is on
     * the eastern edge of the grid
     */
    public GridPoint eastNeighbor() {
        return myGrid.gridPointAt(x + 1, y);
    }

    /**
     * return the west neighbor of this point. returns null if this point is on
     * the western edge of the grid
     */
    public GridPoint westNeighbor() {
        return myGrid.gridPointAt(x - 1, y);
    }

    public String getPrev() {
        return prev;
    }
    /* expand a routing search */

    public int expand() {
        GridPoint xp;
        int curDetourCost;
        int curPathCost;
        int newDetourCost;
        int newPathCost;
        if ((xp = westNeighbor()) != null && !xp.isObstacle() && xp.getPathCost() != 0) {//
            curDetourCost = xp.detourCost;
            curPathCost = xp.pathCost;
            newDetourCost = detourCost + detourNumber(xp);
            newPathCost = pathCost + xp.baseCost;
            //bend penalty
            if (!prev.equals(EAST) && !prev.isEmpty()) {
                newPathCost = pathCost + xp.baseCost + bendCost;
            }
            if (xp.pathCost <= 0 || (curDetourCost + curPathCost) > (newDetourCost + newPathCost)) {
                xp.setCosts(newDetourCost, newPathCost);
                xp.prev = EAST;
                if (xp.isTarget()) {
                    return xp.pathCost;
                } else {
                    myGrid.enqueueGridPoint(xp);
                }
            }
        }
        if ((xp = eastNeighbor()) != null && !xp.isObstacle() && xp.getPathCost() != 0) {
            curDetourCost = xp.detourCost;
            curPathCost = xp.pathCost;
            newDetourCost = detourCost + detourNumber(xp);
            newPathCost = pathCost + xp.baseCost;
            if (!prev.equals(WEST) && !prev.isEmpty()) {
                newPathCost = pathCost + xp.baseCost + bendCost;
            }
            if (xp.pathCost <= 0 || (curDetourCost + curPathCost) > (newDetourCost + newPathCost)) {
                xp.setCosts(newDetourCost, newPathCost);
                xp.prev = WEST;
                if (xp.isTarget()) {

                    return xp.pathCost;
                } else {
                    myGrid.enqueueGridPoint(xp);
                }
            }

        }
        if ((xp = southNeighbor()) != null && !xp.isObstacle() && xp.getPathCost() != 0) {
            curDetourCost = xp.detourCost;
            curPathCost = xp.pathCost;
            newDetourCost = detourCost + detourNumber(xp);
            newPathCost = pathCost + xp.baseCost;
            if (!prev.equals(NORTH) && !prev.isEmpty()) {
                newPathCost = pathCost + xp.baseCost + bendCost;
            }
            if (xp.pathCost < 0 || (curDetourCost + curPathCost) > (newDetourCost + newPathCost)) {
                xp.setCosts(newDetourCost, newPathCost);
                xp.prev = NORTH;
                if (xp.isTarget()) {

                    return xp.pathCost;
                } else {
                    myGrid.enqueueGridPoint(xp);
                }
            }

        }
        if ((xp = northNeighbor()) != null && !xp.isObstacle() && xp.getPathCost() != 0) {
            curDetourCost = xp.detourCost;
            curPathCost = xp.pathCost;
            newDetourCost = detourCost + detourNumber(xp);
            newPathCost = pathCost + xp.baseCost;
            if (!prev.equals(SOUTH) && !prev.isEmpty()) {
                newPathCost = pathCost + xp.baseCost + bendCost;
            }
            if (xp.pathCost < 0 || (curDetourCost + curPathCost) > (newDetourCost + newPathCost)) {
                xp.setCosts(newDetourCost, newPathCost);
                xp.prev = SOUTH;
                if (xp.isTarget()) {

                    return xp.pathCost;
                } else {
                    myGrid.enqueueGridPoint(xp);
                }
            }

        }
        return -1;
    }

    public boolean isTarget() {
        return (this == myGrid.getTarget());
    }

    public boolean isSource() {//source is anything with baseCost==0
        return isSource;
    }

    public void setSource() {
        isSource = true;
    }

    public void clearSource() {
        isSource = false;
    }

    public boolean isEmpty() {
        return baseCost == startingCost;
    }

    @Override
    public String toString() {
        return "GridPoint(" + x + "," + y + ")[detour =" + detourCost + " path =" + pathCost + "] q=" + qVal;
    }

    public void reset() {
        detourCost = 0;
        pathCost = -1;
        prev = "";
        isTarget = false;
        isSource = false;
        //baseCost = startingCost;
    }

    public void initExpand() {
        pathCost = 0;
    }

    public void setRouted() {
        baseCost = blockingCost;
    }

    public boolean isRouted() {
        return (baseCost == blockingCost);
    }

    public void setObstacle() {
        baseCost = blockingCost;
    }

    public boolean isObstacle() {
        return (baseCost == blockingCost);
    }

    public boolean lessThan(GridPoint p2) {
        return pathCost < 0 && pathCost < p2.pathCost;
    }

    public int manhattanDistance(GridPoint p2) {
        
       
        return (Math.abs(p2.x - x) + Math.abs(p2.y - y));
    }

    public int detourNumber(GridPoint xp) {
        GridPoint tgt = myGrid.getTarget();
        int d1 = manhattanDistance(tgt);
        int d2 = xp.manhattanDistance(tgt);
        if (d2 > d1) {
            return d2 - d1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Object o) {
        GridPoint go = (GridPoint) o;
        if (this == go) {
            return 0;

        } else if (detourCost < go.detourCost) {
            return -1;
       
        } else if (detourCost > go.detourCost) {
            return 1;
        } else if (pathCost < go.pathCost) {
            return -1;
             } else if (pathCost > go.pathCost) {
            return 1;
        } else if (qVal < go.qVal) {
            return -1;
        } else if (qVal > go.qVal) {
            return 1;
        } else if (hashCode() > go.hashCode()) {
            return -1;
        } else {
            return 1;
        }
    }

}
