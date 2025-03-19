class Solution {
    public void sortColors(int[] nums) {
      int left=0;
      int right=nums.length-1;
      int mid=0;
      while(left<right){
        if(nums[mid]==0){
          swapColor(nums, mid ,left);
          left++;
          mid++;
        }

          if(nums[mid]==0){
          mid++;
          }
          swapColor(nums,mid ,right);
          right--;

        
         
      }

        
    }
    public static int swapColor(int nums[] , int left , int right){
      int temp=nums[left];
       nums[left]=nums[right];
       nums[right]=temp;
    }
}