class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        
        // Result array to store the two unique numbers
        int[] result = new int[2];
        
        // Index to keep track of how many unique numbers we have stored
        int index = 0;

        // Outer loop -> pick each element one by one
        for (int i = 0; i < n; i++) {
            boolean found = false; // Flag to check if current element is duplicate

            // Inner loop -> compare nums[i] with every other element
            for (int j = 0; j < n; j++) {
                // If same number found at a different index, mark as duplicate
                if (i != j && nums[i] == nums[j]) {
                    found = true;
                    break; // No need to check further, it's duplicate
                }
            }

            // If element was never found duplicate -> it's a unique number
            if (!found) {
                result[index++] = nums[i]; // Store the unique number

                // If we already found both unique numbers, stop searching
                if (index == 2) {
                    break;
                }
            }
        }
        
        // Return the array containing the two unique numbers
        return result;
    }
}
