class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start from the top-right corner of the matrix
        int i = 0;  // Row index
        int j = matrix[0].length - 1;  // Column index (last column)

        // Traverse the matrix until we go out of bounds
        while (i < matrix.length && j >= 0) {
            int temp = matrix[i][j]; // Current element

            // If the target is found, return true
            if (temp == target) {
                return true;
            }
            // If the current element is smaller than the target, move down
            else if (temp < target) {
                i++;  // Move to the next row
            }
            // If the current element is larger than the target, move left
            else {
                j--;  // Move to the previous column
            }
        }

        // If we exit the loop, the target is not present
        return false;
    }
}
