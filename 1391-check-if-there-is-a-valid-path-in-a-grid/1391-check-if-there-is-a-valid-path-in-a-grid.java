import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions: Up, Down, Left, Right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // Map of street type to allowed directions
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(1, new int[][]{{0,-1},{0,1}});
        map.put(2, new int[][]{{-1,0},{1,0}});
        map.put(3, new int[][]{{0,-1},{1,0}});
        map.put(4, new int[][]{{0,1},{1,0}});
        map.put(5, new int[][]{{0,-1},{-1,0}});
        map.put(6, new int[][]{{0,1},{-1,0}});

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            // Reached destination
            if(x == m-1 && y == n-1) return true;

            int type = grid[x][y];

            // Explore allowed directions
            for(int[] d : map.get(type)){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny])
                    continue;

                // Check reverse connection
                int nextType = grid[nx][ny];
                for(int[] back : map.get(nextType)){
                    if(nx + back[0] == x && ny + back[1] == y){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        break;
                    }
                }
            }
        }

        return false;
    }
}