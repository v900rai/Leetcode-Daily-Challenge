class Solution {
    public int majorityElement(int[] nums) {
      int count =1;
      int condidate = nums[0];

      for(int i=0; i<nums.length; i++){
        if(nums[0]==condidate){
          count=nums[i];
          count++;
        }
        else{
          count--;
          if(count == 0){
            condidate=nums[i];
            count=1;
          }
        }
        
      }
      return condidate;
        
    }
}