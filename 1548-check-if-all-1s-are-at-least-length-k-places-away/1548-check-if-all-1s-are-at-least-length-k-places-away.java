class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int lastOne = -(k + 1);  // So the first 1 always passes the distance check

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (i - lastOne - 1 < k) {
                    return false;
                }
                lastOne = i;
            }
        }
        
        return true;
    }
}