class Solution {
    public int majorityElement(int[] nums) {
      int condidate=nums[0];
      int count = 1;
       for(int i=0; i<nums.length; i++){
        if(nums[i] == condidate){
          count++;
        }
        else{
          count--;

          if(count == 0){
            condidate = nums[i];
            count = 1;
          }
        }
       }
       return condidate;
        
    }
}