import java.util.HashMap;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Array को पीछे से traverse करते हैं
        for (int i = n - 1; i >= 0; i--) {
            // अगर कोई element पहले ही आ चुका है
            if (map.containsKey(nums[i])) {
                // i/3 + 1 return करते हैं
                return i / 3 + 1;
            }
            // otherwise, map में डाल देते हैं
            map.put(nums[i], 1);
        }

        // अगर कोई duplicate नहीं मिला
        return 0;
    }
}
