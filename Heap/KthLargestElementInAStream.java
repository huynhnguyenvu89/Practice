package Heap;

import java.util.ArrayList;

public class KthLargestElementInAStream {
    
    private ArrayList<Integer> minHeap;
    private int maxSize;

    public KthLargestElementInAStream(int k, int[] nums) {
        maxSize = k;
        minHeap = new ArrayList<>();
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < maxSize) {
            minHeap.add(val);
            bubbleUp(minHeap.size() - 1);
        } else if (val > minHeap.get(0)) {
            minHeap.set(0, val);
            bubbleDown(0);
        }
        return minHeap.get(0);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (minHeap.get(parent) > minHeap.get(index)) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        int size = minHeap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && minHeap.get(left) < minHeap.get(smallest)) {
                smallest = left;
            }
            if (right < size && minHeap.get(right) < minHeap.get(smallest)) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }
}
