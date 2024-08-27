package Recursion;

public class Factorial {
    
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return helper(dp, n);
    }

    private int helper(int[] dp, int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] == 0) {
            int val = helper(dp, n - 1) * n;
            dp[n] = val;
            return val;
        } 
        return dp[n];
    }
}
