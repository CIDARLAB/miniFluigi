package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Density {
    private class Point2D {
        public int x;
        public int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point2D point2D = (Point2D) o;

            if (x != point2D.x) return false;
            return y == point2D.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private class Values {
        public int a;
        public int b;
        public int x;
        public int y;

        public Values(int a, int b, int x, int y) {
            this.a = a;
            this.b = b;
            this.x = x;
            this.y = y;
        }
    }

    private Placement mProblem;
    private Map<String, Values> mCellPointMap;
    private Map<Point2D, Double> mGridMap;
    private double mRadius;
    private double mGridLength;
    private double mExpectedPotential;
    private int mWidth;
    private int mHeight;
    private int mGridWidth;
    private int mGridHeight;

    public Density(Placement problem, int width, int height, double radius, double alpha) {
        mProblem = problem;
        mRadius = radius;
        mGridLength = alpha / mRadius;
        mWidth = width;
        mHeight = height;
        initialize();
    }

    public void initialize() {
        mCellPointMap = new HashMap<>();
        mGridWidth = (int) Math.floor(mWidth / mGridLength + 1);
        mGridHeight = (int) Math.floor(mHeight / mGridLength + 1);
        mGridMap = new HashMap<>();
        calculatePenalty();
    }

    public double penalty() {
        double totalPenalty = 0.0;
        for (double v : mGridMap.values()) {
            totalPenalty += (v - mExpectedPotential) * (v - mExpectedPotential);
        }
        return totalPenalty;
    }

    public double gradient(String respect, int axis) {
        return gradient(mProblem.getCell(respect), axis);
    }

    public double gradient(Cell respect, int axis) {
        double result = 0.0;
        Values points = mCellPointMap.get(respect.getID());
        double cx = respect.getCenterX() / mGridLength;
        double cy = respect.getCenterY() / mGridLength;
        int lx = points.a;
        int ly = points.b;
        int rx = points.x;
        int ry = points.y;
        for (int x = lx; x <= rx; ++x) {
            for (int y = ly; y <= ry; ++y) {
                if (isValidCoordinate(x, y)) {
                    double C = gridMap(x, y) - potential(x, cx, y, cy, mRadius);
                    double K = (axis == 1) ? potential(y, cy, mRadius) : potential(x, cx, mRadius);
                    double A = mExpectedPotential;
                    double g = (axis == 1) ? gradient(x, cx, C, K, A) : gradient(y, cy, C, K, A);
                    result += g;
                }
            }
        }
        return result;
    }

    public double step(String respect, int axis) {
        return gradient(respect, axis);
    }

    public double step(Cell respect, int axis) {
        return gradient(respect, axis);
    }

    private double gridMap(int x, int y) {
        return mGridMap.getOrDefault(new Point2D(x, y), 0.0);
    }

    private void addGridMap(int x, int y, double v) {
        Point2D key = new Point2D(x, y);
        if (!mGridMap.containsKey(key)) {
            mGridMap.put(key, v);
        } else {
            double newValue = mGridMap.get(key);
            mGridMap.put(key, newValue + v);
        }
    }

    private void calculatePenalty() {
        List<Cell> cells = mProblem.getCells();
        for (Cell cell : cells) {
            double cx = cell.getCenterX() / mGridLength;
            double cy = cell.getCenterY() / mGridLength;
            int lx = (int) (Math.floor(cx) - mRadius - 2);
            int ly = (int) (Math.floor(cy) - mRadius - 2);
            int rx = (int) (Math.ceil(cx) + mRadius + 2);
            int ry = (int) (Math.ceil(cy) + mRadius + 2);
            mCellPointMap.put(cell.getID(), new Values(lx, ly, rx, ry));
            for (int x = lx; x <= rx; ++x) {
                for (int y = ly; y <= ry; ++y) {
                    if (isValidCoordinate(x, y)) {
                        addGridMap(x, y, potential(x, cx, y, cy, mRadius));
                    }
                }
            }
        }
        mExpectedPotential = 0.0;
//        double totalArea = 0.0;
//        for (Cell cell : cells) {
//            totalArea += cell.getXspan() * cell.getYspan();
//        }
//        mExpectedPotential = totalArea / (mGridWidth * mGridHeight);
    }

    private double gradient(double v, double v0, double C, double K, double A) {
        double coeff = (v - v0 < 0) ? (-1.0) : 1.0;
        v = Math.abs(v - v0);
        if (v >= mRadius) {
            return 0.0;
        } else if (0 <= v && v <= mRadius / 2) {
            double kSquare = K * K;
            double rSquare = mRadius * mRadius;
            double rQuad = rSquare * rSquare;
            return (16 * kSquare / rQuad * v * v * v -
                    8 * kSquare / rSquare * v -
                    8 * K * (C - A) / rSquare * v) * coeff;
        } else {
            double kSquare = K * K;
            double rSquare = mRadius * mRadius;
            double rQuad = rSquare * rSquare;
            return (16 * kSquare / rQuad * (v - mRadius) * (v - mRadius) * (v - mRadius) +
                    8 * K * (C - A) / rSquare * (v - mRadius)) * coeff;
        }
    }

    private boolean isValidCoordinate(int x, int y) {
        return (x >= 0 && x < mGridWidth && y >= 0 && y < mGridHeight);
    }

    private double penaltyForGridPoint(int x, int y) {
        return (gridMap(x, y) - mExpectedPotential) * (gridMap(x, y) - mExpectedPotential);
    }

    public static double potential(double x, double x0, double y, double y0, double radius) {
        return potential(x, x0, radius) * potential(y, y0, radius);
    }

    public static double potential(double v, double v0, double radius) {
        v = Math.abs(v - v0);
        if (v >= radius) {
            return 0.0;
        } else if (0 <= v && v <= radius / 2) {
            return (1 - 2 * (v / radius) * (v / radius));
        } else {
            return (2 * ((v - radius) / radius) * ((v - radius) / radius));
        }
    }
}
