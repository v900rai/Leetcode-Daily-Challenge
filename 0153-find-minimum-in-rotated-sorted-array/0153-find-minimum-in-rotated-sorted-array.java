class Solution {
    public int findMin(int[] nums) {
        // Initialize the left and right pointers
        int left = 0;
        int right = nums.length - 1;
        

        // Perform binary search to find the minimum element
        while (left < right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // If the middle element is less than or equal to the rightmost element,
            // it means the minimum element lies in the left half (including mid)
            if (nums[mid] <= nums[right]) {
                right = mid; // Move right pointer to mid
            } else {
                // If nums[mid] is greater than nums[right], it means the minimum element
                // lies in the right half, so we move left to mid + 1
                left = mid + 1;
            }
        }
        // At the end of the loop, left will point to the minimum element
        return nums[left];        
    }
}
