import java.util.Random;

/** 
 * Leetcode link: https://leetcode.com/problems/first-bad-version/description/
 
You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, 
all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1
 

Constraints:

1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {

    private int badVersion; 

    public FirstBadVersion(int n) {
        Random random = new Random(); 
        badVersion = random.nextInt(n);
    }

    public int findFirstBadVersion(int n) {
        int left = 0; 
        int right = n;

        while (left < right) { 
            // This is an optimization to prevent overflow
            // For example, int middle = (left + right) / 2, if left and right are 2 very large number (> 2^31)
            // It will cause overflow
            // It's better to calculate middle point as below left + (right - left) / 2
            int middle = left + (right - left)/ 2; 
            if (isBadVersion(middle)) {
                right = middle; 
            } else {
                left = middle + 1;
            }
        }
        return left;        
    }

    private boolean isBadVersion(int n) {
        return n == badVersion;
    }
}