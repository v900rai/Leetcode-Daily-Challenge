class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        // Step 1: Calculate total sum
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Sum of the subarray we want to keep
        int target = totalSum - x;

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        // If target == 0, we have to remove all elements
        if (target == 0) {
            return n;
        }

        int left = 0;
        int currentSum = 0;
        int maxLength = -1;

        // Step 2: Find longest subarray with sum = target
        for (int right = 0; right < n; right++) {

            currentSum += nums[right];

            // Shrink window if sum becomes greater than target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Found a subarray with required sum
            if (currentSum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        // No valid subarray
        if (maxLength == -1) {
            return -1;
        }

        // Remove everything outside the longest subarray
        return n - maxLength;
    }
}