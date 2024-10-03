import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        // If the total sum is already divisible by p, no subarray needs to be removed
        if (totalSum == 0) {
            return 0;
        }

        int target = totalSum; // This is the remainder we need to remove
        Map<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1); // Base case for when the prefix sum itself gives the desired remainder
        int prefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            
            // Find the mod value that would give us the required remainder when removed
            int neededMod = (prefixSum - target + p) % p;
            
            if (prefixModMap.containsKey(neededMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(neededMod));
            }

            // Store the current mod and index in the map
            prefixModMap.put(prefixSum, i);
        }

        // If we couldn't find a valid subarray, return -1
        return minLength == nums.length ? -1 : minLength;
    }
}
