class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return nums;
        }
        int temp=0;
        int index=0;
        for(int i=0; i<nums.length; i++){
            // check if a number is even and swap it to 0 index. 
            if(nums[i]%2==0){
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return nums;
    }
}