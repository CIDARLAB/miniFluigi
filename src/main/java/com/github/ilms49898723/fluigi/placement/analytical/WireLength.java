package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.layout.Placement;

import java.util.Set;

public class WireLength {
    private Placement mProblem;

    public WireLength(Placement problem) {
        mProblem = problem;
    }

    public double totalWireLength(double alpha) {
        return totalWireLength(1, alpha) + totalWireLength(2, alpha);
    }

    public double totalWireLength(int axis, double alpha) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            double weight = 1.0;
            result += weight * logSumExp(src, tgt, alpha, axis);
        }
        return result;
    }

    public double wireLength(String respect, int axis, double alpha) {
        return wireLength(mProblem.getCell(respect), axis, alpha);
    }

    public double wireLength(Cell respect, int axis, double alpha) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            if (src.equals(respect) || tgt.equals(respect)) {
                double weight = 1.0;
                result += weight * logSumExp(src, tgt, alpha, axis);
            }
        }
        return result;
    }

    public double gradient(String respect, int axis, double alpha) {
        return gradient(mProblem.getCell(respect), axis, alpha);
    }

    public double gradient(Cell respect, int axis, double alpha) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            if (src.equals(respect) || tgt.equals(respect)) {
                result += exp(respect, 1.0, alpha, axis) / sumExp(src, tgt, 1.0, alpha, axis) -
                        exp(respect, -1.0, alpha, axis) / sumExp(src, tgt, -1.0, alpha, axis);
            }
        }
        return result;
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
        if (axis == 1) {
            return alpha * Math.log(sumExp(a, b, coeff, alpha, axis));
        } else {
            return alpha * Math.log(sumExp(a, b, coeff, alpha, axis));
        }
    }
}
