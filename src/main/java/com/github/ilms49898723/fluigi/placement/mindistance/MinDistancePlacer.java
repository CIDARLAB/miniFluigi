package com.github.ilms49898723.fluigi.placement.mindistance;

import com.github.ilms49898723.fluigi.placement.graphpartition.GraphPartitionPlacer;
import org.apache.commons.lang3.NotImplementedException;
import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.layout.Point;
import org.cidarlab.fluigi.place.Placer;

import java.util.*;

public class MinDistancePlacer extends Placer {
    private Map<String, Integer> mLocked;
    private Placement mPlacement;

    public MinDistancePlacer(Placement placement) {
        mLocked = new HashMap<>();
        mPlacement = placement;
        problem = placement;
    }

    @Override
    public void place() {
        new GraphPartitionPlacer(mPlacement).place();
        minDistance();
    }

    private void minDistance() {
        boolean flag = true;
        while (flag) {
            for (Cell cell : mPlacement.getCells()) {
                if (!fixComponentPosition(cell.getID())) {
                    flag = false;
                }
            }
        }
    }

    private boolean fixComponentPosition(String id) {
        Point newPosition = Point.zero();
        List<Cell> connectedCells = new ArrayList<>();
        List<Point> connectedTerminals = new ArrayList<>();

        Cell cell = mPlacement.getCell(id);
        for (Net net : mPlacement.netsOfCell(cell)) {
            Cell source = mPlacement.getNetSource(net);
            Cell target = mPlacement.getNetTarget(net);
            if (source.getID().equals(id)) {
                connectedCells.add(target);
                connectedTerminals.add(new Point((int) target.getCenterX(), (int) target.getCenterY()));
            } else {
                connectedCells.add(source);
                connectedTerminals.add(new Point((int) target.getCenterX(), (int) target.getCenterY()));
            }
        }

        //Find new position which distance is minimum
        newPosition = getMinimumDistancePoint(cell, connectedTerminals);
        mLocked.put(id, 1);
        if (getOverlapComponents(cell, newPosition).isEmpty()) {
            cell.setX(newPosition.getX());
            cell.setY(newPosition.getY());
            return true;
        }
        return false;
//        fixOverlap(id, newPosition);
    }

    private Point getMinimumDistancePoint(Cell cell, List<Point> connectedTerminals) {
        return calculateMinimumDistancePoint(cell, connectedTerminals);
//        double minCost = calculateAllCost(id, connectedTerminals, result);

//        tryToRotate(id, connectedTerminals, result, minCost);
//        result = tryToSwap(id, connectedTerminals, result, minCost, false);
    }

    private Point calculateMinimumDistancePoint(Cell cell, List<Point> connectedTerminals) {
        double x = 0, y = 0;
        for (Point position : connectedTerminals) {
            x += position.getX();
            y += position.getY();
        }
        x += cell.getCenterX();
        y += cell.getCenterY();

        x /= connectedTerminals.size();
        y /= connectedTerminals.size();

        return new Point((int) x, (int) y);
    }

    private double calculateAllCost(Cell cell, List<Point> connectedPorts) {
        double cost = 0;
        Point cellPosition = new Point((int) cell.getCenterX(), (int) cell.getCenterY());
        for (Point position : connectedPorts) {
            cost += cellPosition.manhattanDistance(position);
        }
        return cost;
    }

    private List<String> getOverlapComponents(Cell cell, Point newPt) {
        List<String> result = new ArrayList<>();
        String id = cell.getID();
        int w1 = cell.getXspan();
        int h1 = cell.getYspan();

        for (Cell another : mPlacement.getCells()) {
            String targetId = another.getID();

            if (id.equals(targetId)) continue;

            int w2 = another.getXspan();
            int h2 = another.getYspan();
            double distanceX = Math.abs(cell.getCenterX() - newPt.getX());
            double distanceY = Math.abs(cell.getCenterY() - newPt.getY());

            if (distanceX <= ((w1 + w2) / 2) && distanceY <= ((h1 + h2) / 2)) {
                result.add(targetId);
            }
        }
        return result;
    }

    private boolean fixOverlap(String id, Point newPosition) {
        throw new NotImplementedException("fixOverlap");
//        List<String> overlapComponents = getOverlapComponents(id, newPosition);
//        if (overlapComponents.isEmpty()) {
//            mSymbolTable.get(id).setPosition(newPosition);
//            //System.out.println("NO OVERLAP!!!!");
//        } else {
//            boolean isValid = true;
//            for (int i = 0; i < overlapComponents.size(); i++) {
//                if (mLocked.containsKey(overlapComponents.get(i))) {
//                    isValid = false;
//                    break;
//                }
//            }
//
//            if (isValid) {
//                mSymbolTable.get(id).setPosition(newPosition);
//                for (int i = 0; i < overlapComponents.size(); i++) {
//                    fixComponentPosition(overlapComponents.get(i));
//                }
//            } else {
//                Point2D p = OverlapFixer.findNewPosition(mSymbolTable.get(id), mSymbolTable, this.mParameters);
//                if (p == null) {
//                    return false;
//                }
//                mSymbolTable.get(id).setPosition(p);
//            }
//        }
//        return true;
    }
}
