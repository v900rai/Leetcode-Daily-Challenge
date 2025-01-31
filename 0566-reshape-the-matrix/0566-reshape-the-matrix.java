public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int  n = nums[0].length;
//dono ka length compared krna fir condition col,row both are not equal to length return nums
        if (m * n != r * c) 
        return nums;
        
        int[][] result = new int[r][c];
        int row = 0;
        int  col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        
        return result;
    }
}