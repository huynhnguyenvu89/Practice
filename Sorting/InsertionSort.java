package Sorting;

public class InsertionSort {
    
    /**
     * Insertion sort: Given the array [2,3,4,1,6], our goal is to sort the array so that it looks like [1,2,3,4,6].
     * - Concept: 
     * We want to loop through the given array, if we find an element that's in out of order 
     * (less than the element before it)
     * Then we perform a swap (an insertion) to find where to insert the element in the sorted portion of the array 
     * 
     * - Stability: 
     * This is a stable sorting algorithm
     * 
     * - Time and Space complexity:
     * It only require space for the swapping logic, so space complexity is 0(1)
     * We have to loop through the array, and insert the out of order element, so in the worst case, it's 0(n2)
     */
    public int[] implementation(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        for (int i = 1; i < input.length; i++) {
            int j = i - 1;

            while (j >= 0 && input[j] > input[j + 1]) {
                int temp = input[j + 1]; 
                input[j + 1] = input[j];
                input[j] = temp; 
                j--;
            }
        }

        return input; 
    }
}
