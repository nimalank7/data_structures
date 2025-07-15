package org.example.postgressort;

import java.util.*;

public class TopNHeapSort {
    public static List<Integer> topNLargest(List<Integer> input, int n) {
        // Sanity checking
        if (n <= 0 || input == null || input.isEmpty()) return Collections.emptyList();

        // Min-heap to keep track of top N elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);

        for (int num : input) {
            if (heap.size() < n) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();        // Remove smallest in heap
                heap.offer(num);    // Insert new candidate
            }
        }

        // To return sorted result (largest to smallest)
        List<Integer> result = new ArrayList<>(heap);
        result.sort(Comparator.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(8, 1, 5, 10, 3, 7, 6, 9, 4, 2);
        int topN = 3;

        List<Integer> topElements = topNLargest(data, topN);
        System.out.println("Top " + topN + " elements: " + topElements);
    }
}
