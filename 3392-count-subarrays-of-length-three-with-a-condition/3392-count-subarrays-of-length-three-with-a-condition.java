class Solution {
    public int countSubarrays(int[] nums) {
      int count =0;
      int i=0;
      int j=2;
      while(j<nums.length){
        int sum = nums[i]+nums[j];
        if(sum*2 == nums[i+1])
          count++;
        i++;
        j++;
      }
      return count;

        
    }
}