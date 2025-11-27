class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // minPrefix[r] stores the minimum prefix sum for a length with remainder 'r'
        long[] minPrefix = new long[k];
        final long INF = Long.MAX_VALUE;

        // Initialize: We haven't seen any lengths yet, so set to Infinity
        for (int i = 0; i < k; i++) minPrefix[i] = INF;
        
        // Base case: A prefix sum of length 0 is 0.
        // This handles cases where the valid subarray starts from index 0.
        minPrefix[0] = 0;

        long prefix = 0;
        long answer = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            
            // Calculate current length: (i + 1)
            // Find which "bucket" this length falls into
            int mod = (i + 1) % k;

            // If we have seen a previous prefix sum with the same modulo,
            // we can form a valid subarray by subtracting it.
            if (minPrefix[mod] != INF) {
                answer = Math.max(answer, prefix - minPrefix[mod]);
            }

            // Greedy Logic: We want to maximize (Current - Previous).
            // So we always store the SMALLEST Previous sum for this modulo.
            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return answer == Long.MIN_VALUE ? 0 : answer; // Handle edge case if needed
    }
}