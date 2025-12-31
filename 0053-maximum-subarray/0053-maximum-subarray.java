class Solution {
    public int maxSubArray(int[] nums) {
      int sum = 0;
      int maxSum =nums[0];
      for(int i=0; i<nums.length; i++){
        sum =sum+nums[i];
        maxSum = Math.max(maxSum ,sum);
        if(sum<0){
          sum = nums[i];
        }
      }
      return maxSum;
        
    }
}