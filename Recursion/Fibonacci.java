package Recursion;

public class Fibonacci {
    
    /**
     * Recursive implementation to calculate the n-th Fibonacci number
     * @param n
     * @return
     */
    public int answer(int n) {
        if (n <= 1) {
            return 1; 
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        return helper(dp, n);
    }

    private int helper(int[] dp, int n) {
        int val = dp[n];
        if (val != 0) {
            return val;
        }
        int res = helper(dp, n - 1) + helper(dp, n - 2);
        dp[n] = res;
        return res;
    } 
}
