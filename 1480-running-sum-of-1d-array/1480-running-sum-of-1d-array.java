
class Solution {
    public int[] runningSum(int[] nums) {

        // Traverse from index 1
        for(int i = 1; i < nums.length; i++) {

            // Add previous sum
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }
}