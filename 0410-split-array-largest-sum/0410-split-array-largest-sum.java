class Solution {
    public int splitArray(int[] nums, int k) {

         int left = getMaximum(nums);
        int right = getSumArray(nums);
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (isValid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
        
    }
    // getting the maximum among the element present in the
    private int getMaximum(int [] nums){
        int max=nums[0];
        for(int num : nums){
            max=Math.max(max, num);
        }
        return max;
    }
     // getting the sum of all the eleemnt present in the array
     private int getSumArray(int [] nums){
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        return sum;
     }
     private boolean isValid(int []nums, int k, int mid){
        int count =1;
        int currentSum=0;
        for(int num : nums){
            currentSum+=num;
            if(currentSum>mid){
                count++;
                currentSum=num;
                if(count>k){
                    return false;
                }
            }
        }
        return true;
     }
}