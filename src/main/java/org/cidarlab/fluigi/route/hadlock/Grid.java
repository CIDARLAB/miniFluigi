/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.route.hadlock;


import java.util.*;

import static org.cidarlab.fluigi.route.hadlock.DefaultParams.occupiedCost;
import static org.cidarlab.fluigi.route.hadlock.DefaultParams.spacingCost;
import static org.cidarlab.fluigi.route.hadlock.DefaultParams.startingCost;

/**
 *
 * @author cassie
 */
public class Grid {

    HashMap<Long, GridPoint> grid;
    int width;
    int height;
//GridPoint[][] gridArray;
    GridPoint src;
    GridPoint tgt;
    ArrayList<int[]> gridPath;
    List<int[]> srcPath;

    public Grid(int w, int h) {
        grid = new HashMap(); //BST<>();
        width = w;
        height = h;
        GridPoint.myGrid = this;
        srcPath = new LinkedList<>();

    }

    public int width() {
        return width;
    }

    public int length() {
        return height;
    }

    public GridPoint gridPointAt(int x, int y) {
        if (x < 0 || x >= width()) {
            return null;
        }
        if (y < 0 || y >= length()) {
            return null;
        }
        long key = GridUtil.hash(x, y);
        GridPoint gp = grid.get(key);
        if (gp != null) {
            return gp;
        } else {
            gp = new GridPoint(x, y);
            //gp.setBaseCost(1);
            grid.put(key, gp);
            return gp;
        }
    }

    public void clear() {//does not clear existing obstacles but clears routes
        for (int i = 0; i < width(); i++) {
            for (int j = 0; j < length(); j++) {
                long key = GridUtil.hash(i, j);
                GridPoint gp = grid.get(key);
                if (gp != null) {
                    if (gp.getPathCost() > 0) {
                        gp.reset();
                    }
                }
            }
        }
    }

    public void reset() {//clears *EVERYTHING*, as in, 'you need to make a new grid now'
        for (int i = 0; i < width(); i++) {
            for (int j = 0; j < length(); j++) {
                long key = GridUtil.hash(i, j);
                GridPoint gp = grid.get(key);
                gp = null;
            }
        }
        grid = null;
    }

    private TreeSet gpq = new TreeSet();

    private int queueCount = 0;  // track number of insertions to queue - use to break ties on nodes

    void resetGridPointQueue() {
        gpq.clear();
        queueCount = 0;
    }

    void printGridPointQueue() { // for debugging - package visible
        Iterator it = gpq.iterator();
        System.out.println("Queue contents [" + gpq.size() + "]: ");
        while (it.hasNext()) {
            GridPoint g = (GridPoint) it.next();
            System.out.print(g + " ");
        }
        System.out.print("\n");
    }

    public void enqueueGridPoint(GridPoint gp) {
        gp.setQVal(++queueCount);
        gpq.add(gp);
        gp.setEnqueued(true);
    }

    public GridPoint dequeueGridPoint() {//changed to remove lowest element during dequeue
        if (gpq.isEmpty()) {
            return null;
        } else {
            //printGridPointQueue();
            GridPoint gp = (GridPoint) gpq.pollFirst();
            //System.out.println(gp);
            gp.setEnqueued(false);
            return gp;
        }
    }

    public void clearQueue() {
        gpq.clear();
    }

    public int expansion() {
        GridPoint gp;
        int pathLength;
        resetGridPointQueue();
        if (src != null && tgt != null) {
            src.initExpand();
            if ((pathLength = src.expand()) > 0) {
                clearQueue();
                return pathLength; // found it right away!
            }
            while ((gp = dequeueGridPoint()) != null) {
                if ((pathLength = gp.expand()) > 0) {
                    clearQueue();
                    return pathLength;  // found it!
                }
            }
        }
        return -1;
    }

    public int netExpansion() {//takes effect after the first path
        GridPoint gp;
        int pathLength;
        resetGridPointQueue();
        for (int[] p : srcPath) {
            gp = gridPointAt(p[0], p[1]);
            if (gp.getBaseCost() == startingCost) {
                gp.setBaseCost(0);
                gp.initExpand();
                enqueueGridPoint(gp);
            }
        }
        printGridPointQueue();
        while ((gp = dequeueGridPoint()) != null) {
            if ((pathLength = gp.expand()) > 0) {
                clearQueue();
                return pathLength;  // found it!
            }
        }
        return -1;
    }

    public void traceBack() {
        // start at target, then work back
        GridPoint current = tgt;
        gridPath = new ArrayList<>();
        while (!current.isSource()) {
            gridPath.add(0, current.getCoords());
            switch (current.getPrev()) {
                case GridPoint.NORTH:
                    current = current.northNeighbor();
                    continue;
                case GridPoint.SOUTH:
                    current = current.southNeighbor();
                    continue;
                case GridPoint.EAST:
                    current = current.eastNeighbor();
                    continue;
                case GridPoint.WEST:
                    current = current.westNeighbor();
                    continue;
                default:
                    break;
            }
            System.out.println("AWK! can't trace back! current= " + current);
            break;
        }
        if (!current.isSource()) {
            System.out.println("Warning: traceBack failed!");
        } else {
            gridPath.add(0, current.getCoords());
        }
    }

    public void setSource(int x, int y) {
        setSource(gridPointAt(x, y));
    }

    public void setSource(GridPoint s) {
        s.setBaseCost(0);
        s.setCosts(0, -1);
        s.setQVal(0);
        s.setSource();
        src = s;
    }

    public void setTarget(int x, int y) {

        tgt = gridPointAt(x, y);
    }

    public void setTarget(GridPoint t) {
        t.setBaseCost(0);
        t.setCosts(0, -1);
        t.setQVal(0);
        tgt = t;
    }

    public GridPoint getSource() {
        return src;
    }

    public GridPoint getTarget() {
        return tgt;
    }

    public int route(boolean isNet) {
        if (src == null || tgt == null) {
            return -1;
        }
        clear();
        if (src == tgt) {  // trivial case
            gridPath = new ArrayList<>();
            gridPath.add(src.getCoords());
            src.setRouted();
            return 0;
        } else {
            int pathLength;
            if (isNet) {
                System.out.println("Beginning Net Expansion");
                //drawGrid();
                pathLength = netExpansion();
                System.out.println(Integer.toString(pathLength));
            } else {
                pathLength = expansion();
            }
            clearQueue();
            if (pathLength > 0) {
                traceBack();
                streamlinePath();
                if (isNet) {
                    printGridPath();
                }
            } else {
                printGridPointQueue();
                return -1;
            }
            return pathLength;
        }
    }

    public void setPath(List<int[]> path, int width, int cost) {
        //for pair of points in path:
        //1) verticle or horizonal channel
        //2) set width of channel in grid to be obstacle or what else
        for (int i = 0; i < path.size() - 1; i++) {
            int[] s = path.get(i);
            int[] t = path.get(i + 1);
            int w1, w2;
            if (width % 2 == 0) {//make sure that channels aren't fucked for having an odd width
                w1 = width / 2;
                w2 = width / 2;
            } else {
                w1 = (int) Math.floor(width / 2);
                w2 = (int) Math.ceil(width / 2);
            }
            if (s[0] == t[0]) {//vertical channel
                for (int x = s[0] - w1; x <= s[0] + w2; x++) {//warning:  might have an off by 1
                    for (int y = Math.min(s[1], t[1]); y <= Math.max(s[1], t[1]); y++) {
                        GridPoint gp = gridPointAt(x, y);
                        if (gp != null){
                        gp.setBaseCost(cost);
                        gp.setCosts(0, -1);
                        }
                    }
                }
            }
            if (s[1] == t[1]) {//horizontal channel
                for (int y = s[1] - w1; y <= s[1] + w2; y++) {//warning:  might have an off by 1
                    for (int x = Math.min(s[0], t[0]); x <= Math.max(s[0], t[0]); x++) {
                        GridPoint gp = gridPointAt(x, y);
                        if (gp != null){
                        gp.setBaseCost(cost);
                        gp.setCosts(0, -1);
                        }
                    }
                }
            }
        }
    }

    public void setChannelSpacing(List<int[]> path, int width, int spacing, boolean nodeClear) {
        //for pair of points in path
        //find borders given width,
        //set spacing

        for (int i = 0; i < path.size() - 1; i++) {
            int[] s = path.get(i);
            int[] t = path.get(i + 1);
            int w1, w2;
            if (width % 2 == 0) {//make sure that channels aren't fucked for having an odd width
                w1 = width / 2;
                w2 = width / 2;
            } else {
                w1 = (int) Math.floor((double) width / 2.0);
                w2 = (int) Math.ceil((double) width / 2.0);
            }
            if (s[0] == t[0]) {//vertical channel
                for (int x = s[0] - w1 - spacing; x < s[0] - w1; x++) {//warning:  might have an off by 1
                    for (int y = Math.min(s[1], t[1]) - w1 - spacing; y < Math.max(s[1], t[1]) + w1 + spacing; y++) {
                        GridPoint gp = gridPointAt(x, y);
                        if (gp != null && (!gp.isObstacle() && !(gp.getBaseCost() == occupiedCost)) || nodeClear) {
                            gp.setBaseCost(spacingCost);
                        }
                    }
                }
                for (int x = s[0] + w2; x < s[0] + w2 + spacing; x++) {//warning:  might have an off by 1
                    for (int y = Math.min(s[1], t[1]) - w2 - spacing; y < Math.max(s[1], t[1]) + w2 + spacing; y++) {
                        GridPoint gp = gridPointAt(x, y);
                        if (gp != null && (!gp.isObstacle() && !(gp.getBaseCost() == occupiedCost)) || nodeClear) {
                            gp.setBaseCost(spacingCost);
                        }
                    }
                }
            }
            if (s[1] == t[1]) {//horizontal channel
                for (int y = s[1] - w1 - spacing; y < s[1] - w1; y++) {//warning:  might have an off by 1
                    for (int x = Math.min(s[0], t[0]); x <= Math.max(s[0], t[0]); x++) {
                        GridPoint gp = gridPointAt(x, y);
                        if (gp != null && !gp.isObstacle()) {
                            gp.setBaseCost(spacingCost);
                        }
                    }
                }
                for (int y = s[1] + w2; y < s[1] + w2 + spacing; y++) {//warning:  might have an off by 1
                    for (int x = Math.min(s[0], t[0]); x <= Math.max(s[0], t[0]); x++) {
                        GridPoint gp = gridPointAt(x, y);
                        if (gp != null && !gp.isObstacle()) {
                            gp.setBaseCost(spacingCost);
                        }
                    }
                }
            }
        }
    }

    public void streamlinePath() {
        //keep only the points that are at a bend
        int[] cur;
        int[] next;
        int[] prev;
        //printGridPath();
        ArrayList<int[]> newPath = new ArrayList<>();
        for (int i = 0; i < gridPath.size() - 1; i++) {
            cur = gridPath.get(i);
            next = gridPath.get(i + 1);
            if (i == 0) {
                newPath.add(cur);
            } else {
                prev = gridPath.get(i - 1);
                if (cur[0] == prev[0] && cur[0] != next[0]) {
                    newPath.add(cur);
                }
                if (cur[1] == prev[1] && cur[1] != next[1]) {
                    newPath.add(cur);
                }
                if (checkNeighbors(cur)) {
                    newPath.add(cur);
                }
            }
            if (i == gridPath.size() - 2) {
                newPath.add(next);
            }
        }
        gridPath = newPath;
    }

    public boolean checkNeighbors(int[] coords) {
        int i = 0;
        GridPoint gp = gridPointAt(coords[0], coords[1]);
        if (gp.northNeighbor() != null && gp.northNeighbor().getBaseCost() == 0) {
            i++;
        }
        if (gp.eastNeighbor() != null && gp.eastNeighbor().getBaseCost() == 0) {
            i++;
        }
        if (gp.southNeighbor() != null && gp.southNeighbor().getBaseCost() == 0) {
            i++;
        }
        if (gp.westNeighbor() != null && gp.westNeighbor().getBaseCost() == 0) {
            i++;
        }
        return (i > 2);
    }

    public void printGridPath() {
        System.out.println("Path start:");
        for (int[] gp : gridPath) {
            System.out.println("x: " + gp[0] + " y: " + gp[1]);
        }
        System.out.println("Path end");
    }

    public void printPath(List<int[]> path) {
        System.out.println("Path start:");
        for (int[] gp : path) {
            System.out.println("x: " + gp[0] + " y: " + gp[1]);
        }
        System.out.println("Path end");
    }

    public void drawGrid() {
        for (int j = 0; j < length(); j++) {
            for (int i = 0; i < width(); i++) {
                GridPoint gp = gridPointAt(i, j);
                if (gp.isSource()) {
                    System.out.print("S");
                } else if (gp == tgt) {
                    System.out.print("T");
                } else if (gp.isObstacle()) {
                    System.out.print("X");
                } else if (gp.getPathCost() > 0) {
                    System.out.print("F");
                } else if (gp.getBaseCost() == spacingCost) {
                    System.out.print("_");
                } else if (gp.getBaseCost() == occupiedCost) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n\r");
        }
    }

    public void setNode(GridPoint gp, int width, int baseCost) {
        int[] coords = gp.getCoords();
        int w1, w2;
        if (width % 2 == 0) {//make sure that channels aren't fucked for having an odd width
            w1 = width / 2;
            w2 = width / 2;
        } else {
            w1 = (int) Math.floor(width / 2);
            w2 = (int) Math.ceil(width / 2);
        }
        for (int x = coords[0] - w1; x <= coords[0] + w2; x++) {//warning:  might have an off by 1
            for (int y = coords[1] - w1; y <= coords[1] + w2; y++) {
                GridPoint p = gridPointAt(x, y);
                p.setBaseCost(baseCost);
                p.setCosts(0, -1);
            }
        }

    }

    void clearGrid() {
        grid.clear();
    }
}
