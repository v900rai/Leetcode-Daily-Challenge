class Solution {
    public int[] getConcatenation(int[] nums) {

        // Create a new array of double size
        // क्योंकि हमें original array को 2 बार store करना है
        int ans[] = new int[2 * nums.length];

        // Loop through original array
        for(int i = 0; i < nums.length; i++) {

            // Copy element at same index
            ans[i] = nums[i];

            // Copy same element again after nums.length index
            ans[i + nums.length] = nums[i];
        }

        // Return final concatenated array
        return ans;
    }
}