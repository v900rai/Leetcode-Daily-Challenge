class Solution {
    public int maxAscendingSum(int[] nums) {
        // initialize the current sum and maxsum
        int currentSum=nums[0];
        int maxSum=currentSum;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                currentSum=currentSum+nums[i];
            }
            else {
                // start the new sub arrays 
                currentSum=nums[i];
            }
            maxSum=Math.max(maxSum, currentSum);
        }
        return maxSum;
        
    }
}