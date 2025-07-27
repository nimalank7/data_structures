package org.example.dataStructure.linkedlist;

public class SingleLinkedList {
    SingleNode head;

    public void addFirst(int data) {
        if (head == null) {
            head = new SingleNode(data);
            return;
        }

        /*
        Set the new node to point to the current head node
        Then set the current head node to the new node
        If 3 (H) -> 4, and we want to insert 2 as head, then we do 2 -> 3(H) -> 4
        and 2(H) -> 3 -> 4
         */
        SingleNode newNode = new SingleNode(data);
        newNode.next = this.head;

        this.head = newNode;
    }

    public void addLast(int data) {
        if (head == null) {
            head = new SingleNode(data);
            return;
        }

        SingleNode currentNode = this.head;
        // Iterate through the nodes until we get to a node.next which is null
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new SingleNode(data);
    }

    public void removeFirst() {
        if (this.head == null) return;

        // Set the current head node to point to its next one and let Java garbage collect the original head node
        this.head = this.head.next;
    }

    public void removeLast() {
        if (this.head == null) return;

        if (this.head.next == null) {
            this.head = null;
            return;
        }

        SingleNode currentNode = this.head;
        /*
        2 -> 3 -> 4 -> 5
        Suppose we check 4 then since 4.next = 5 and 5.next = null then 4.next.next is null
        so the condition isn't met so we set 4.next = null which effectively removes 5
         */
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
    }

    public void traversal() {
        SingleNode currentNode = this.head;
        /*
        Iterate through the nodes checking if the next node is null.
        If the next node is null then exit out the loop and print an empty line
         */
        while (currentNode != null) {
            System.out.printf("%d ", currentNode.data);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedList myLinkedList = new SingleLinkedList();
        myLinkedList.addLast(2); // 2 becomes head
        myLinkedList.addLast(6); // 2 is still head
        myLinkedList.addFirst(9); // 9 is now head

        System.out.println("Traverse all elements");
        myLinkedList.traversal(); // 9, 2, 6

        System.out.println("Remove the first node");
        myLinkedList.removeFirst();
        myLinkedList.traversal(); // 2, 6

        System.out.println("Remove the last node");
        myLinkedList.removeLast();
        myLinkedList.traversal(); // 2
    }
}