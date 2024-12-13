package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. 
If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return -1; 
        }
        int ROWS = grid.length; 
        int COLUMNS = grid[0].length;

        int[][] visit = new int[ROWS][COLUMNS];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        visit[0][0] = 1;
        int length = 1;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();

            for(int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if (r == ROWS - 1 && c == COLUMNS - 1) {
                    return length;
                }

                int[][] neighbors = new int[][] {
                    {r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1},
                    {r + 1, c + 1}, {r - 1, c + 1}, {r + 1, c - 1}, {r - 1, c - 1}
                };
                for (int j = 0; j < neighbors.length; j++) {
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];

                    if (Math.min(newR, newC) < 0 || newR >= ROWS || newC >= COLUMNS || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }
                    visit[newR][newC] = 1;
                    queue.add(neighbors[j]);
                }
            }
            length++;
        }


        return -1; 
    }
}
