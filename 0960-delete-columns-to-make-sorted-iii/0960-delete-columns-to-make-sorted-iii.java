class Solution {
    public int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();

        int[] dp = new int[cols];
        int max = 1;

        // Step 1: initialize
        for (int j = 0; j < cols; j++) {
            dp[j] = 1;
        }

        // Step 2: LIS on columns
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < j; i++) {

                boolean valid = true;

                // check all rows
                for (int r = 0; r < rows; r++) {
                    if (strs[r].charAt(i) > strs[r].charAt(j)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }

        // Step 3: minimum deletions
        return cols - max;
    }
}
