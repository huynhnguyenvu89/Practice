package Recursion;

import java.util.Arrays;

public class ClimbingStairs {
    
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i < n; i++) {
            int val = prev + prev2;
            prev2 = prev;
            prev = val;
        }
        return prev; 
    }

    public int climbStairsRecursive(int n) {
        if (n <= 2) {
            return n; 
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return helper(dp, n);
    }

    private int helper(int[] dp, int n) {
        int val = dp[n];
        if (val > -1) {
            return val;
        } 
        int res = helper(dp, n- 1) + helper(dp, n - 2);
        dp[n] = res; 
        return res;
    }
}
