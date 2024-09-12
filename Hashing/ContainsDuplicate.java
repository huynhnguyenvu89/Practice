package Hashing;

import java.util.HashMap;

/**
Given an integer array nums, return true if any value appears at least twice in the array, 
and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (map.get(n) != null) {
                return true;
            }
            map.put(n, true);
        }
        return false;
    }
}
