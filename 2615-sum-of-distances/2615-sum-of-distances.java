import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        // Step 1: Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Process each group
        for (List<Integer> indices : map.values()) {

            int k = indices.size();

            // Prefix sum array
            long[] prefix = new long[k];
            prefix[0] = indices.get(0);

            for (int i = 1; i < k; i++) {
                prefix[i] = prefix[i - 1] + indices.get(i);
            }

            long total = prefix[k - 1];

            // Step 3: Calculate distance for each index
            for (int j = 0; j < k; j++) {
                int idx = indices.get(j);

                // Left contribution
                long left = (long) idx * j - (j > 0 ? prefix[j - 1] : 0);

                // Right contribution
                long right = (total - prefix[j]) - (long) (k - j - 1) * idx;

                res[idx] = left + right;
            }
        }

        return res;
    }
}