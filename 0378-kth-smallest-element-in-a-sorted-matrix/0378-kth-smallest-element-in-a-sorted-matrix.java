class Solution {
   



public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
    while (left < right) {
        int mid = left + (right - left) / 2;
        int count = countLessEqual(matrix, mid);
        if (count < k)
         left = mid + 1;
        else
         right = mid;
    }
    return left;
}

private int countLessEqual(int[][] matrix, int target) {
    int n = matrix.length;
    int  count = 0;
    int  row = n - 1;
    int  col = 0;
    while (row >= 0 && col < n) {
        if (matrix[row][col] <= target) {
            count += row + 1;
            col++;
        } else {
            row--;
        }
    }
    return count;
}

}
