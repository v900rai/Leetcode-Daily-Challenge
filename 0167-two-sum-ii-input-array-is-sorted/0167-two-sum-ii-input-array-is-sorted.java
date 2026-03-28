class Solution {
  public int[] twoSum(int[] numbers, int target) {
    
    // Two pointers approach
    int left = 0;                      // Start pointer (smallest element)
    int right = numbers.length - 1;    // End pointer (largest element)

    // Loop until both pointers meet
    while (left < right) {

      // Calculate sum of current pair
      int sum = numbers[left] + numbers[right];

      // Case 1: If sum equals target → answer found
      if (sum == target) {
        // Return 1-based index (as per problem requirement)
        return new int[] { left + 1, right + 1 };
      }

      // Case 2: If sum is smaller than target
      // Move left pointer to increase sum
      else if (sum < target) {
        left++;
      }

      // Case 3: If sum is greater than target
      // Move right pointer to decrease sum
      else {
        right--;
      }
    }

    // Edge case (though problem guarantees one solution)
    return new int[] { -1, -1 };
  }
}