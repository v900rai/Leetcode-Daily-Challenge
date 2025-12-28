class Solution {
    public int countNegatives(int[][] grid) {
       
        int res = 0;
        for(int i = 0; i < grid.length; ++i) {
            res = res +  negativeEachRow(grid[i]);
        }
        return res;
    }


    
    private int negativeEachRow(int[] row) {
        int res = 0;
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] >= 0) {
                left = mid + 1;

            } else if (row[mid] < 0) {
              
                res += right - mid + 1;
                right = mid - 1;
            }
        }
        return res;
    }
}