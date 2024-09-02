package Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;
    
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        int n = heap.size(); 
        heap.add(n, val);
        bubbleUp(n);
    }

    public Integer top() {
        if (heap.size() > 1) {
            return heap.get(1);
        } else {
            return -1;
        }
    }
    
    public Integer pop() { 
        if (heap.size() <= 1) {
            return -1; 
        }
        if (heap.size() == 2) {
            return heap.remove(2);
        }

        // The current min value
        int res = heap.get(1);
        // Add the last element in the heap to the top temporarily
        heap.add(1, heap.get(heap.size() - 1));
        // Remove the last element in the heap, as we don't have it anymore
        heap.remove(heap.size() - 1);

        if (heap.size() > 1) {
            bubbleDown(1);
        }

        return res;
    }

    public void heapify(List<Integer> nums) {
        this.heap = new ArrayList<>();
        heap.add(0);
        heap.addAll(nums);
        for (int i = heap.size() / 2; i >= 1; i--) {
            bubbleDown(i);
        }
    }

    private void bubbleDown(int n) {
        int child = n * 2; 

        while (child < heap.size()) {
            if (child + 1 < heap.size() && heap.get(child) > heap.get(child + 1)) {
                child++;
            }

            if (heap.get(n) <= heap.get(child)) {
                break;
            }

            int temp = heap.get(n);
            heap.add(n, heap.get(child));
            heap.add(child, temp);

            n = child;
            child = n * 2;
        }
    }

    private void bubbleUp(int n) {
        int parent = n / 2;
        while (parent > 1 && heap.get(parent) > heap.get(n)) {
            int temp = heap.get(parent);
            heap.add(parent, heap.get(n));
            heap.add(n, temp);
            n = parent; 
            parent = n / 2;
        }
    }
}
