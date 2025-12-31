class Solution {
    int[][] dirs = {{1,0}, {-1,0},{0,1}, {0,-1}, {1,1},{-1,-1},{1,-1}, {-1,1}};
    int row;
    int col;

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        int[][] grid = new int[row][col];
        int[] parent = new int[row*col+1];
        for (int i = 0; i < row*col+1; i++){
            parent[i] = i;
            if (i % col == 0 && i != row * col) parent[i] = 0;
            else if ((i+1) % col == 0) parent[i] = row*col;
        }
        for (int day = 0; day < cells.length; day++){
            int newLandX = cells[day][0]-1;
            int newLandY = cells[day][1]-1;
            grid[newLandX][newLandY] = 1;
            for (int[] dir : dirs){
                int nx = dir[0] + newLandX;
                int ny = dir[1] + newLandY;
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (grid[nx][ny] == 1){
                    union(parent, getNumber(nx, ny), getNumber(newLandX, newLandY));
                }
            }
            if (find(parent, row*col) == 0) return day;
        }
        return cells.length;
    }
    private int getNumber(int i, int j){
        return i*col + j;
    }

    private void union(int[] nums, int i, int j){
        int first = find(nums, i);
        int second = find(nums, j);
        if (first < second) nums[second] = first;
        else nums[first] = second;
    }
    private int find(int[] nums, int i){
        while (nums[i]!= i){
            nums[i] = nums[nums[i]];
            i = nums[i];
        }
        return i;
    }
}
