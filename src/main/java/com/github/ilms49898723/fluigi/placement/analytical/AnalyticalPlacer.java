package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.place.Placer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AnalyticalPlacer extends Placer {
    private enum InitializeFunction {
        RANDOM_INITIALIZE,
        CENTER_INITIALIZE,
        ZERO_INITIALIZE
    }

    private static final int MAX_WIDTH = 100;
    private static final int MAX_HEIGHT = 100;

    private static final double INITIAL_ALPHA = 5.0;
    private static final double FINAL_ALPHA = 1e-1;
    private static final double EPSILON = 1e-3;

    private static final double WIRE_LENGTH_GRAD_WEIGHT = 1;
    private static final double BOUNDARY_GRAD_WEIGHT = 1;
    private static final double DENSITY_GRAD_WEIGHT = 1;

    public AnalyticalPlacer() {
        super();
    }

    public AnalyticalPlacer(Placement problem) {
        super();
        loadProblem(problem);
    }

    @Override
    public void place() {
        if (problem.getCells().size() < 1) {
            return;
        }
        globalDistribute(INITIAL_ALPHA, FINAL_ALPHA, EPSILON);
        legalize();
    }

    private void globalDistribute(double initAlpha, double finalAlpha, double epsilon) {
//        initializeCellCoordinate(InitializeFunction.CENTER_INITIALIZE);
        int cellId = 0;
        double cost = 1e8;
        double prevCost = 0.0;
        double[][] direct = new double[problem.getCells().size()][2];
        Map<String, Integer> cellId2Idx = new HashMap<>();
        for (Cell cell : problem.getCells()) {
            cellId2Idx.put(cell.getID(), cellId++);
        }
        int iter = 0;
        for (double alpha = initAlpha; alpha >= finalAlpha || Math.abs(cost - prevCost) > epsilon; alpha *= 1.0) {
            double radius = (alpha > initAlpha * 0.8) ? 2 : (alpha > initAlpha * 0.2) ? 3 : 4;
            double[][] prevDirect = direct;
            direct = new double[problem.getCells().size()][2];
            prevCost = cost;
            WireLength wl = new WireLength(problem);
            Boundary bd = new Boundary(problem, 0, 0, MAX_WIDTH, MAX_HEIGHT);
            Density ds = new Density(problem, MAX_WIDTH, MAX_HEIGHT, radius, alpha);
            cost = wl.totalWireLength(alpha) + bd.penalty(alpha) + ds.penalty();
            System.out.println("wire len " + wl.totalWireLength(alpha));
            System.out.println("boundary " + bd.penalty(alpha));
            System.out.println("density  " + ds.penalty());
            for (Cell cell : problem.getCells()) {
                for (int axis = 1; axis <= 2; ++axis) {
                    cellId = cellId2Idx.get(cell.getID());
                    direct[cellId][axis - 1] =
                            WIRE_LENGTH_GRAD_WEIGHT * wl.step(cell, alpha, axis) +
                            BOUNDARY_GRAD_WEIGHT * bd.step(cell, alpha, axis) +
                            DENSITY_GRAD_WEIGHT * ds.step(cell, axis);
                }
            }
            if (iter > 0) {
                double[][] beta = calculateBeta(direct, prevDirect);
                for (Cell cell : problem.getCells()) {
                    cellId = cellId2Idx.get(cell.getID());
                    double deltaX = direct[cellId][0] + beta[cellId][0] * prevDirect[cellId][0];
                    double deltaY = direct[cellId][1] + beta[cellId][1] * prevDirect[cellId][1];
//                    double deltaX = direct[cellId][0];
//                    double deltaY = direct[cellId][1];
                    direct[cellId][0] = deltaX;
                    direct[cellId][1] = deltaY;
                    cell.addX(deltaX);
                    cell.addY(deltaY);
                }
            }
            ++iter;
            System.out.printf("Iter %d: alpha %f, cost %e, delta %e\n", iter, alpha, cost, Math.abs(cost - prevCost));
        }
    }

    private void legalize() {

    }

    private void initializeCellCoordinate(InitializeFunction function) {
        Random rd = new Random();
        switch (function) {
            case RANDOM_INITIALIZE:
                for (Cell cell : problem.getCells()) {
                    cell.setX(rd.nextInt(MAX_WIDTH - 200) + 100);
                    cell.setY(rd.nextInt(MAX_HEIGHT - 200) + 100);
                }
                break;
            case CENTER_INITIALIZE:
                int cx = MAX_WIDTH / 2;
                int cy = MAX_HEIGHT / 2;
                for (Cell cell : problem.getCells()) {
                    cell.setX(cx - cell.getXspan() / 2);
                    cell.setY(cy - cell.getYspan() / 2);
                }
                break;
            case ZERO_INITIALIZE:
                for (Cell cell : problem.getCells()) {
                    cell.setX(-cell.getXspan() / 2);
                    cell.setY(-cell.getYspan() / 2);
                }
                break;
        }
    }

    private double[][] calculateBeta(double[][] direct, double[][] prevDirect) {
        double[][] beta = new double[direct.length][direct[0].length];
        for (int i = 0; i < direct.length; ++i) {
            for (int j = 0; j < direct[i].length; ++j) {
                beta[i][j] = direct[i][j] / prevDirect[i][j] *
                        (direct[i][j] - prevDirect[i][j]) / prevDirect[i][j];
            }
        }
        return beta;
    }
}
