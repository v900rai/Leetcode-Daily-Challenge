class Solution {
    public int missingNumber(int[] nums) {

      int ans =0;
      for(int i=0; i<=nums.length; i++){
        ans =ans^i; // both are same then zero 
      }

      for(int i=0; i< nums.length; i++){
        ans = ans^nums[i];
      }
        return ans;
    }
}