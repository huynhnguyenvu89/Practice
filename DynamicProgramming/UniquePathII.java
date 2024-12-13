package DynamicProgramming;

/**
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePathII {

    int dynamicProgrammingApproach(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        
        if (obstacleGrid[rows - 1][columns - 1] == 1) {
            return 0;
        }
        
        int[] prevRow = new int[columns];

        for (int i = rows - 1; i >= 0; i--) {
            int[] currRow = new int[columns];
            
            for (int j = columns - 1; j >= 0; j--) {
                if (i == rows - 1 && j == columns - 1) {
                    currRow[j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    currRow[j] = 0;
                } else if (j == columns - 1) {
                    currRow[j] = prevRow[j];
                } else {
                    currRow[j] = prevRow[j] + currRow[j + 1];
                }
            }
            prevRow = currRow;
        }
        return prevRow[0];
    }
    
    int bruteForce(int r, int c, int rows, int columns, int[][] obstacleGrid) {
        if (r >= obstacleGrid.length || c >= obstacleGrid[0].length) {
            return 0;
        }
        if (obstacleGrid[r][c] == 1) {
            return 0;
        }
        if (r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            return 1; 
        }
        return bruteForce(r + 1, c, rows, columns, obstacleGrid) + bruteForce(r, c + 1, rows, columns, obstacleGrid);
    }

    int memoization(int r, int c, int rows, int columns, int[][] obstacleGrid, int[][] cache) {
        if (r >= obstacleGrid.length || c >= obstacleGrid[0].length) {
            return 0; 
        }
        if (obstacleGrid[r][c] == 1) {
            return 0;
        }
        if (cache[r][c] > 0) {
            return cache[r][c];
        }
        if (r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            return 1;
        }

        int res = memoization(r + 1, c, rows, columns, obstacleGrid, cache) + memoization(r, c + 1, rows, columns, obstacleGrid, cache);
        cache[r][c] = res;
        return cache[r][c];
    }
}
