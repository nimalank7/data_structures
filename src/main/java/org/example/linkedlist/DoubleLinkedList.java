package org.example.linkedlist;

public class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;

    public void addFirst(int data) {
        DoubleNode newNode = new DoubleNode(null, data, this.head);
        this.head = newNode;
        // Handle the case if this is the only node in the list
        if(this.tail == null) this.tail = this.head;
    }

    public void addLast(int data) {
        DoubleNode newNode = new DoubleNode(this.tail, data, null);
        this.tail = newNode;
        // Handle the case if this is the only node in the list
        if(this.head == null) this.head = this.tail;
    }

    public void removeFirst() {
        if (this.head == null) return;

        this.head = this.head.next;
        if (this.head == null) this.tail = null; // Handle the case if this is the only node in the list
        this.head.previous = null;
    }

    public void removeLast() {
        if (this.head == null) return;

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
            return;
        }

        DoubleNode beforeTail = this.tail.previous;
        beforeTail.next = null;
        this.tail = beforeTail;
    }

    public void traversal() {
        DoubleNode currentNode = this.head;
        while (currentNode != null) {
            System.out.printf("%d ", currentNode.data);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList myLinkedList = new DoubleLinkedList();
        myLinkedList.addLast(2);
        myLinkedList.addLast(6);
        myLinkedList.addFirst(9);

        System.out.println("Traverse all elements");
        myLinkedList.traversal();

        System.out.println("Remove the first node");
        myLinkedList.removeFirst();
        myLinkedList.traversal();

        System.out.println("Remove the last node");
        myLinkedList.removeLast();
        myLinkedList.traversal();
    }
}
