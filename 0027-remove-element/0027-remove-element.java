class Solution {
    public int removeElement(int[] nums, int val) {
    //    int count=0;
    //    for(int i=0; i<nums.length; i++){
    //     if(nums[i]!=val){
    //         nums[count]=nums[i];
    //         count++;
    //     }
    //    }
    //    return count;

     int k = 0;
        for (int x : nums) {
            if (x != val) {
                nums[k++] = x;
            }
        }
        return k;
        
    }
}