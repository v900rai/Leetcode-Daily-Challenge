class Solution {
    public int minimumCost(int[] nums) {
        int minimumSum=0;
        minimumSum+=nums[0];
        int miniFirst=Integer.MAX_VALUE;
        int miniSecond=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=miniFirst){
                miniSecond=miniFirst;
                miniFirst=nums[i];
            }else if(nums[i]>miniFirst && nums[i]<miniSecond){
                miniSecond=nums[i];
            }
        }
        return minimumSum+miniSecond+miniFirst;
    }
}