package com.github.ilms49898723.fluigi.placement.graphpartition;

import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.layout.Point;
import org.cidarlab.fluigi.place.Placer;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class GraphPartitionPlacer extends Placer {
    private static final int NUM_CELLS_IN_A_SLOT = 4;
    private static final int MAX_WIDTH = 76800;
    private static final int MAX_HEIGHT = 76800;

    private Placement mPlacement;
    private Graph<String, DefaultEdge> mGraph;

    public GraphPartitionPlacer(Placement placement) {
        mPlacement = placement;
        problem = placement;
        constructGraph();
    }

    @Override
    public void place() {
        graphPartition(mGraph, Point.zero(), new Point(MAX_WIDTH, MAX_HEIGHT));
    }

    private void constructGraph() {
        for (Cell cell : mPlacement.getCells()) {
            mGraph.addVertex(cell.getID());
        }
        for (Net net : mPlacement.getNets()) {
            Cell source = mPlacement.getNetSource(net);
            Cell target = mPlacement.getNetTarget(net);
            mGraph.addEdge(source.getID(), target.getID());
        }
    }

    private boolean graphPartition(Graph<String, DefaultEdge> graph, Point basePoint, Point size) {
        if (graph.vertexSet().size() <= NUM_CELLS_IN_A_SLOT) {
            return placeCells(graph, basePoint, size);
        } else {
            GraphUtil.FarthestPair farthestPair = new GraphUtil.FarthestPair(graph);
            String startA = farthestPair.getVertexA();
            int numVertex = graph.vertexSet().size();
            int limitA = numVertex / 2;
            Set<String> vertexA = breadthFirstSearch(graph, startA, limitA);
            Set<String> vertexB = new HashSet<>();
            vertexB.addAll(graph.vertexSet());
            vertexB.removeAll(vertexA);
            Graph<String, DefaultEdge> subGraphA = GraphUtil.constructSubGraph(graph, vertexA);
            Graph<String, DefaultEdge> subGraphB = GraphUtil.constructSubGraph(graph, vertexB);
            double rateA = getRate(vertexA, graph.vertexSet());
            double rateB = 1.0 - rateA;
            if (size.getX() < size.getY()) {
                Point newBasePointA = new Point(basePoint.getX(), basePoint.getY());
                Point newBasePointB = new Point(basePoint.getX(), (int) (basePoint.getY() + size.getY() * rateA));
                Point newSizeA = new Point(size.getX(), (int) (size.getY() * rateA));
                Point newSizeB = new Point(size.getX(), (int) (size.getY() * rateB));
                boolean resultA = graphPartition(subGraphA, newBasePointA, newSizeA);
                boolean resultB = graphPartition(subGraphB, newBasePointB, newSizeB);
                return resultA && resultB;
            } else {
                Point newBasePointA = new Point(basePoint.getX(), basePoint.getY());
                Point newBasePointB = new Point((int) (basePoint.getX() + size.getX() * rateA), basePoint.getY());
                Point newSizeA = new Point((int) (size.getX() * rateA), size.getY());
                Point newSizeB = new Point((int) (size.getX() * rateB), size.getY());
                boolean resultA = graphPartition(subGraphA, newBasePointA, newSizeA);
                boolean resultB = graphPartition(subGraphB, newBasePointB, newSizeB);
                return resultA && resultB;
            }
        }
    }

    private double getRate(Set<String> sub, Set<String> all) {
        double a = (double) sub.size();
        double b = (double) all.size();
        return a / b;
    }

    private Set<String> breadthFirstSearch(Graph<String, DefaultEdge> graph, String start, int limit) {
        Set<String> result = new HashSet<>();
        int size = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        result.add(start);
        size++;
        while (!queue.isEmpty() && size < limit) {
            String front = queue.poll();
            for (DefaultEdge edge : graph.edgesOf(front)) {
                String vertexA = graph.getEdgeSource(edge);
                String vertexB = graph.getEdgeTarget(edge);
                String out = (vertexA.equals(front)) ? vertexB : vertexA;
                if (!result.contains(out)) {
                    if (size < limit) {
                        result.add(out);
                        size++;
                        queue.add(out);
                    }
                }
            }
        }
        return result;
    }

    private boolean placeCells(Graph<String, DefaultEdge> graph, Point basePoint, Point size) {
        Point a = basePoint.add(new Point(size.getX() / 4, size.getY() / 4));
        Point b = basePoint.add(new Point(size.getX() * 3 / 4, size.getY() / 4));
        Point c = basePoint.add(new Point(size.getX() / 4, size.getY() * 3 / 4));
        Point d = basePoint.add(new Point(size.getX() * 3 / 4, size.getY() * 3 / 4));
        List<Point> mps = new ArrayList<>();
        mps.addAll(Arrays.asList(a, b, c, d));
        int counter = 0;
        for (String v : graph.vertexSet()) {
            Cell cell = mPlacement.getCell(v);
            cell.setX(mps.get(counter).getX());
            cell.setY(mps.get(counter).getY());
            counter++;
        }
        return true;
    }
}
