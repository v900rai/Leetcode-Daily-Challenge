class Solution {
    public int minOperations(int[] nums) {
        int count = 0; // Counter to keep track of the number of operations performed
        int n = nums.length; // Length of the input array

        // Iterate through the array up to the third last element
        for (int i = 0; i < n - 2; i++) {
            // If the current element is 0, flip it along with the next two elements
            if (nums[i] == 0) {
                nums[i] ^= 1;     // Flip nums[i] (0 -> 1, 1 -> 0)
                nums[i + 1] ^= 1; // Flip nums[i+1]
                nums[i + 2] ^= 1; // Flip nums[i+2]
                count++; // Increment the operation count
            }
        }

        // If the last two elements are both 1, return the count, else return -1 (not possible)
        return (nums[n - 2] == 1 && nums[n - 1] == 1) ? count : -1;
    }
}
