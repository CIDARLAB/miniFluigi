package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;

public class Boundary {
    private Placement mProblem;
    private double mLe;
    private double mRe;
    private double mBe;
    private double mTe;
    private double mAlpha;

    public Boundary(Placement problem, double le, double be, double re, double te, double alpha) {
        mProblem = problem;
        mLe = le;
        mBe = be;
        mRe = re;
        mTe = te;
        mAlpha = alpha;
    }

    public double penalty() {
        double total = 0.0;
        for (Cell cell : mProblem.getCells()) {
            total += penalty(cell);
        }
        return total;
    }

    public double penalty(String cell) {
        return penaltyForCell(mProblem.getCell(cell), mLe, mBe, mRe, mTe, mAlpha);
    }

    public double penalty(Cell cell) {
        return penaltyForCell(cell, mLe, mBe, mRe, mTe, mAlpha);
    }

    public double gradient(String respect, int axis) {
        return penaltyGradientForCell(mProblem.getCell(respect), mLe, mBe, mRe, mTe, mAlpha, axis);
    }

    public double gradient(Cell respect, int axis) {
        return penaltyGradientForCell(respect, mLe, mBe, mRe, mTe, mAlpha, axis);
    }

    public double step(String respect, int axis) {
        return (-1) * gradient(respect, axis);
    }

    public double step(Cell respect, int axis) {
        return (-1) * gradient(respect, axis);
    }

    public static double penaltyForCell(Cell c, double le, double be, double re, double te, double alpha) {
        double x = c.getCenterX();
        double y = c.getCenterY();
        return penalty(x - le, alpha) + penalty(re - x, alpha) + penalty(y - be, alpha) + penalty(te - y, alpha);
    }

    public static double penaltyGradientForCell(Cell respect, double le, double be, double re, double te, double alpha, int axis) {
        double x = respect.getCenterX();
        double y = respect.getCenterY();
        if (axis == 1) {
            return penaltyGradient(x - le, alpha) + (-1) * penaltyGradient(re - x, alpha);
        } else {
            return penaltyGradient(y - be, alpha) + (-1) * penaltyGradient(te - y, alpha);
        }
    }

    public static double penalty(double x, double alpha) {
        if (x >= 0) {
            return 0.0;
        } else {
            return (x / alpha) * (x / alpha);
        }
    }

    public static double penaltyGradient(double x, double alpha) {
        if (x >= 0) {
            return 0.0;
        } else {
            return 2 * x / alpha / alpha;
        }
    }
}
