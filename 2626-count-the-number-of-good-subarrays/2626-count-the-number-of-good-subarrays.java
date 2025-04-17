class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0; // Two pointers for sliding window

        long result = 0;  // Final result to store the number of good subarrays
        long pairs = 0;   // To count the number of pairs in the current window

        Map<Integer, Integer> map = new HashMap<>(); // Frequency map to store element counts in the window

        // Iterate through the array with the right pointer `j`
        while (j < n) {
            // Each new occurrence of nums[j] will form 'map[nums[j]]' pairs
            pairs += map.getOrDefault(nums[j], 0);

            // Update frequency map for current number
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Try to shrink the window from the left while the condition is satisfied
            while (pairs >= k) {
                // All subarrays from [i, j] to [i, n-1] are valid
                result += (n - j);

                // Before moving `i`, reduce the count of nums[i] and adjust pairs
                map.put(nums[i], map.get(nums[i]) - 1);

                // Decrement pairs by the number of remaining same elements as nums[i]
                pairs -= map.get(nums[i]);

                // Move left pointer forward
                i++;
            }

            // Move right pointer forward
            j++;
        }

        return result; // Return the count of good subarrays
    }
}
