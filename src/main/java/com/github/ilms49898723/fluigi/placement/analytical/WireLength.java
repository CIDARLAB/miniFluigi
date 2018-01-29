package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.layout.Placement;

import java.util.Set;

public class WireLength {
    private Placement mProblem;
    private double mAlpha;

    public WireLength(Placement problem, double alpha) {
        mProblem = problem;
        mAlpha = alpha;
    }

    public double penalty() {
        return penalty(1) + penalty(2);
    }

    public double penalty(int axis) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            double weight = 1.0;
            result += weight * logSumExp(src, tgt, mAlpha, axis) -
                    weight * logSumExp(src, tgt, -mAlpha, axis);
        }
        return result;
    }

    public double penalty(String respect, int axis) {
        return penalty(mProblem.getCell(respect), axis);
    }

    public double penalty(Cell respect, int axis) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            if (src.equals(respect) || tgt.equals(respect)) {
                double weight = 1.0;
                result += weight * logSumExp(src, tgt, mAlpha, axis) -
                        weight * logSumExp(src, tgt, -mAlpha, axis);
            }
        }
        return result;
    }

    public double gradient(String respect, int axis) {
        return gradient(mProblem.getCell(respect), axis);
    }

    public double gradient(Cell respect, int axis) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            if (src.equals(respect) || tgt.equals(respect)) {
                result += exp(respect, 1.0, mAlpha, axis) / sumExp(src, tgt, 1.0, mAlpha, axis) -
                        exp(respect, -1.0, mAlpha, axis) / sumExp(src, tgt, -1.0, mAlpha, axis);
            }
        }
        return result;
    }

    public double step(String respect, int axis) {
        return (-1) * gradient(respect, axis);
    }

    public double step(Cell respect, int axis) {
        return (-1) * gradient(respect, axis);
    }

    public static double exp(Cell cell, double alpha, int axis) {
        return exp(cell, 1.0, alpha, axis);
    }

    public static double exp(Cell cell, double coeff, double alpha, int axis) {
        if (axis == 1) {
            return Math.exp(coeff * cell.getCenterX() / alpha);
        } else {
            return Math.exp(coeff * cell.getCenterY() / alpha);
        }
    }

    public static double sumExp(Cell a, Cell b, double alpha, int axis) {
        return sumExp(a, b, 1.0, alpha, axis);
    }

    public static double sumExp(Cell a, Cell b, double coeff, double alpha, int axis) {
        if (axis == 1) {
            return Math.exp(coeff * a.getCenterX() / alpha) + Math.exp(coeff * b.getCenterX() / alpha);
        } else {
            return Math.exp(coeff * a.getCenterY() / alpha) + Math.exp(coeff * b.getCenterY() / alpha);
        }
    }

    public static double logSumExp(Cell a, Cell b, double alpha, int axis) {
        return logSumExp(a, b, 1.0, alpha, axis);
    }

    public static double logSumExp(Cell a, Cell b, double coeff, double alpha, int axis) {
        return alpha * Math.log(sumExp(a, b, coeff, alpha, axis));
    }
}
