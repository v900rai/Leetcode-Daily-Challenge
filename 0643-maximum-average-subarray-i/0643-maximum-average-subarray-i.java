class Solution {
    public double findMaxAverage(int[] nums, int k) {
     int sum = 0;

        // 🔹 first window sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // 🔹 slide the window
        for (int i = k; i < nums.length; i++) {

            sum += nums[i];      // right se add
            sum -= nums[i - k];  // left se remove

            maxSum = Math.max(maxSum, sum);
        }

        // 🔹 average = maxSum / k
        return (double) maxSum / k;
    }

    
}