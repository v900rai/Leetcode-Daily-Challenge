class Solution {
    public long subArrayRanges(int[] A) {
        long res = 0; // Final answer
        for (int i = 0; i < A.length; i++) {
            int max = A[i];  // subarray ka starting max
            int min = A[i];  // subarray ka starting min
            
            for (int j = i; j < A.length; j++) {
                max = Math.max(max, A[j]); // update max if needed
                min = Math.min(min, A[j]); // update min if needed
                
                // add current subarray contribution
                res += max - min;
            }
        }
        return res;
    }
}
