class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0; // To count the number of good pairs
        int n = nums.length;

        // Iterate through all pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // Check if both conditions are satisfied:
                // 1. nums[i] == nums[j]
                // 2. (i * j) % k == 0
                if (nums[i] == nums[j] && ((i * j) % k == 0)) {
                    count++; // Valid good pair found
                }
            }
        }

        return count; // Return total good pairs
    }
}
