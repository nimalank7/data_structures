package org.example.postgressort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int arrayLength = arr.length;

        // Step 1: Build max heap
        for (int i = arrayLength / 2 - 1; i >= 0; i--) {
            heapify(arr, arrayLength, i);
        }

        // Step 2: Extract elements one by one
        for (int i = arrayLength - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Maintains the heap property for a subtree rooted at index i
    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;         // root
        int left = 2 * i + 1;    // left child
        int right = 2 * i + 2;   // right child

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than current largest
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If root is not largest, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Demo
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7 };
        System.out.println("Original array:");
        printArray(array);

        heapSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
