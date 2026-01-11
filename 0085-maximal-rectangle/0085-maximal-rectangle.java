class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] h = new int[n][m];
        int[][] dp = new int[n][m];

        int ans = 0;

        // First row initialization
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                h[0][j] = 1;
                dp[0][j] = (j > 0 ? dp[0][j - 1] : 0) + 1;
                ans = Math.max(ans, dp[0][j]);
            }
        }

        // Build height matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    h[i][j] = h[i - 1][j] + 1;
                } else {
                    h[i][j] = 0;
                }
            }
        }

        // DP computation
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    int width = 1;
                    int minHeight = h[i][j];
                    int maxArea = minHeight;

                    for (int k = j - 1; k >= 0 && matrix[i][k] == '1'; k--) {
                        minHeight = Math.min(minHeight, h[i][k]);
                        width++;
                        maxArea = Math.max(maxArea, minHeight * width);
                    }

                    dp[i][j] = maxArea;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}