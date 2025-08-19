class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        
        int n = nums.length;
        
        long countSubArray = 0;
        
        for (int i = 0; i < n; i++) {
            
            if (nums[i] == 0)
                countSubArray =countSubArray + 1;
            else
                countSubArray = 0;
            
            result += countSubArray;
        }
        
        return result;
    }
}