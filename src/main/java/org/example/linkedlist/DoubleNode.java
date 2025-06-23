package org.example.linkedlist;

public class DoubleNode {
    public int data;
    public DoubleNode previous;
    public DoubleNode next;

    public DoubleNode(DoubleNode previous, int data, DoubleNode next) {
        this.previous = previous;
        if (previous != null) {
            previous.next = this;
        }

        this.data = data;

        this.next = next;

        if (next != null) {
            next.previous = this;
        }
    }
}
