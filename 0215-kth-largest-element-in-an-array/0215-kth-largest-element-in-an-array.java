import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); // Sorts in ascending order
        return nums[nums.length - k]; // Return the kth largest element
    }
}
