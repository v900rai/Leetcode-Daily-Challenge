class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int size = maxValue + 1 + k;
        int[] range = new int[size];
        
        // Line sweep
        for (int num : nums)
            range[num]++;

        // prefix sum
        for (int i = 1; i < size; i++)
            range[i] += range[i - 1];

        int maxCount = 0;

        // we will take each element and find rest which can adjust
        for (int i = 1; i < size; i++) {
            // as min is 1 & max is size-1 
            int left = Math.max(1, i - k);
            int right = Math.min(size-1, i + k);

            // Total values in range
            int totalVal = range[right] - range[left-1];

            // frequency of itself 'i'
            int currFreq = range[i] - range[i - 1];
            // total Values in range includes the freq of current number as well, 
            // difference of both gives the actual figure of no. which can adjust to current number
            // but we have restriction as numOperations.
            maxCount = Math.max(maxCount,currFreq + Math.min(numOperations, totalVal - currFreq));
        }
        return maxCount;

    }
}