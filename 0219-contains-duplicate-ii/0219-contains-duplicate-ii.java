import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

            // अगर window size k से ज्यादा हो जाए, तो पुराने element को हटा दो
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
