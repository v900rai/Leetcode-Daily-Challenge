

import java.util.HashSet;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Step 1: Store all numbers in a HashSet for fast lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Keep multiplying by 2 while the value is found
        while (set.contains(original)) {
            original *= 2;
        }

        // Step 3: Return final value
        return original;
    }

    
}
