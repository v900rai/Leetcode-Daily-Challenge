class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
       int num=0;
       for(int i=1;i<nums.length;i++){
          if(nums[i]==nums[i-1]){
            num=nums[i];
          }
       }

       return num;
    }
}