class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        // result = min |i - start| where nums[i] == target
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }

        return result;
    }
}
