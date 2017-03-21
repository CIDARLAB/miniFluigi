/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.place.simulatedannealing;

import org.cidarlab.fluigi.netlist.Component;
import org.cidarlab.fluigi.netlist.Port;
import org.cidarlab.fluigi.par.GridUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.cidarlab.fluigi.fluigi.DefaultDeviceParameters.lambda;
import static org.cidarlab.fluigi.par.place.DefaultPlaceParameters.*;

/**
 *
 * @author cassie
 */
public class LayoutGrid {

    private HashMap<Long, List<Component>> layoutGrid;
    protected Component c;
    protected int xOffset;
    protected int yOffset;
    protected int blockSize = 100;  //make into preference later (multiple of lambda, but everything is a multiple of lambda
    //default at 1mm/1000um

    public LayoutGrid() {
        layoutGrid = new HashMap<>();
    }

    public void clear(){
        layoutGrid.clear();
    }
    
    public void cleanup(){
        c = null;
        clear();
        layoutGrid = null;
    }
    
    public void newMove(Component movedC, int x, int y) {
        c = movedC;
        xOffset = x;
        yOffset = y;
        int cx = c.getX();
        int cy = c.getY();

        if (cx + xOffset + c.getWidth() > maxDeviceWidth / lambda) {
            xOffset = 0;//maxDeviceWidth/lambda - cx - c.getWidth();
        } else if (cx + xOffset < 0) {
            xOffset = 0;//-cx;
        }
        if (cy + c.getLength() + yOffset > maxDeviceLength / lambda) {
            yOffset = 0;//maxDeviceWidth/lambda - cy-c.getLength();
        } else if (cy + yOffset < 0) {
            yOffset = 0; //-cy;
        }

        c.move(xOffset, yOffset);
    }

    public void applyMove() {
        long t1 = System.nanoTime();
        //move has been accpeted.  update move in grid
        //1.  find old location.  remove c from old location in grid
        c.move(-xOffset, -yOffset);
        long t2 = t1;
        t1 = System.nanoTime();
        //System.out.println("time to unshift component " + Long.toString(t1-t2));
        removeComponent(c);
        //2.  move to new location.  write c to new location in grid
        t1 = System.nanoTime();
        c.move(xOffset, yOffset);
        t2 = t1;
        t1 = System.nanoTime();
        //System.out.println("time to shift component " + Long.toString(t1-t2));
        addComponent(c);
        t2 = t1;
        t1 = System.nanoTime();
        //System.out.println("time to move component " + Long.toString(t1-t2));
    }

    public void undoMove() {
        //undo component move.  do not update in grid
        c.move(-xOffset, -yOffset);
    }

    public void removeComponent(Component c) {//should never remove a component before adding it.
        long t1 = System.nanoTime();
        int minX = c.leftEdge() / blockSize;
        int maxX = c.rightEdge() / blockSize;
        int minY = c.topEdge() / blockSize;
        int maxY = c.bottomEdge() / blockSize;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                long key = GridUtil.hash(i, j);
                List<Component> l = layoutGrid.get(key);
                l.remove(c);
                if (l.isEmpty()) {
                    layoutGrid.remove(key);
                }
            }
        }
        long t2 = t1;
        t1 = System.nanoTime();
        //System.out.println("time to remove component " + Long.toString(t1-t2));
    }

    public void addComponent(Component c) {
        long t1 = System.nanoTime();
        int minX = c.leftEdge() / blockSize;
        int maxX = c.rightEdge() / blockSize;
        int minY = c.topEdge() / blockSize;
        int maxY = c.bottomEdge() / blockSize;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                long key = GridUtil.hash(i, j);
                List<Component> l = layoutGrid.get(key);
                if (l == null) {
                    //System.out.println("adding key " + key);
                    l = new LinkedList<>();
                    l.add(c);
                    layoutGrid.put(key, l);
                } else {
                    l.add(c);
                }
            }
        }
        long t2 = t1;
        t1 = System.nanoTime();
        //System.out.println("time to add component " + Long.toString(t1-t2));
    }

    public List<Component> get(long key) {
        return layoutGrid.get(key);
    }

    public long calcOverlap() {

        long overlapSum = 0;
        for (List<Component> l : layoutGrid.values()) {
            for (int i = 0; i < l.size(); i++) {
                Component c1 = l.get(i);
                for (int j = i + 1; j < l.size(); j++) {
                    Component c2 = l.get(j);
                    overlapSum += overlapArea(c1, c2);
                }
            }
        }
        return overlapSum;
    }

    public long calcCompOverlap(Component randC) {
        long overlapSum = 0;
        int minX = randC.leftEdge() / blockSize;
        int maxX = randC.rightEdge() / blockSize;
        int minY = randC.topEdge() / blockSize;
        int maxY = randC.bottomEdge() / blockSize;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                long key = GridUtil.hash(i, j);
                List<Component> l = layoutGrid.get(key);
                //System.out.println("getting key " + key);
                //System.out.println(l);
                if (l == null) {
                    continue;
                } else {
                    for (Component c : l) {
                        if (randC != c) {
                            overlapSum += overlapArea(randC, c);
                        }
                    }
                }
            }

        }
        return overlapSum;
    }

    public boolean overlaps(Component c1, Component c2) {
        if (c1 instanceof Port && c2 instanceof Port) {

            int dx = c1.getCenterX() - c2.getCenterX();
            int dy = c1.getCenterY() - c2.getCenterY();
            int dS = (int) Math.sqrt(dx * dx + dy * dy);
            if (dS > c1.getWidth() / 2 + c2.getWidth() / 2 + portSpacing) {
                return false;
            } else {
                return true;
            }
        } else if (c1.leftEdge() > c2.rightEdge()) {
            return false;
        } else if (c1.rightEdge() < c2.leftEdge()) {
            return false;
        } else if (c1.bottomEdge() < c2.topEdge()) {
            return false;
        } else if (c1.topEdge() > c2.bottomEdge()) {
            return false;
        } else {
            return true;
        }
    }

    public long overlapArea(Component c1, Component c2) {
        if (!overlaps(c1, c2)) {
            return 0;
        }
        long left = Math.max(c1.leftEdge(), c2.leftEdge());
        long right = Math.min(c1.rightEdge(), c2.rightEdge());
        long top = Math.max(c1.topEdge(), c2.topEdge());
        long bottom = Math.min(c1.bottomEdge(), c2.bottomEdge());
        /*if ((bottom - top) <= routingSpacing || (right - left) <= routingSpacing) {
         return 0;
         }*/
        return (bottom - top) * (right - left);
    }
    
    
}
