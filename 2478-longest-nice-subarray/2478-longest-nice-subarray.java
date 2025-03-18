class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i = 0, j = 0;
        int result = 1;
        int mask = 0;
        
        while (j < nums.length) {
            while ((mask & nums[j]) != 0) {
                mask ^= nums[i];
                i++;
            }
            
            result = Math.max(result, j - i + 1);
            mask |= nums[j];
            j++;
        }
        
        return result;
    }
}
