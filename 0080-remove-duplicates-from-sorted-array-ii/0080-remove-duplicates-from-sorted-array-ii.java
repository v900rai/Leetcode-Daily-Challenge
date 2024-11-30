class Solution {
    
    public int removeDuplicates(int[] nums) {
        // if(nums.length == 1) return 1;

        // int i = 0;
        // int count = 1;
        // for(int j=i+1; j<nums.length; j++){
        //     if(count<2 && nums[i]==nums[j]){
        //         i++;
        //         count++;
        //         nums[i] = nums[j];
        //     }else if(nums[i] !=nums[j]){
        //         i++;
        //         count=1;
        //         nums[i] = nums[j];
        //     }
        // }

        // return i+1;

        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;        
    }
}
    


        
    
