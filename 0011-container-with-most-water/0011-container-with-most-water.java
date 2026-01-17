class Solution {

    // This method finds the maximum water that can be contained
    // using the two-pointer approach
    public int maxArea(int[] height) {

        // Left pointer at start of array
        int left = 0;

        // Right pointer at end of array
        int right = height.length - 1;

        // Variable to store maximum area
        int ans = 0;

        // Continue until both pointers meet
        while (left < right) {

            // Width between the two lines
            int w = right - left;

            // Height is the minimum of two lines
            
            int h = Math.min(height[left], height[right]);

            // Calculate current area
            int area = w * h;

            // Store the maximum area
            ans = Math.max(ans, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Return the maximum water area
        return ans;
    }
}
