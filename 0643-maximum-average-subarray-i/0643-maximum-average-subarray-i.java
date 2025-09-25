class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window of size k
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum=sum+nums[i];
        }
        // Initialize maxSum as the sum of the first window
        int maxSum = sum; //lotal sum k maxSum m dal do

        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i]; // Remove the first element of the previous window, add the next element
            maxSum = Math.max(maxSum, sum);   // Update maxSum if the new sum is larger
        }
        
        // Return the maximum average
        return maxSum / (double) k;
    }
}
