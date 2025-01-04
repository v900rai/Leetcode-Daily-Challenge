class Solution {
    public int waysToSplitArray(int[] nums) {
         int n = nums.length;

        // Calculate the total sum of the array first steps bhai
        long sum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
        }

        long leftSum = 0;
        long rightSum = 0;
        int splitCount = 0;

        // overall krna h  Iterate through the array to calculate leftSum and rightSum
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;

            if (leftSum >= rightSum) {
                splitCount++;
            }
        }

        return splitCount;
    }
} 
    