class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 2];
        dp[0] = poured;
        
        for (int i = 0; i < query_row; i++) {
            for (int j = i; j >= 0; j--) {
                
                double spill = Math.max(0, dp[j] - 1);
                
                dp[j] = spill / 2;         // left child (next row)
                dp[j + 1] += spill / 2;    // right child (next row)
            }
        }
        
        return Math.min(1, dp[query_glass]);
    }
}