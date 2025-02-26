class Solution {
    public int maxAbsoluteSum(int[] A) {
        int minPrefix = 0, maxPrefix = 0, prefixSum = 0;
        
        for (int a : A) {
            prefixSum += a;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }
        
        return maxPrefix - minPrefix;
    }
}
