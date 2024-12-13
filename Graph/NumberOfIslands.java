package Graph;

/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally
or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i ++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    total += 1;
                    markAsLand(i, j, grid);
                }
            }
        } 
        return total;   
    }

    private void markAsLand(int r, int c, char[][] grid) {
        if (r < 0 
        || c < 0 
        || r > grid.length - 1 
        || c > grid[0].length - 1
        || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        markAsLand(r - 1, c, grid);
        markAsLand(r + 1, c, grid);
        markAsLand(r, c + 1, grid);
        markAsLand(r, c - 1, grid);
    }
}
