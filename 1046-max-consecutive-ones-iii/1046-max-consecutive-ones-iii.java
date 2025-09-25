
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int  right = 0;
        int zeroCount = 0;
        int maxLen = 0;
        
        while (right < nums.length) {
            // Agar zero mila to zeroCount badhao
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // Agar zeroCount k se jyada ho gaya to window shrink karo
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Window ka size check karo
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        return maxLen;
    }
}
