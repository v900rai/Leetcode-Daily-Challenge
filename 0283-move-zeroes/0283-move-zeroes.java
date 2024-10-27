class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (left != right) {  // Only swap if left and right are different
                    nums[left] = nums[right];
                    nums[right] = 0; // Set right to zero since we moved the non-zero element
                }
                left++; // Move the left pointer
            }
        }
    }
}
