class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] colX = new int[n];
        int[] colY = new int[n];
        int res = 0;


        for(int i = 0; i < m; ++i) {
          for(int j = 0; j < n; ++j) {
            char g = grid[i][j];
            if(g != '.') {
              colX[j] += 'Y' - g;
              colY[j] += g - 'X';
            }
          }
            
          int x = 0, y = 0;
          for(int j = 0; j < n; ++j) {

            x += colX[j];
            y += colY[j];

            if(x == y && x > 0) ++res;
          }
        }

        return res;
    }
}