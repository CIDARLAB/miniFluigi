package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.place.Placer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LocalLegalizer extends Placer {
    private class LineJag implements Comparable<LineJag> {
        private int mLength;
        public int mLineCoord;
        public double mJag;

        public LineJag(int lineCoord, double jag, int length) {
            mLineCoord = lineCoord;
            mJag = jag;
            mLength = length;
        }

        @Override
        public int compareTo(LineJag o) {
            if (Math.abs(mJag - o.mJag) < 1e-6) {
                return Double.compare(mJag, o.mJag);
            } else {
                return Integer.compare(Math.abs(mLineCoord - mLength), Math.abs(o.mLineCoord - o.mLength));
            }
        }
    }

    private static final int MAX_WIDTH = AnalyticalPlacerConstants.MAX_WIDTH;
    private static final int MAX_HEIGHT = AnalyticalPlacerConstants.MAX_HEIGHT;

    private Placement mPlacement;
    private int mMaxWidth;
    private int mMaxHeight;

    public LocalLegalizer(Placement placement, int maxWidth, int maxHeight) {
        mPlacement = placement;
        mMaxWidth = maxWidth;
        mMaxHeight = maxHeight;
    }

    @Override
    public void place() {
        List<Cell> allCells = new ArrayList<>(mPlacement.getCells());
        moduleAssign(allCells, 0, 0, MAX_WIDTH, MAX_HEIGHT);
    }

    private void moduleAssign(List<Cell> cells, int x0, int y0, int width, int height) {
        if (cells.size() <= 9) {
            // TODO: shape curve combining?
            return;
        }
        int axis = (width > height) ? 1 : 2;
        int limit = (width > height) ? width : height;
        PriorityQueue<LineJag> heap = new PriorityQueue<>();
        for (int line = limit / 5; line <= limit * 4 / 5; line += Math.max(1, limit / 100)) {
            heap.add(new LineJag(line, jag(line, axis), limit));
        }
        LineJag best = heap.peek();
        heap.clear();
        List<Cell> groupA = new ArrayList<>();
        List<Cell> groupB = new ArrayList<>();
        partition(cells, best.mLineCoord, axis, groupA, groupB);
        double ratio = calculateRatio(groupA, groupB);
        double groupALength = (axis == 1) ? width * ratio : height * ratio;
        int linePos = (int) ((axis == 1) ? x0 + groupALength : y0 + groupALength);
        boolean lineModified = false;
        for (Cell cell : groupA) {
            if (cell.getSpan(axis) > groupALength) {
                lineModified = true;
                groupALength = cell.getSpan(axis);
            }
        }
        if (lineModified) {
            groupA = new ArrayList<>();
            groupB = new ArrayList<>();
            linePos = (int) ((axis == 1) ? x0 + groupALength : y0 + groupALength);
            partition(cells, linePos, axis, groupA, groupB);
        }
        // TODO: compression?
        if (axis == 1) {
            moduleAssign(groupA, x0, y0, (int) groupALength, height);
            moduleAssign(groupB, linePos, y0, width - (int) groupALength, height);
        } else {
            moduleAssign(groupA, x0, y0, width, (int) groupALength);
            moduleAssign(groupB, x0, linePos, width, height - (int) groupALength);
        }
    }

    private double jag(int line, int axis) {
        double totalJag = 0.0;
        for (Cell cell : mPlacement.getCells()) {
            totalJag += jagForCell(cell, line, axis);
        }
        return totalJag;
    }

    private double jagForCell(Cell cell, int line, int axis) {
        int pos = cell.getCoord(axis);
        int span = cell.getSpan(axis);
        if (pos >= cell.getCoord(axis) && pos <= cell.getCoord(axis) + span) {
            if (pos <= line && line <= pos + span / 2) {
                return pos + span / 2 - line;
            } else if (pos - span / 2 <= line && line <= pos) {
                return line - pos + span / 2;
            } else {
                return 0.0;
            }
        } else {
            return 0.0;
        }
    }

    private void partition(List<Cell> cells, int line, int axis, List<Cell> groupA, List<Cell> groupB) {
        for (Cell cell : cells) {
            if (cell.getCenterCoord(axis) <= line) {
                groupA.add(cell);
            } else {
                groupB.add(cell);
            }
        }
    }

    private double calculateRatio(List<Cell> groupA, List<Cell> groupB) {
        double totalAreaA = 0.0;
        double totalAreaB = 0.0;
        double alpha = 1.09;
        for (Cell cell : groupA) {
            totalAreaA += alpha * cell.getXspan() * cell.getYspan();
        }
        for (Cell cell : groupB) {
            totalAreaB += alpha * cell.getXspan() * cell.getYspan();
        }
        return totalAreaA / (totalAreaA + totalAreaB);
    }
}
