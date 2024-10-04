
import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        // Sort the skill array
        Arrays.sort(skill);

        long totalSum = 0;
        int left = 0;
        int right = skill.length - 1;

        // Calculate the target sum of skill for any pair
        int targetSum = skill[left] + skill[right];

        // Traverse the array from both ends using two pointers
        while (left < right) {
            int currentSum = skill[left] + skill[right];

            // Check if the current pair has the required skill sum
            if (currentSum != targetSum) {
                return -1;  // If any pair doesn't match the target sum, return -1
            }

            // Sum the product of the current pair
            totalSum += (long) skill[left] * skill[right];

            // Move the pointers towards each other
            left++;
            right--;
        }

        return totalSum;
    }
}
