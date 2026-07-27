package org.example.dataStructure.graph;

import java.util.Objects;

public class Node {
    private final String id;
    private final String name; // Optional additional metadata

    public Node(String id) {
        this(id, id);
    }

    public Node(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Overriding equals and hashCode ensures nodes can be compared accurately
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
