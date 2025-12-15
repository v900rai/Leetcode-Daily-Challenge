class Solution {

    // This method finds two numbers in a sorted array
    // whose sum is equal to the given target
    public int[] twoSum(int[] numbers, int target) {

        // Pointer starting from the beginning of the array
        int left = 0;

        // Pointer starting from the end of the array
        int right = numbers.length - 1;

        // Loop continues until both pointers meet
        while (left < right) {

            // Calculate sum of elements at left and right pointers
            int sum = numbers[left] + numbers[right];

            // If the sum matches the target, return indices (1-based)
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            // If sum is smaller than target,
            // move left pointer to the right to increase sum
            else if (sum < target) {
                left++;
            }

            // If sum is greater than target,
            // move right pointer to the left to decrease sum
            else {
                right--;
            }
        }

        // If no valid pair is found, return -1, -1
        return new int[]{-1, -1};
    }
}
