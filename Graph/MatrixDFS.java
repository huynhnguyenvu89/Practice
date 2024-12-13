package Graph;

public class MatrixDFS {
    
    // Count paths recursively (backtracking)
    public int dfs(int[][] grid, int r, int c, int[][] visit) {
        int ROWS = grid.length;
        int COLUMNS = grid[0].length; 

        if (Math.min(r, c) < 0 
        || r >= ROWS 
        || c >= COLUMNS 
        || visit[r][c] != 0 
        || grid[r][c] == 1) {
            return 0;
        }
        if (r == ROWS - 1 && c == COLUMNS - 1) {
            return 1; 
        }

        visit[r][c] = 1;
        int uniquePath = 0; 
        uniquePath += dfs(grid, r - 1, c, visit);
        uniquePath += dfs(grid, r + 1, c, visit);
        uniquePath += dfs(grid, r, c + 1, visit);
        uniquePath += dfs(grid, r, c - 1, visit);
        visit[r][c] = 0;

        return uniquePath;
    }
}
