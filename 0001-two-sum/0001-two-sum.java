class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // हर संख्या को दूसरे के साथ जोड़कर चेक करना
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};  // सही इंडेक्स return करो
                }
            }
        }
      
        return new int[]{};  // अगर कोई pair नहीं मिला
    }
}
