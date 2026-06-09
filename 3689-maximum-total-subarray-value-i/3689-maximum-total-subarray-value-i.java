class Solution {
    public long maxTotalValue(int[] nums, int k) {

        // Initialize minimum and maximum with the first element
        int mn = nums[0];
        int mx = nums[0];

        // Traverse the array to find the minimum and maximum values
        for (int x : nums) {

            // Update minimum value if current element is smaller
            mn = Math.min(mn, x);

            // Update maximum value if current element is larger
            mx = Math.max(mx, x);
        }

        // Calculate the answer:
        // (maximum element - minimum element) * k
        // 1L is used to convert the result to long and avoid integer overflow
        return 1L * (mx - mn) * k;
    }
}