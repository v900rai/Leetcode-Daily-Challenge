class Solution {
    public int maxProduct(int[] nums) {
        // Step 1: Initialize variables
        int currMax = nums[0];  // max product ending at current index
        int currMin = nums[0];  // min product ending at current index
        int maxProduct = nums[0]; // overall maximum product

        // Step 2: Iterate through array
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If num is negative, swap currMax and currMin
            if (num < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Calculate new currMax and currMin
            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);

            // Update overall maxProduct
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
