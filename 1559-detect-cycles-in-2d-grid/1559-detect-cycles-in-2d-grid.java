class Solution {

    static class Node {
        int r, c, pr, pc;
        Node(int r, int c, int pr, int pc) {
            this.r = r;
            this.c = c;
            this.pr = pr;
            this.pc = pc;
        }
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(vis[i][j]) continue;

                Queue<Node> q = new LinkedList<>();
                q.offer(new Node(i, j, -1, -1));
                vis[i][j] = true;

                while(!q.isEmpty()) {
                    Node node = q.poll();

                    for(int d = 0; d < 4; d++) {
                        int nr = node.r + dr[d];
                        int nc = node.c + dc[d];

                        if(nr >= 0 && nc >= 0 && nr < n && nc < m
                           && grid[nr][nc] == grid[node.r][node.c]) {

                            if(nr == node.pr && nc == node.pc) continue;

                            if(vis[nr][nc]) return true;

                            vis[nr][nc] = true;
                            q.offer(new Node(nr, nc, node.r, node.c));
                        }
                    }
                }
            }
        }
        return false;
    }
}