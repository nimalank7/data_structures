package org.example.dataStructure.graph;

import java.util.*;

public class IterativeDepthFirstSearch {
    private final int numVertices;
    // Adjacency list
    private final List<List<Integer>> adjList;

    public IterativeDepthFirstSearch(int vertices) {
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

    // Iterative DFS starting from a given vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];

        // Use a Dequeue for our stack
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(startVertex);

        System.out.print("Iterative DFS traversal starting from " + startVertex + ": ");

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // Process node if it hasn't been visited yet
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                // Push adjacent neighbors onto the stack.
                // We iterate in reverse so the first added neighbor gets processed first,
                // matching standard recursive DFS order.
                List<Integer> neighbors = adjList.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }

    static void main(String[] args) {
        IterativeDepthFirstSearch graph = new IterativeDepthFirstSearch(5);

        // Build sample graph:
        // 0 -> 1, 0 -> 2
        // 1 -> 3, 1 -> 4
        // 2 -> 4
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        graph.dfs(0); // Output: 0 1 3 4 2
    }
}
