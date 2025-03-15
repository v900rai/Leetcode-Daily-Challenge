import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // अगर यह element पहले से set में मौजूद है, तो duplicate मिला
            if (window.contains(nums[i])) {
                return true;
            }

            // Set में नया element add करें
            window.add(nums[i]);

            // अगर window size k से ज़्यादा हो गया, तो पुराना element हटा दें
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}

