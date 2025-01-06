
    class Solution {
    public int majorityElement(int[] nums) {
        int vishalrai=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                vishalrai=nums[i];
            }
            if(vishalrai==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return vishalrai;

    }
    }
