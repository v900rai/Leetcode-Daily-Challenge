class Solution {
  public int threeSumClosest(int[] nums, int target) {
   
    int len = nums.length;
    
    int sum = 0;

    // First 3 elements ka sum initial closest answer maan liya
    int closestSum = nums[0] + nums[1] + nums[2];

    // First element choose kar rahe hain
    for (int i = 0; i < len - 2; i++) {

      // Second element choose kar rahe hain
      for (int j = i + 1; j < len - 1; j++) {

        // Third element choose kar rahe hain
        for (int k = j + 1; k < len; k++) {

          // Current triplet ka sum
          sum = nums[i] + nums[j] + nums[k];

          // Agar current sum target ke aur paas hai
          if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
            closestSum = sum;
          }
          
        }
      }
    }

    return closestSum;
  }
}