package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Density {
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
    private double[][] mGridMap;
    private double mAlpha;
    private double mRadius;
    private double mGridLength;
    private double mExpectedPotential;
    private int mWidth;
    private int mHeight;
    private int mGridWidth;
    private int mGridHeight;

    public Density(Placement problem, int width, int height, double radius, double alpha) {
        mProblem = problem;
        mAlpha = alpha;
        mRadius = radius;
        mGridLength = mAlpha / mRadius;
        mWidth = width;
        mHeight = height;
        initialize();
    }

    public void initialize() {
        mCellPointMap = new HashMap<>();
        mGridWidth = (int) Math.floor(mWidth / mGridLength + 1);
        mGridHeight = (int) Math.floor(mHeight / mGridLength + 1);
        mGridMap = new double[mGridWidth][mGridHeight];
        for (double[] mapArray : mGridMap) {
            Arrays.fill(mapArray, 0.0);
        }
        calculatePenalty();
    }

    public void calculatePenalty() {
        List<Cell> cells = mProblem.getCells();
        for (Cell cell : cells) {
            double cx = cell.getCenterX() / mGridLength;
            double cy = cell.getCenterY() / mGridLength;
            int lx = (int) (Math.floor(cx / mGridLength) - mRadius);
            int ly = (int) (Math.floor(cy / mGridLength) - mRadius);
            int rx = (int) (Math.ceil(cx / mGridLength) + mRadius);
            int ry = (int) (Math.ceil(cy / mGridLength) + mRadius);
            mCellPointMap.put(cell.getID(), new Values(lx, ly, rx, ry));
            for (int x = lx; x <= rx; ++x) {
                for (int y = ly; y <= ry; ++y) {
                    if (isValidCoordinate(x, y)) {
                        mGridMap[x][y] += potential(x, cx, y, cy, mRadius);
                    }
                }
            }
        }
        double totalArea = 0.0;
        for (Cell cell : cells) {
            totalArea += cell.getXspan() * cell.getYspan();
        }
        mExpectedPotential = totalArea / (mGridWidth * mGridHeight);
    }

    public double totalPenalty() {
        double totalPenalty = 0.0;
        for (int i = 0; i < mGridWidth; ++i) {
            for (int j = 0; j < mGridHeight; ++j) {
                totalPenalty += penaltyForGridPoint(i, j);
            }
        }
        return totalPenalty;
    }

    public double gradient(String cell, int axis) {
        return gradient(mProblem.getCell(cell), axis);
    }

    public double gradient(Cell cell, int axis) {
        double result = 0.0;
        Values points = mCellPointMap.get(cell.getID());
        double cx = cell.getCenterX() / mGridLength;
        double cy = cell.getCenterY() / mGridLength;
        int lx = points.a;
        int ly = points.b;
        int rx = points.x;
        int ry = points.y;
        for (int x = lx; x <= rx; ++x) {
            for (int y = ly; y <= ry; ++y) {
                if (isValidCoordinate(x, y)) {
                    double C = mGridMap[x][y] - potential(x, cx, y, cy, mRadius);
                    double K = (axis == 1) ? potential(y, cy, mRadius) : potential(x, cx, mRadius);
                    double A = mExpectedPotential;
                    result += (axis == 1) ? gradient(x, cx, C, K, A) : gradient(y, cy, C, K, A);
                }
            }
        }
        return result;
    }

    private double gradient(double v, double v0, double C, double K, double A) {
        double delta = Math.abs(v - v0);
        v = v - v0;
        if (delta >= mRadius) {
            return 0.0;
        } else if (0 <= delta && delta <= mRadius / 2) {
            double kSquare = K * K;
            double rSquare = mRadius * mRadius;
            double rQuad = rSquare * rSquare;
            return 16 * kSquare / rQuad * v * v * v -
                    8 * kSquare / rSquare * v -
                    8 * K * (C - A) / rSquare * v;
        } else {
            double kSquare = K * K;
            double rSquare = mRadius * mRadius;
            double rQuad = rSquare * rSquare;
            return 16 * kSquare / rQuad * (v - mRadius) * (v - mRadius) * (v - mRadius) +
                    8 * K * (C - A) / rSquare * (v - mRadius);
        }
    }

    private boolean isValidCoordinate(int x, int y) {
        return (x >= 0 && x < mGridWidth && y >= 0 && y < mGridHeight);
    }

    private double penaltyForGridPoint(int x, int y) {
//        return (mGridMap[x][y] - mExpectedPotential) * (mGridMap[x][y] - mExpectedPotential);
        if (mGridMap[x][y] >= mExpectedPotential) {
            return (mGridMap[x][y] - mExpectedPotential) * (mGridMap[x][y] - mExpectedPotential);
        } else {
            return 0.0;
        }
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
