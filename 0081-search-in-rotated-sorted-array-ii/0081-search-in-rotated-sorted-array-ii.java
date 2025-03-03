class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target found
            if (nums[mid] == target) 
            return true;

            // Handle duplicates: shrink the search space
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1;  // Search right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search right half
                } else {
                    right = mid - 1; // Search left half
                }
            }
        }
        return false;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     int[] nums = {2,5,6,0,0,1,2};
    //     int target = 0;
    //     System.out.println(sol.search(nums, target)); // Output: true

    //     int target2 = 3;
    //     System.out.println(sol.search(nums, target2)); // Output: false
    // }
}
