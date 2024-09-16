package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ROWS = grid.length; 
        int COLUMNS = grid[0].length;
        int fresh = 0; 
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        
        int minute = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int queueLength = queue.size();
            minute += 1;

            for (int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                int[][] neighbors = new int[][] {
                    {r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}
                };
                for (int j = 0; j < neighbors.length; j++) {
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];
                    if (newR < 0 || newC < 0 
                    || newR >= ROWS || newC >= COLUMNS 
                    || grid[newR][newC] != 1) {
                        continue;
                    }
                    
                    grid[newR][newC] = 2;
                    queue.add(new int[] {newR, newC});
                    fresh--;
                }
            }
        }
        if (fresh == 0) {
            return minute;
        } else {
            return -1;
        }
    }
}
