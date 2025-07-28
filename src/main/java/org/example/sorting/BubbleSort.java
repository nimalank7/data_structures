package org.example.sorting;

import java.util.Arrays;

public class BubbleSort {
    static void bubbleSort(int[] arr) {
        boolean swapNeeded = true;
        /*
        Worst case scenario is when the sort is in reverse order so O(n * n)
         */
        for (int i = 0; i < arr.length - 1 && swapNeeded; i++) {
            swapNeeded = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                }
            }

            /*
            Best case scenario is when the inner loop runs once - so O(n)
             */
            if(!swapNeeded) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 6, 3, 5};
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));

        int[] existingSort = {1, 2, 3, 4, 5, 6};
        BubbleSort.bubbleSort(existingSort);
        System.out.println(Arrays.toString(existingSort));
    }
}
