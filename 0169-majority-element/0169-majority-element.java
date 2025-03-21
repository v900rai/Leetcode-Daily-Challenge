class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            
            if (count > n / 2) {
                return nums[i]; // Majority element found
            }
        }
        
        return -1; // Should never reach here as per problem statement
    }
}
