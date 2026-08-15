class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;

        // Step 1: Find XOR of complete array
        for (int num : nums) {
            xor ^= num;
        }

        // Case 1: Complete array ka XOR non-zero hai
        if (xor != 0) {
            return n;
        }

        // Case 2: Complete XOR zero hai
        // Check karo koi non-zero element hai ya nahi
        for (int num : nums) {
            if (num != 0) {
                return n - 1;
            }
        }

        // Case 3: Saare elements zero hain
        return 0;
    }
}