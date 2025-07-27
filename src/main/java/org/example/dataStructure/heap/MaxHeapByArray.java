package org.example.dataStructure.heap;

public class MaxHeapByArray {
    private int[] heap;
    private int size;

    public MaxHeapByArray(int capacity) {
        this.heap = new int[capacity+1];
        this.heap[0] = Integer.MAX_VALUE;
        this.size = 0;
    }

    // Swap indices i and j from the heap array
    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // Maintains the min/max heap property
    private void heapifyDown(int k) {
        int largest = k;
        int leftIndex = 2 * k;
        int rightIndex = 2 * k + 1;

        if (leftIndex <= heap.length && heap[leftIndex] > heap[largest]) {
            largest = leftIndex;
        }

        if (rightIndex <= heap.length && heap[rightIndex] > heap[largest]) {
            largest = rightIndex;
        }

        if (largest != k) {
            swap(k, largest);
            heapifyDown(largest);
        }
    }

    private void heapifyUp(int k) {
        /*
        Compare if heap[size] value is greater than heap[size/2] and if so swap
        Then set the new k value to k/2
        This must relate to node as A[k] with its parent at Ak/2]
        I.e. check if a particular value is > than parent node. If so then swap it and then compare it to the next
        parent node
         */
        // Push just means add to the end of the array
        while (heap[k] > heap[k/2]) {
            swap(k , k/2);
            k = k/2;
        }
    }

    private void print(){
        for (int i = 1; i <= size/2; i++) {
            System.out.printf("Parent: %d, Left child: %d, Right child: %d %s", heap[i], heap[i*2], heap[i*2+1], System.lineSeparator());
        }
    }

    public void push(int x) {
        // Increment the size and store the value at the incremented index
        heap[++size] = x;
        heapifyUp(size);
    }

    public int pop() {
        int head = heap[1]; // Element we are popping - i.e. the root node
        heap[1] = heap[size--]; // Set the last element as head[1]
        heapifyDown(1);

        return head;
    }

    public int peek() {
        return heap[1]; // Show the first element - root node
    }

    public static void main(String[] args) {
        MaxHeapByArray maxHeap = new MaxHeapByArray(5);
        maxHeap.push(3);
        maxHeap.push(1);
        maxHeap.push(7);
        maxHeap.push(2);
        maxHeap.push(9);

        maxHeap.print();

        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.peek());
    }
}
