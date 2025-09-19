public class Solution {
    public int maxProduct(int[] nums) {
        // Handle edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            if (current < 0) {
                
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
                
            }
            
            // Update max product: either start new subarray (current)
            // or continue previous subarray (maxProduct * current)
            maxProduct = Math.max(current, maxProduct * current);
            // STEP 1: max(3, 2*3=6) => maxP=6
            // STEP 2: max(-2, 3*-2=-6) => maxP=-2
            // STEP 3: max(4, -2*4=-8) => maxP=4
            
            // Update min product: similar logic but tracking minimum
            minProduct = Math.min(current, minProduct * current);
            // STEP 1: min(3, 2*3=6) => minP=3
            // STEP 2: min(-2, 6*-2=-12) => minP=-12
            // STEP 3: min(4, -12*4=-48) => minP=-48
            
            // Update overall result with new maximum found
            result = Math.max(result, maxProduct);
            // STEP 1: max(2, 6) => result=6
            // STEP 2: max(6, -2) => result=6
            // STEP 3: max(6, 4) => result=6
        }
        
        // Final result for [2,3,-2,4] is 6
        return result;
    }
}