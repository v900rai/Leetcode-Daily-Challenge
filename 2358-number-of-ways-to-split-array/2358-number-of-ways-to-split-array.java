class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long[] cumSum = new long[n];

        cumSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            cumSum[i] = cumSum[i - 1] + nums[i];
        }
        int split=0;
        
        // Iterate krna h overall 
        for (int i = 0; i < n - 1; i++) {
            long leftSum = cumSum[i];
            long rightSum = cumSum[n - 1] - cumSum[i];
            
            if (leftSum >= rightSum) {
                split++;
            }
        }
        
        return split;
    
        
    }
}