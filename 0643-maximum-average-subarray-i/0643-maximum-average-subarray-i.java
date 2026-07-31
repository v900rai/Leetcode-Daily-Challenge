class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int sum = 0;

    // 🔹 first window sum
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    // // first window sum 
    // for (int i = 0; i < k; i++) {
    //   sum = sum + nums[i];
    // }

    //int maxSum = sum;
    int maxSum = sum;

    // 🔹 slide the window
    // for (int i = k; i < nums.length; i++) {

    //   sum += nums[i]; // right se add
    //   sum = sum - nums[i - k]; // left se remove

    //   maxSum = Math.max(maxSum, sum);
    // }
    // slid the window 
    for (int i = k; i < nums.length; i++) {
      sum = sum + nums[i];
      sum = sum - nums[i - k];// 
      maxSum = Math.max(maxSum, sum);
    }

    // 🔹 average = maxSum / k
    //return (double) maxSum / k;

    return (double) maxSum /k;
  }

}