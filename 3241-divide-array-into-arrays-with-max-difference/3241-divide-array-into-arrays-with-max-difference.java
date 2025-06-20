// Solution class to divide an array into subarrays of size 3 with a maximum difference constraint
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length; // Get the length of the input array

        // Sort the array to easily find the minimum and maximum in each triplet
        Arrays.sort(nums);

        // Initialize the result array with n/3 rows and 3 columns
        int[][] result = new int[n / 3][3];
        int index = 0; // Index to track the current row in the result array

        // Iterate through the sorted array in steps of 3
        for (int i = 0; i <= n - 3; i += 3) {
            // Check if the difference between the max and min in the current triplet exceeds k
            if (nums[i + 2] - nums[i] > k) {
                // If the condition is violated, return an empty array
                return new int[0][0];
            }

            // Add the current triplet to the result array
            result[index++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }

        // Return the result array if all triplets satisfy the condition
        return result;
    }
}
