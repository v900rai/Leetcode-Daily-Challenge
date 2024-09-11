
       class Solution {
    public int majorityElement(int[] nums) {
        int condidate=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                condidate=nums[i];
            }
            if(condidate==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return condidate;
    }
       }
