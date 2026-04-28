import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Mark the visited numbers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // correct index nikal rahe hain
            
            // Agar positive hai to negative mark kar do
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Step 2: Jo indices positive hain wo missing numbers hain
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // number missing hai
            }
        }

        return result;
    }
}