
import java.util.*;

class Solution {
    public int matrixSum(int[][] grid) {

        int m = grid.length;      // number of rows
        int n = grid[0].length;   // number of columns

        // Step 1: Sort each row
        for(int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int sum = 0;

        // Step 2: Column-wise maximum
        for(int col = 0; col < n; col++) {

            int max = 0;

            for(int row = 0; row < m; row++) {
                max = Math.max(max, grid[row][col]);
            }

            sum += max;
        }

        return sum;
    }
}