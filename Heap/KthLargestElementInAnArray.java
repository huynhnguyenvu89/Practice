package Heap;

import java.util.PriorityQueue;

/**
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);

            if (minHeap.size() > k) {
                minHeap.remove();
            }
        } 
        return minHeap.peek();
    }
}
