package org.example.dataStructure.binarysearchtree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("data: %d, left: %d, right: %d",
                data,
                (left != null ? left.data : null),
                (right != null ? right.data : null)
        );
    }
}
