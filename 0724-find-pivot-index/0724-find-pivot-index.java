class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;

        int[] pre = new int[n];
        pre[0] = 0; // 0th index ke left me kuch nhi hai

        // Step 1: Create prefix sum array
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        // Step 2: Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 3: Check pivot index
        for (int i = 0; i < n; i++) {
            int leftSum = pre[i];
            int rightSum = totalSum - nums[i] - leftSum;

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1; // No pivot index found
    }
}
