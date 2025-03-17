import java.util.Arrays;

class Solution {
    public boolean divideArray(int[] nums) {
        // Sorting the array to group identical elements together
        Arrays.sort(nums);
        
        // Traverse the array and check if all elements can form pairs
        for (int i = 0; i < nums.length - 1; i++) {
            // If two consecutive elements are the same, move to the next pair
            if (nums[i] == nums[i + 1]) {
                i++; // Increment i again to skip the next element in the pair
                continue; // Continue checking the next pair
            } 
            else {
                return false; // If a pair is not found, return false
            }
        }
        
        return true; // If all elements can form pairs, return true
    }
}
