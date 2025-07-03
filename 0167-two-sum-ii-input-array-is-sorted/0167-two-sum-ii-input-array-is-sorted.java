class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers: 
        // 'left' starts at the beginning of the array (index 0)
        // 'right' starts at the end of the array (index numbers.length - 1)
        int left = 0;
        int right = numbers.length - 1;

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the sum of the elements at the current left and right pointers
            int sum = numbers[left] + numbers[right];

            // If the sum matches the target, return the 1-based indices of the two numbers
            if (sum == target) {
                // The problem expects 1-based indexing, so we add 1 to each index
                return new int[]{left + 1, right + 1};
            } 
            // If the sum is greater than the target, move the right pointer to the left
            // This decreases the sum because the array is sorted in ascending order
            else if (sum < target) {
                left++;
            } 
            // If the sum is less than the target, move the left pointer to the right
            // This increases the sum because the array is sorted in ascending order
            else {
                right--;
            }
        }

        // If no solution is found (though the problem guarantees one), return [-1, -1]
        return new int[]{-1, -1};
    }
}