package com.pack.def;

import java.util.*;

public class DAGLongestPath {

    // Inner class representing the graph structure
    static class DirectedGraph {
        private final int numVertices;
        private final List<List<Integer>> adjacencyList;

        public DirectedGraph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new ArrayList<>(numVertices);
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // Method to add a directed edge from vertex u to vertex v
        public void addDirectedEdge(int u, int v) {
            adjacencyList.get(u).add(v);
        }

        // Helper method to perform a topological sort on the graph
        private void performTopologicalSort(int vertex, boolean[] visited, Deque<Integer> stack) {
            visited[vertex] = true;

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    performTopologicalSort(neighbor, visited, stack);
                }
            }

            stack.offerFirst(vertex);
        }

        // Method to compute the longest path starting from the source vertex
        public int computeLongestPathFrom(int source) {
            Deque<Integer> topoStack = new ArrayDeque<>();
            boolean[] visited = new boolean[numVertices];

            // Perform topological sort on all vertices
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    performTopologicalSort(i, visited, topoStack);
                }
            }

            // Compute the longest path by traversing in topological order
            int longestPathLength = 0;

            while (!topoStack.isEmpty()) {
                int currentVertex = topoStack.pollFirst();

                if (currentVertex == source) {
                    for (int neighbor : adjacencyList.get(currentVertex)) {
                        longestPathLength = Math.max(longestPathLength, 1 + exploreLongestPath(neighbor));
                    }
                }
            }

            return longestPathLength;
        }

        // Helper method to explore the longest path from a given vertex
        private int exploreLongestPath(int vertex) {
            int maxLength = 0;

            for (int neighbor : adjacencyList.get(vertex)) {
                maxLength = Math.max(maxLength, 1 + exploreLongestPath(neighbor));
            }

            return maxLength;
        }
    }

    // Driver method to test the graph and the longest path computation
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 4);
        graph.addDirectedEdge(4, 5);

        int source = 0;
        System.out.println("The longest path starting from vertex " + source + " is: " + graph.computeLongestPathFrom(source));
    }
}

