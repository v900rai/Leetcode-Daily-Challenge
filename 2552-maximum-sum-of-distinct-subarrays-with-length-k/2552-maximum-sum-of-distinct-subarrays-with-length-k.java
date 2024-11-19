class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       int i = 0, j = 0;
        long result = 0;
        long currWindowSum = 0;
        HashSet<Integer> set = new HashSet<>();

        while (j < nums.length) {
            // Adjust the window if nums[j] is already in the set
            while (set.contains(nums[j])) {
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            currWindowSum += nums[j];
            set.add(nums[j]);

            // Check if the window size is equal to k
            if (j - i + 1 == k) {
                result = Math.max(result, currWindowSum);

                // Shrink the window from the left
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return result;
    }
 
    
}