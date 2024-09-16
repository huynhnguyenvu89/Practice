package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatrixBFS {
    
    // Matrix (2D Grid)
    int[][] grid = {{0, 0, 0, 0},
                    {1, 1, 0, 0},
                    {0, 0, 0, 1},
                    {0, 1, 0, 0}};

    // Shortest path from top left to bottom right
    public int bfs(int[][] grid) {
        int ROWS = grid.length; 
        int COLUMNS = grid[0].length;

        if (ROWS == 0 || COLUMNS == 0) {
            return 0;
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[2]);
        int[][] visit = new int[ROWS][COLUMNS];
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();

            for (int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];
                if (r == ROWS - 1 && c == COLUMNS - 1) {
                    return length;
                }
                
                int[][] neighbors = new int[][] {
                    {r + 1, c}, {r - 1, c}, {r, c - 1}, {r, c + 1} 
                };
                
                for (int j = 0; j < neighbors.length; j++) {
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];
                    if (newR < 0 || newC < 0 || newR >= ROWS || newC >= COLUMNS || grid[newR][newC] == 1 || visit[newR][newC] == 1) {
                        continue;
                    } else {
                        visit[newR][newC] = 1;
                        queue.add(neighbors[j]);
                    }
                }
                
            }
            length++;
        }
        return length;
    }
}
