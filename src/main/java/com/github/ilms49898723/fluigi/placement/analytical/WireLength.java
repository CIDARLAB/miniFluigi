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
        return totalWireLength(alpha, 1) + totalWireLength(alpha, 2);
    }

    public double totalWireLength(double alpha, int axis) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            double weight = 1.0;
            result += weight * logSumExp(src, tgt, alpha, axis) -
                    weight * logSumExp(src, tgt, -alpha, axis);
        }
        return result;
    }

    public double wireLength(String respect, double alpha, int axis) {
        return wireLength(mProblem.getCell(respect), alpha, axis);
    }

    public double wireLength(Cell respect, double alpha, int axis) {
        double result = 0.0;
        Set<Net> nets = mProblem.getNets();
        for (Net net : nets) {
            Cell src = mProblem.getNetSource(net);
            Cell tgt = mProblem.getNetTarget(net);
            if (src.equals(respect) || tgt.equals(respect)) {
                double weight = 1.0;
                result += weight * logSumExp(src, tgt, alpha, axis) -
                        weight * logSumExp(src, tgt, -alpha, axis);
            }
        }
        return result;
    }

    public double gradient(String respect, double alpha, int axis) {
        return gradient(mProblem.getCell(respect), alpha, axis);
    }

    public double gradient(Cell respect, double alpha, int axis) {
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

    public double step(String respect, double alpha, int axis) {
        return (-1) * gradient(respect, alpha, axis);
    }

    public double step(Cell respect, double alpha, int axis) {
        return (-1) * gradient(respect, alpha, axis);
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
