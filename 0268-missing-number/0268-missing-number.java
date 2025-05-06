class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            ans = ans ^ i;
        }

        // XOR all elements in the nums array
        for (int i = 0; i < n; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}

    
