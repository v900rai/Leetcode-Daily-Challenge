class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = i; j < n; j++) {

                // Current element check karo
                if (nums[j] == target) {
                    count++;
                }

                int len = j - i + 1;

                // target majority hai ya nahi
                if (count > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}