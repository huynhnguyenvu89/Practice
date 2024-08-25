package Sorting;

import java.util.List;

public class QuickSort {

    public class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public List<Pair> quickSort(List<Pair> pairs) {
        return helper(pairs, 0, pairs.size() -1);
    }
    
    private List<Pair> helper(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        Pair pivot = pairs.get(end);
        int i = start; 

        for (int index = start; index < end; index++) {
            int value = pairs.get(index).key;
            // If found a value less than pivot value, 
            // Perform swap with the Pair at i index
            if (value < pivot.key) {
                Pair temp = pairs.get(i);
                pairs.add(i, pairs.get(index));
                pairs.add(index, temp);
                i++;
            }
        }

        // Swap the pivot (at the last in list), with the current i
        // This is where the pivot is supposed to be when the list is sorted
        pairs.add(end, pairs.get(i));
        pairs.add(i, pivot);
        System.out.println("<VH> Size " + pairs.size());

        // Call quick sort recursively on the 2 partition left and right
        helper(pairs, start, i - 1);
        helper(pairs, i + 1, end);
        return pairs;
    }
}
