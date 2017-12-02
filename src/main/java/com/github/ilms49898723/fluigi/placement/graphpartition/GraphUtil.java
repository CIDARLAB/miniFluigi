package com.github.ilms49898723.fluigi.placement.graphpartition;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.*;

public class GraphUtil {
    public static class FarthestPair {
        private Graph<String, DefaultEdge> mGraph;
        private List<String> mVertices;
        private String mVertexA;
        private String mVertexB;

        public FarthestPair(Graph<String, DefaultEdge> graph) {
            mGraph = graph;
            mVertices = new ArrayList<>(graph.vertexSet());
            mVertexA = breadthFirstSearch(mVertices.get(0));
            mVertexB = breadthFirstSearch(mVertexA);
        }

        public String getVertexA() {
            return mVertexA;
        }

        public String getVertexB() {
            return mVertexB;
        }

        private boolean isConnected(Graph<String, DefaultEdge> graph) {
            Queue<String> queue = new ArrayDeque<>();
            Map<String, Boolean> visited = new HashMap<>();
            for (String v : mVertices) {
                visited.put(v, false);
            }
            String current = mVertices.get(0);
            queue.add(current);
            while (!queue.isEmpty()) {
                current = queue.poll();
                for (DefaultEdge edge : graph.edgesOf(current)) {
                    String vertexA = graph.getEdgeSource(edge);
                    String vertexB = graph.getEdgeTarget(edge);
                    String next = (vertexA.equals(current)) ? vertexB : vertexA;
                    if (!visited.get(next)) {
                        visited.put(next, true);
                        queue.add(next);
                    }
                }
            }
            boolean isConnect = true;
            for (String v : mVertices) {
                if (visited.get(v)) {
                    mVertexA = v;
                } else {
                    mVertexB = v;
                    isConnect = false;
                }
            }
            return isConnect;
        }

        private String breadthFirstSearch(String vertex) {
            Queue<String> queue = new ArrayDeque<>();
            Map<String, Integer> visited = new HashMap<>();
            for (String v : mVertices) {
                visited.put(v, -1);
            }
            queue.add(vertex);
            visited.put(vertex, 0);
            while (!queue.isEmpty()) {
                String front = queue.poll();
                for (DefaultEdge edge : mGraph.edgesOf(front)) {
                    String vertexA = mGraph.getEdgeSource(edge);
                    String vertexB = mGraph.getEdgeTarget(edge);
                    String out = (vertexA.equals(front)) ? vertexB : vertexA;
                    if (visited.get(out) == -1) {
                        visited.put(out, visited.get(front) + 1);
                        queue.add(out);
                    }
                }
            }
            String result = "";
            int max = Integer.MIN_VALUE;
            for (String key : visited.keySet()) {
                if (visited.get(key) > max) {
                    max = visited.get(key);
                    result = key;
                }
            }
            return result;
        }
    }

    public static SimpleGraph<String, DefaultEdge> constructSubGraph(Graph<String, DefaultEdge> graph, Set<String> vertexSet) {
        SimpleGraph<String, DefaultEdge> result = new SimpleGraph<>(DefaultEdge.class);
        for (String vertex : vertexSet) {
            result.addVertex(vertex);
        }
        for (DefaultEdge edge : graph.edgeSet()) {
            String vertexA = graph.getEdgeSource(edge);
            String vertexB = graph.getEdgeTarget(edge);
            if (vertexSet.contains(vertexA) && vertexSet.contains(vertexB)) {
                if (!result.containsEdge(vertexA, vertexB)) {
                    result.addEdge(vertexA, vertexB);
                }
            }
        }
        return result;
    }
}
