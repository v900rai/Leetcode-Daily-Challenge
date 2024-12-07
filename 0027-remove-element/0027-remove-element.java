class Solution {
    public int removeElement(int[] nums, int val) {
       int count=0;
       for(int i=0; i<nums.length; i++){
        if(nums[i]!=val){
            nums[count]=nums[i];
            count++;
        }
       }
       return count;

    }
}

//  int writeIndex = 0;
//         for (int readIndex = 0; readIndex < nums.length; readIndex++) {
//             if (nums[readIndex] != val) {
//                 nums[writeIndex] = nums[readIndex];
//                 writeIndex++;
//             }
//         }
//         return writeIndex;