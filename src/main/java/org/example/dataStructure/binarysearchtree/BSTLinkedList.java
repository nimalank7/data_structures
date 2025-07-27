package org.example.dataStructure.binarysearchtree;

public class BSTLinkedList {
    // Implementation using a LinkedList
    public Node root;

    // Double check insertion into a binary search tree
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        // Go down the tree until we find a leaf node with either left/right as null and insert
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data)  {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    public void inTraversal(Node node) {
        /*
        Assume a tree with A as root node and C is the leaf node with the left most path is like A -> B -> C -> null
        inTraversal(C) and C is not null but node.left = NULL
        So when inTraversal(node.left) is called then it returns as node == null.
        Execution passes to System.out.println(node) which prints out C's data.
        Execution passes to inTraversal(node.right) which is also node.right = NULL as node = C
        Then inTraversal(C) returns and execution passes to System.out.println(B) etc...
        Then we go to B's right etc...
         */
        if (node == null) return;

        inTraversal(node.left); // Reach the bottom of the tree via the left by recursive calls
        /*
        Assume that node = leaf node
         */
        System.out.println(node);
        inTraversal(node.right);
    }

    public static void main(String[] args) {
        BSTLinkedList tree = new BSTLinkedList();
        tree.insert(7); // Root node is initially null so root node becomes 7
        tree.insert(2); // Insert to left of 7
        tree.insert(3); // Insert to right of 2
        tree.insert(1); // Insert to left of 2
        tree.insert(9); // Insert to right of 7
        tree.inTraversal(tree.root);
    }

    /*
    Output is:
    data: 1, left: null, right: null
    data: 2, left: 1, right: 3
    data: 3, left: null, right: null
    data: 7, left: 2, right: 9
    data: 9, left: null, right: null
     */
}
