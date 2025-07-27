package org.example.sorting;

import java.util.Arrays;

public class CountingSort {

    static int[] countElements(int[] input, int k) {
        int[] c = new int[k + 1];
        Arrays.fill(c, 0);

        // O(n) time
        for (int i : input) {

            c[i] += 1;
        }

        // O(k) time as c is length k
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // Return 'cumulative frequency' array
        return c;
    }

    static int[] sort(int[] input, int k) {
        // Takes O(n + k) in total
        int[] c = countElements(input, k);

        // Create sorted array
        int[] sorted = new int[input.length];

        /*
        Iterate through input array in reverse
        Takes O(n) time
         */
        for (int i = input.length - 1; i >= 0; i--) {
            int current = input[i];
            // Index into 'cumulative frequency' array
            sorted[c[current] - 1] = current;
            // Decrement 'cumulative frequency' array
            c[current] -= 1;
        }

        return sorted;
    }

    public static void main(String[] args) {
        /*
        countElements takes O(n + k)
        sort takes O(n)
        So in total O(n +k) + O(n) = O(2n + k) = O(n + k)
         */

        int[] input = { 4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5 };
        // [0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5]
        System.out.println(Arrays.toString(CountingSort.sort(input, 5)));
    }
}
