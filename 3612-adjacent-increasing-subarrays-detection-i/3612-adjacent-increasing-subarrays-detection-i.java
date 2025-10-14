

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int kt) {
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int j = i;
            int k = i + kt;
            while (j < i + kt && k < n) {
                if (j > i && nums.get(j) <= nums.get(j - 1))
                    break;
                if (k > i + kt && nums.get(k) <= nums.get(k - 1))
                    break;
                k++;
                j++;
            }
            if(j==i+kt && k==i+kt+kt)
                return true;
        }
        return false;
    }
}