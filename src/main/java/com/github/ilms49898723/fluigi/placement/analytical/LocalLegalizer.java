package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.place.Placer;

import java.util.*;


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
    private static final double INITIAL_ALPHA = AnalyticalPlacerConstants.INITIAL_ALPHA;
    private static final double FINAL_ALPHA = AnalyticalPlacerConstants.FINAL_ALPHA;

    private int mMaxWidth;
    private int mMaxHeight;

    public LocalLegalizer(Placement placement, int maxWidth, int maxHeight) {
        super.problem = placement;
        mMaxWidth = maxWidth;
        mMaxHeight = maxHeight;
    }

    @Override
    public void place() {
        if(null == super.problem){
            System.exit(9999);
        }
        List<Cell> allCells = new ArrayList<>(super.problem.getCells());
        moduleAssign(allCells, 0, 0, MAX_WIDTH, MAX_HEIGHT);
    }

    private void moduleAssign(List<Cell> cells, int x0, int y0, int width, int height) {
        if (cells.size() <= 9) {
            shapeCurveCombining(cells, x0, y0, width, height);
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
        if (axis == 1) {
            moduleAssign(groupA, x0, y0, (int) groupALength, height);
            moduleAssign(groupB, linePos, y0, width - (int) groupALength, height);
        } else {
            moduleAssign(groupA, x0, y0, width, (int) groupALength);
            moduleAssign(groupB, x0, linePos, width, height - (int) groupALength);
        }
        shapeCurveCombining(cells, x0, y0, width, height);
    }

    private double jag(int line, int axis) {
        double totalJag = 0.0;
        for (Cell cell : super.problem.getCells()) {
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

    private void shapeCurveCombining(List<Cell> cells, int x0, int y0, int width, int height) {
        int cellId = 0;
        double[][] direct = new double[cells.size()][2];
        Map<String, Integer> cellId2Idx = new HashMap<>();
        for (Cell cell : cells) {
            cellId2Idx.put(cell.getID(), cellId++);
        }
        int iter = 0;
        for (double alpha = INITIAL_ALPHA; alpha >= FINAL_ALPHA; alpha *= 0.5) {
            double radius = 4;
            double[][] prevDirect = direct;
            direct = new double[cells.size()][2];
            // Only consider density
            System.out.println("Alpha Value : " + alpha);
            Density ds = new Density(problem, MAX_WIDTH, MAX_HEIGHT, radius, alpha);
            double cost = ds.penalty();
            for (Cell cell : cells) {
                for (int axis = 1; axis <= 2; ++axis) {
                    cellId = cellId2Idx.get(cell.getID());
                    direct[cellId][axis - 1] = ds.step(cell, axis);
                }
            }
            if (iter > 0) {
                double[][] beta = calculateBeta(direct, prevDirect);
                for (Cell cell : cells) {
                    cellId = cellId2Idx.get(cell.getID());
                    double[] delta = new double[2];
                    for (int axis = 1; axis <= 2; ++axis) {
                        double p = direct[cellId][axis - 1] + beta[cellId][axis - 1] * prevDirect[cellId][axis - 1];
                        double stepLength = backtrackingLineSearch(-direct[cellId][axis - 1], p, cost, alpha, radius, cell, axis);
                        delta[axis - 1] = stepLength * p;
                    }
                    cell.addX(delta[0], x0, x0 + width);
                    cell.addY(delta[1], y0, y0 + height);
                }
            }
            ++iter;
        }
    }

    private double backtrackingLineSearch(double g, double p, double f, double alpha, double radius, Cell cell, int axis) {
        double m = p * g;
        double stepSize = 20;
        double searchControl = 0.5;
        double c = 0.5;
        double t = (-1) * c * m;
        if (m >= 0) {
            return 0.0;
        }
        int originalCoord = cell.getCoord(axis);
        while (stepSize > 1.0) {
            double delta = stepSize * p;
            cell.setCoord(originalCoord, axis);
            cell.addCoord(delta, axis, (axis == 1) ? MAX_WIDTH : MAX_HEIGHT);
            WireLength wl = new WireLength(problem, alpha);
            Boundary bd = new Boundary(problem, 0, 0, MAX_WIDTH, MAX_HEIGHT, alpha);
            Density ds = new Density(problem, MAX_WIDTH, MAX_HEIGHT, radius, alpha);
            double newf = wl.penalty() + bd.penalty() + ds.penalty();
            if (f - newf >= stepSize * t) {
                break;
            }
            stepSize = searchControl * stepSize;
        }
        cell.setCoord(originalCoord, axis);
        return stepSize;
    }

    private double[][] calculateBeta(double[][] direct, double[][] prevDirect) {
        double[][] beta = new double[direct.length][direct[0].length];
        for (int i = 0; i < direct.length; ++i) {
            for (int j = 0; j < direct[i].length; ++j) {
                if (Math.abs(prevDirect[i][j]) > 1e-6) {
                    beta[i][j] = direct[i][j] / prevDirect[i][j] *
                            (direct[i][j] - prevDirect[i][j]) / prevDirect[i][j];
                } else {
                    beta[i][j] = 0.0;
                }
            }
        }
        return beta;
    }
}
