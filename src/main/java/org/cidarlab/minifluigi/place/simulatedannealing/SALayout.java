/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.place.simulatedannealing;

import org.cidarlab.fluigi.netlist.Channel;
import org.cidarlab.fluigi.netlist.Component;
import org.cidarlab.fluigi.netlist.TerminalPoint;
import org.cidarlab.minifluigi.layout.Cell;
import org.cidarlab.minifluigi.layout.Placement;

import java.util.HashMap;

import static org.cidarlab.fluigi.par.place.DefaultPlaceParameters.*;

/**
 *
 * @author cassie
 */
public class SALayout {

    protected HashMap<int[], Integer> hmOverlap;

    private long preMoveCompOverlap = 0;
    private long preMoveWirelength = 0;

    private long oldCost = 0;
    private long oldArea = 0;
    private long oldOverlap = 0;
    private long oldWirelength = 0;

    private long curCost = 0;
    private long curArea = 0;
    private long curOverlap = 0;
    private long curWirelength = 0;

    public SALayout() {
        super();
        hmOverlap = new HashMap<>();
    }

    public void reset() {
        oldCost = 0;
        oldArea = 0;
        oldOverlap = 0;
        oldWirelength = 0;

        curCost = 0;
        curArea = 0;
        curOverlap = 0;
        curWirelength = 0;

        curRightEdge = 0;
        curLeftEdge = 0;
        curBottomEdge = 0;
        curTopEdge = 0;
    }

    public long calcInitCost() {
        oldCost = curCost;
        oldOverlap = curOverlap;
        oldWirelength = curWirelength;
        curArea = calcArea();
        ///System.out.println("area: " + Double.toString(curArea));
        curOverlap = calcOverlap();
        //System.out.println("overlap: " + Double.toString(curOverlap));
        curWirelength = calcWirelength();
        //System.out.println("wirelength: " + Double.toString(curWirelength));
        curCost = curWirelength * wirePenalty + curArea * areaPenalty + curOverlap * overlapPenalty;
        //System.out.println("cost: " + Double.toString(curCost));
        return curCost;
    }

    public long calcCost(Cell randC) {
        oldCost = curCost;
        oldOverlap = curOverlap;
        oldWirelength = curWirelength;
        curArea = calcArea();
        ///System.out.println("area: " + Double.toString(curArea));
        curOverlap = oldOverlap - preMoveCompOverlap + calcCompOverlap(randC);
        //System.out.println("overlap: " + Double.toString(curOverlap));
        //curWirelength = calcWirelength();
        curWirelength = oldWirelength - preMoveWirelength + calcCompWirelength(randC);
        //System.out.println("wirelength: " + Double.toString(curWirelength));
        curCost = curWirelength * wirePenalty + curArea * areaPenalty + curOverlap * overlapPenalty;
        //System.out.println("cost: " + Double.toString(curCost));
        return curCost;
    }

    public long getDeltaCost() {
        return curCost - oldCost;
    }

    public double undoUpdateCost() {
        curArea = oldArea;
        curOverlap = oldOverlap;
        curWirelength = oldWirelength;
        curCost = oldCost;
        return curCost;
    }

    public long calcWirelength() {
        long wiresum = 0;
        for (Channel ch : layoutGraph.edgeSet()) {
            //half bounding box
            long w = Math.abs(ch.getSourcePoint().getPointCoords()[0] - ch.getTargetPoint().getPointCoords()[0]);
            long l = Math.abs(ch.getSourcePoint().getPointCoords()[1] - ch.getTargetPoint().getPointCoords()[1]);
            int penalty = calcPosition(ch); //this is not quite an overlap but will cause suboptimal routing
            wiresum += (l + w) + overlapPenalty / 2 * penalty;
        }
        return wiresum;
    }

    public void calcPrevCompWirelength(Cell c) {
        preMoveWirelength = calcCompWirelength(c);
    }

    public long calcCompWirelength(Cell c) {
        long wiresum = 0;
        for (Channel ch : layoutGraph.edgesOf(c)) {
            long w = Math.abs(ch.getSourcePoint().getPointCoords()[0] - ch.getTargetPoint().getPointCoords()[0]);
            long l = Math.abs(ch.getSourcePoint().getPointCoords()[1] - ch.getTargetPoint().getPointCoords()[1]);
            int penalty = calcPosition(ch); //this is not quite an overlap but will cause suboptimal routing
            wiresum += (l + w) + overlapPenalty / 2 * penalty;

        }
        return wiresum;
    }

    public void calcPrevCompOverlap(Cell randC) {
        preMoveCompOverlap = calcCompOverlap(randC);
    }

    public double currentCost() {
        return curCost;
    }

    public double currentArea() {
        return curArea;
    }

    public long currentOverlap() {
        return curOverlap;
    }

    public long currentWirelength() {
        return curWirelength;
    }

    public int calcPosition(Channel h1) {
        TerminalPoint source = h1.getSourcePoint();
        TerminalPoint target = h1.getTargetPoint();

        int sInd = h1.getSource().getTerminalIndex(source);
        int tInd = h1.getTarget().getTerminalIndex(target);

        int sx = source.getPointCoords()[0];
        int sy = source.getPointCoords()[1];
        int tx = target.getPointCoords()[0];
        int ty = target.getPointCoords()[1];

        int sPenalty = 0;
        int tPenalty = 0;

        switch (sInd) {
            case 0:
                if (sy < ty) {
                    sPenalty = 1;
                }
                break;
            case 1:
                if (sx > tx) {
                    sPenalty = 1;
                }
                break;
            case 2:
                if (sy > ty) {
                    sPenalty = 1;
                }
                break;
            case 3:
                if (sx < tx) {
                    sPenalty = 1;
                }
                break;
            default:
                sPenalty = 0;
                break;
        }

        switch (tInd) {
            case 0:
                if (ty < sy) {
                    tPenalty = 1;
                }
                break;
            case 1:
                if (tx > sx) {
                    tPenalty = 1;
                }
                break;
            case 2:
                if (ty > sy) {
                    tPenalty = 1;
                }
                break;
            case 3:
                if (tx < sx) {
                    tPenalty = 1;
                }
                break;
            default:
                tPenalty = 0;
                break;
        }
        return sPenalty + tPenalty;
    }

}
