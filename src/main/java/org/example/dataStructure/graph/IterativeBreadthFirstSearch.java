package org.example.dataStructure.graph;

import java.util.*;

public class IterativeBreadthFirstSearch {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public IterativeBreadthFirstSearch(int vertices) {
        this.numVertices = vertices;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add a directed edge (for undirected graphs, add the reverse edge too)
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    // Standard BFS starting from a given vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        
        // Queue handles First-In, First-Out (FIFO) level order
        Queue<Integer> queue = new ArrayDeque<>();

        // Mark the start node as visited and enqueue it immediately
        visited[startVertex] = true;
        queue.offer(startVertex);

        System.out.print("BFS starting from vertex " + startVertex + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Check all unvisited neighbors
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark visited when enqueued to avoid duplicate entries
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    static void main(String[] args) {
        IterativeBreadthFirstSearch graph = new IterativeBreadthFirstSearch(5);

        // Build sample graph:
        // 0 -> 1, 0 -> 2
        // 1 -> 3, 1 -> 4
        // 2 -> 4
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        graph.bfs(0); // Output: 0 1 2 3 4
    }
}