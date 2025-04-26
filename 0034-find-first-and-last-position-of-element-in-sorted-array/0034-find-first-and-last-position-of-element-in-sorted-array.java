class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findBound(nums, target, true), findBound(nums, target, false)};
    }
    
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int  right = nums.length - 1;
        int result = -1; // अगर target नहीं मिलता, तो -1 return होगा।
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                // यदि हमें पहली occurrence चाहिए तो left part में जाएं।
                
                if (isFirst) {
                    right = mid - 1;
                } else {
                    // आखिरी occurrence के लिए right part में जाएं।
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
