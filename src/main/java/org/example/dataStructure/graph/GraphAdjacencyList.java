package org.example.dataStructure.graph;

import java.util.*;

public class GraphAdjacencyList {
    // Adjacency list
    Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public GraphAdjacencyList(List<Edge> edges) {
        // add edges to the undirected graph
        for (Edge e: edges) {
            adjacencyList.putIfAbsent((e.getSource()), new ArrayList<>());
            // Ensure destination node has an entry even if it has no outgoing node
            adjacencyList.putIfAbsent((e.getDestination()), new ArrayList<>());

            // Place nodes in the list
            adjacencyList.get((e.getSource())).add(e.getDestination());
            adjacencyList.get((e.getDestination())).add(e.getSource());
        }
    }

    // print adjacency list representation of graph
    public void printGraph(GraphAdjacencyList graphAdjacencyList) {
        graphAdjacencyList.adjacencyList.keySet().forEach(
                node -> System.out.println(node + adjacencyList.get(node).toString())
        );
    }

    static void main(String[] args) {
        // Create nodes
        Node nodeA = new Node("A", "A");
        Node nodeB = new Node("B", "B");
        Node nodeC = new Node("C", "C");

        List<Edge> edges = Arrays.asList(
                new Edge(nodeA, nodeB),
                new Edge(nodeA, nodeC),
                new Edge(nodeB, nodeC)
        );

        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList(edges);

        // print adjacency list representation of the graph
        graphAdjacencyList.printGraph(graphAdjacencyList);
    }
}