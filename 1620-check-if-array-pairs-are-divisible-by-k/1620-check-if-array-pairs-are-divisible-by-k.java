class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            int rem = num % k;
            if (rem < 0) {
                rem = rem + k;
            }
            freq[rem]++;
        }
        
        // Check if frequency of remainder 0 is even
        if (freq[0] % 2 != 0) {
            return false;
        }
        
        // Check if the frequencies of remainders are compatible
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        
        return true;
    }
}
