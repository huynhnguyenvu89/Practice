package Graph;

/**
You are given an m x n binary matrix grid. An island is a group of 1's 
(representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0; 

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                int area = getIslandArea(i, j, grid); 
                if (max < area) {
                    max = area;
                }
            }
        }
        return max; 
    }    

    private int getIslandArea(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == 0) {
            return 0; 
        }

        int area = 1; 
        grid[r][c] = 0;
        area += getIslandArea(r - 1, c, grid);
        area += getIslandArea(r + 1, c, grid);
        area += getIslandArea(r, c + 1, grid);
        area += getIslandArea(r, c - 1, grid);

        return area; 
    }
}
