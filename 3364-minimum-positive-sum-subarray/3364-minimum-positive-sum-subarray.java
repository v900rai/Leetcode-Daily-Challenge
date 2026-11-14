
import java.util.*;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        // Build prefix sum array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        // Try every possible starting index
        for (int i = 0; i < n; i++) {

            // Try subarray lengths from l to r
            for (int len = l; len <= r && i + len <= n; len++) {

                int sum = prefix[i + len] - prefix[i];

                // Find minimum positive sum
                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
