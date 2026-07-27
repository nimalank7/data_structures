package org.example.dataStructure.graph;

import java.util.*;

public class GraphAdjacencyMatrix {
    private final List<Node> nodes;
    private final int[][] matrix;

    public GraphAdjacencyMatrix(List<Node> nodes, List<Edge> edges) {
        this.nodes = new ArrayList<>(nodes);
        Map<Node, Integer> nodeIndexMap = new HashMap<>();

        // Map each node to a matrix row/column index (0, 1, 2, ...)
        for (int i = 0; i < nodes.size(); i++) {
            nodeIndexMap.put(nodes.get(i), i);
        }

        // Initialize NxN matrix with 0s
        int numNodes = nodes.size();
        this.matrix = new int[numNodes][numNodes];

        // Populate the matrix based on edges
        for (Edge e : edges) {
            Integer srcIndex = nodeIndexMap.get(e.getSource());
            Integer destIndex = nodeIndexMap.get(e.getDestination());

            if (srcIndex != null && destIndex != null) {
                // Set edge present (1)
                matrix[srcIndex][destIndex] = 1;

                // Undirected graph: symmetric matrix
                matrix[destIndex][srcIndex] = 1;
            }
        }
    }

    // Print adjacency matrix representation of the graph
    public void printGraph() {
        System.out.println("--- Adjacency Matrix ---");

        // Print header row of node labels
        System.out.print("  ");
        for (Node node : nodes) {
            System.out.print(node.getName() + " ");
        }
        System.out.println();

        // Print rows
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).getName() + " "); // Row label
            for (int j = 0; j < nodes.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void main(String[] args) {
        Node nodeA = new Node("A", "A");
        Node nodeB = new Node("B", "B");
        Node nodeC = new Node("C", "C");

        List<Node> nodes = Arrays.asList(nodeA, nodeB, nodeC);

        List<Edge> edges = Arrays.asList(
                new Edge(nodeA, nodeB),
                new Edge(nodeA, nodeC),
                new Edge(nodeB, nodeC)
        );

        GraphAdjacencyMatrix graphMatrix = new GraphAdjacencyMatrix(nodes, edges);

        // Print adjacency matrix representation of the graph
        graphMatrix.printGraph();
    }
}