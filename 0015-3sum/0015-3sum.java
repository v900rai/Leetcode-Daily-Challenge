import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res= new HashSet<>();
        // Edge case: if array is empty, return empty list
        if (nums.length == 0)
            return new ArrayList<>();
        // Step 1: Sort the array to use two-pointer technique
        Arrays.sort(nums);
        // Step 2: Traverse each element, treating it as the first element of triplet
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1; // Left pointer
            int k = nums.length - 1; // Right pointer
            // Step 3: Move the two pointers to find valid triplets
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k]; // Calculate current triplet sum
                if (sum == 0) {
                    // Valid triplet found, add to result set
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; // Move both pointers to check for more possibilities
                    k--;
                } else if (sum > 0) {
                    k--; // Sum is too big, move right pointer left to reduce it
                } else {
                    j++; // Sum is too small, move left pointer right to increase it
                }
            }
        }

        // Convert the Set to List and return
        return new ArrayList<>(res);
    }
}
