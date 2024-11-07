class Solution {
    public int largestCombination(int[] candidates) {
         int[] count = new int[24];
        int result = 0;

        // Count how many numbers have the i-th bit set
        for (int i = 0; i < 24; i++) { // O(24)
            for (int num : candidates) { // O(n)
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
            result = Math.max(result, count[i]);
        }

        return result;
    }
        
    
}