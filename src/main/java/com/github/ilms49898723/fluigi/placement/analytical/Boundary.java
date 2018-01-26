package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;

public class Boundary {
    public static double penaltyForCell(Cell c, double le, double re, double be, double te, double alpha) {
        double x = c.getCenterX();
        double y = c.getCenterY();
        return penalty(x - le, alpha) + penalty(re - x, alpha) + penalty(y - be, alpha) + penalty(te - y, alpha);
    }

    public static double penaltyForGradient(Cell c, double le, double re, double be, double te, double alpha, int axis) {
        double x = c.getCenterX();
        double y = c.getCenterY();
        if (axis == 1) {
            return penaltyGradient(x - le, alpha) + penaltyGradient(re - x, alpha);
        } else {
            return penaltyGradient(y - be, alpha) + penaltyGradient(te - y, alpha);
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
