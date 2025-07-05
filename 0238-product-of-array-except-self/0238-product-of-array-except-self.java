class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Step 1: Compute left products (बाएं उत्पादों की गणना करें)
        // ans[i] = product of all elements to the left of nums[i]
        // ans[i] = nums[0] * nums[1] * ... * nums[i-1]
        ans[0] = 1; // No elements to the left of nums[0], so ans[0] = 1
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        // Step 2: Compute right products and multiply with left products
        // (दाएं उत्पादों की गणना करें और बाएं उत्पादों से गुणा करें)
        // Now, ans[i] = leftProduct[i] * rightProduct[i]
        // rightProduct = product of all elements to the right of nums[i]
        // rightProduct = nums[i+1] * nums[i+2] * ... * nums[n-1]
        int rightProduct = 1; // Initially, no elements to the right of nums[n-1]
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct; // Multiply left product with right product
            rightProduct *= nums[i]; // Update right product for next iteration
        }
        
        return ans;
    }
}