package DynamicProgramming;

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
each of them is that adjacent houses have security systems connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobber {
    
    // If the array has 0 element -> return 0; 
    // if the array has 1 element -> max is the element
    // if the array has 2 element -> Max between 2 options: start from 2 or start from 1
    // if the array has 3 element -> Max between 2 options: start from 3 vs start from 2
    // If the array has 4 element -> Max between 2 options: start from 4 or start from 3
    // We can have a helper function 
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] cache = new int[nums.length];
        int res = memoization(nums.length - 1, nums, cache);
        return res;
    }

    int dynamicProgramming(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int max1 = nums[0];
        int max2 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(nums[i] + max1, max2);
            max1 = max2;
            max2= max;
        }
        return Math.max(max1, max2);
    }

    int memoization(int n, int[] nums, int[] cache) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return nums[0];
        } else if (n == 1) {
            return Math.max(nums[0], nums[1]);
        } else if (cache[n] > 0) {
            return cache[n];
        }

        int res = Math.max(
            nums[n] + memoization(n - 2, nums, cache),
            memoization(n - 1, nums, cache)
        );
        cache[n] = res; 
        return res;
    }

    int bruteForce(int n, int[] nums) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return nums[0];
        } else if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        int option1 = nums[n] + bruteForce(n - 2, nums);
        int option2 = bruteForce(n - 1, nums);
        
        return Math.max(option1, option2);
    }
}
