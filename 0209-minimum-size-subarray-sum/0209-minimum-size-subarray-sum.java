class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            
            while (currentSum >= target) {
                minLength = Math.min(minLength, i - count + 1);
                currentSum -= nums[count];
                count++;
            }
        }
        
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}