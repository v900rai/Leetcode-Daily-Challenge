class Solution {

    public int numIslands(char[][] grid) {

        // Edge case
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        // Traverse whole grid
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // If land found
                if (grid[i][j] == '1') {

                    count++; // New island found

                    // Visit all connected lands
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // DFS function
    public void dfs(char[][] grid, int row, int col) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check
        // Water check
        if (row < 0 || col < 0 || row >= rows || col >= cols
                || grid[row][col] == '0') {

            return;
        }

        // Mark visited
        grid[row][col] = '0';

        // Explore 4 directions
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }
}