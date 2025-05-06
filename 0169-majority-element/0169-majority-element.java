class Solution {
  public int majorityElement(int[] nums) {
    int candidate = nums[0]; // Initialize candidate
    int count = 1; // Start count at 1 since we're including nums[0]

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == candidate) {
        count++; // Same as candidate, increase count
      } else {
        count--; // Different, decrease count
        if (count == 0) {
          candidate = nums[i]; // Change candidate
          count = 1; // Reset count
        }
      }
    }
    return candidate;
  }
}
