package org.example.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphEdgeList {
    private final List<Edge> edges;

    public GraphEdgeList() {
        this.edges = new ArrayList<>();
    }

    public void addEdge(Node source, Node destination) {
        edges.add(new Edge(source, destination));
    }

    public boolean hasEdge(Node source, Node destination) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(source) && edge.getDestination().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void printGraph() {
        System.out.println("--- Edge List ---");
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }
    static void main() {
        // Create nodes
        Node nodeA = new Node("A", "A");
        Node nodeB = new Node("B", "B");
        Node nodeC = new Node("C", "C");

        // Create graph
        GraphEdgeList graph = new GraphEdgeList(); // Undirected

        // Add edges
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeB, nodeC);

        graph.printGraph();

        // Check edge existence
        System.out.println("\nEdge A -> B exists? " + graph.hasEdge(nodeA, nodeB));
        System.out.println("Edge B -> A exists? " + graph.hasEdge(nodeB, nodeA));
    }
}
