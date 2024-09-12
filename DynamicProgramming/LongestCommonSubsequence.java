package DynamicProgramming;

/**
Given two strings text1 and text2, return the length of their longest common subsequence. 
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters
(can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length();
        int columns = text2.length();
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();
        int[][] dp = new int[rows + 1][columns + 1];
        return memoization(0, 0, dp, array1, array2);
    }

    int dynamicProgramming(String text1, String text2) {
        int[] prevRow = new int[text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            int[] currRow = new int[text2.length() + 1];
            for (int j = text2.length() - 1; j >= 0; j--) {
                int res = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    res = 1 + prevRow[j + 1];
                } else {
                    res = Math.max(prevRow[j], currRow[j + 1]);
                }
                currRow[j] = res;
            }
            prevRow = currRow;
        }
        return prevRow[0];
    }

    int memoization(int r, int c, int[][] cache, char[] array1, char[] array2) {
        if (r == array1.length || c == array2.length) {
            return 0;
        }
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        int res = 0; 
        if (array1[r] == array2[c]) {
            res = 1 + memoization(r + 1, c + 1, cache, array1, array2);
        } else {
            res = Math.max(memoization(r + 1, c, cache, array1, array2), memoization(r, c + 1, cache, array1, array2));
        }
        cache[r][c] = res;
        return res;
    }

    int bruteForce(int r, int c, char[] array1, char[] array2) {
        // If out of bound
        if (r == array1.length || c == array2.length) {
            return 0;
        }
        char r1 = array1[r];
        char c1 = array2[c];
        if (r1 == c1) {
            return 1 + bruteForce(r + 1, c + 1, array1, array2);
        } else {
            return Math.max(
                bruteForce(r + 1, c, array1, array2), 
                bruteForce(r, c + 1, array1, array2));
        }
    }
}
