class Solution {
    public int maxSubArray(int[] nums) {
      int courrent =0;
      int max=Integer.MIN_VALUE;
      for(int i=0; i<nums.length; i++){
        courrent+=nums[i];
        max=Math.max(courrent, max);
        if(courrent<0){
          courrent=0;
        }
      }
      return max;
        
    }
}