class Solution {
    public int singleNonDuplicate(int[] nums) {
      int xor=0;
      for(int i=0; i<nums.lenght; i++){
        xor^=nums[i];
      }
      return xor
        
    }
}