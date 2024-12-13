package DynamicProgramming;

public class CountPath {
    
    int bruteForce(int r, int c, int rows, int columns) {
        if (r >= rows || c >= columns) {
            return 0;
        }
        if (r == rows - 1 && c == columns - 1) {
            return 1;
        }

        return bruteForce(r + 1, c, rows, columns) + bruteForce(r, c + 1, rows, columns);
    }

    int memoization(int r, int c, int rows, int columns, int[][] cache) {
        if (r >= rows || c >= columns) {
            return 0;
        }
        if (cache[r][c] > 0) {
            return cache[r][c];
        }
        if (r == rows - 1 && c == columns - 1) {
            return 1;
        }
        cache[r][c] = memoization(r + 1, c, rows, columns, cache) + memoization(r, c + 1, rows, columns, cache);
        return cache[r][c];
    }

    int dynamicProgrammingApproach(int r, int c) {
        int[] prevRow = new int[c];
        for (int i = 0; i < c; i++) {
            prevRow[i] = 1;
        }

        for (int i = r - 1; i >= 0; i--) {
            int[] currRow = new int[c];
            currRow[c - 1] = 1;
            for (int j = c - 2; j >= 0; j--) {
                currRow[j] = currRow[j + 1] + prevRow[j];
            }
            prevRow = currRow;
        }
        return prevRow[0];
    }
}
