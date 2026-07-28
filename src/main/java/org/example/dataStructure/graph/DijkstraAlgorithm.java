package org.example.dataStructure.graph;

import java.util.*;

public class DijkstraAlgorithm {

    // Represents a directed edge to a neighbor with a specific weight
    static class Edge {
        int targetNode;
        int weight;

        public Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }

    // Helper class to store (node, currentDistance) pairs in the PriorityQueue
    static class NodeDistance implements Comparable<NodeDistance> {
        int node;
        int distance;

        public NodeDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        // Min-heap ordering: smallest distance gets prioritized
        @Override
        public int compareTo(NodeDistance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * Computes shortest paths from source to all other nodes.
     *
     * @param numNodes Total number of nodes in the graph (0 to numNodes - 1)
     * @param graph    Adjacency list representation of the graph
     * @param source   The starting node
     * @return Array of shortest distances from source to every node
     */
    public static int[] dijkstra(int numNodes, List<List<Edge>> graph, int source) {
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Min-PriorityQueue to greedily extract the unvisited node with the smallest distance
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>();
        pq.add(new NodeDistance(source, 0));

        boolean[] visited = new boolean[numNodes];

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            int u = current.node;

            // Skip if we've already visited this node
            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            // Calculate distance
            for (Edge edge : graph.get(u)) {
                int v = edge.targetNode;
                int weight = edge.weight;

                // If shorter than previous route then update
                if (!visited[v] && distances[u] + weight < distances[v]) {
                    // Update with shorter distance
                    distances[v] = distances[u] + weight;
                    pq.add(new NodeDistance(v, distances[v]));
                }
            }
        }

        return distances;
    }

    static void main() {
        int numNodes = 5;
        /*
        In an unweighted graph each node just stores a list of neighbouring nodes.
        In a weighted graph we store the edge which has the weight and destination node.
        The below is an adjacency list
         */
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Construct graph edges: (source, target, weight)
        graph.get(0).add(new Edge(1, 4)); // 0 -> 1 (weight 4)
        graph.get(0).add(new Edge(2, 2)); // 0 -> 2 (weight 2)
        graph.get(1).add(new Edge(2, 1)); // 1 -> 2 (weight 1)
        graph.get(1).add(new Edge(3, 5)); // 1 -> 3 (weight 5)
        graph.get(2).add(new Edge(3, 8)); // 2 -> 3 (weight 8)
        graph.get(2).add(new Edge(4, 10));// 2 -> 4 (weight 10)
        graph.get(3).add(new Edge(4, 2)); // 3 -> 4 (weight 2)

        int source = 0;
        int[] shortestDistances = dijkstra(numNodes, graph, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("To node " + i + " -> " + shortestDistances[i]);
        }
    }
}