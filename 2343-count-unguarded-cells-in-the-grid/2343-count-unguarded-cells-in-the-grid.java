class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        int totCells = n * m;

        for (int[] x : walls) {
            mat[x[0]][x[1]] = -1;
            totCells--;
        }
        for (int[] x : guards) {
            mat[x[0]][x[1]] = 1;
            totCells--;
        }

        int[][] dis = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int[] g : guards) {
            for (int[] d : dis) {
                int i = g[0] + d[0];
                int j = g[1] + d[1];
                while (i >= 0 && i < m && j >= 0 && j < n && mat[i][j] != -1 && mat[i][j] != 1) {
                    if (mat[i][j] == 0) {
                        mat[i][j] = 2;
                        totCells--;
                    }
                    i += d[0];
                    j += d[1];
                }
            }
        }

        return totCells;
    }
}