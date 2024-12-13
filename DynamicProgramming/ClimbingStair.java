package DynamicProgramming;

/**
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStair {
    
    public int climbStairs(int n) { 
        int[] dp = new int[n];
        return memoization(n, dp);
    } 

    int dynamicProgramming(int n) {
        if (n <= 1) {
            return 1; 
        }
        int prev1 = 1; 
        int prev2 = 1; 
        for (int i = 2; i < n + 1; i++) {
            int steps = prev1 + prev2; 
            prev1 = prev2;
            prev2 = steps;
        }
        return prev2;
    }

    int memoization(int n, int[] dp) {
        if (n <= 1) {
            return 1; 
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        int res = memoization(n - 1, dp) + memoization(n - 2, dp);
        dp[n] = res; 
        return res;
    }
}
