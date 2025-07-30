class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0; 
        while(left < right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            ans = Math.max(area, ans);  // Fixed: using max instead of min
             
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}