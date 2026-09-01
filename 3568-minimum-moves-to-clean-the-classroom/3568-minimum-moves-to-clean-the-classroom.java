import java.util.*;

class Solution {

    static class State {
        int r;
        int c;
        int energy;
        int mask;
        int moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        // litter ka index store karenge
        int[][] litterIndex = new int[m][n];

        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        // Find S and all L
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litterIndex[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        int targetMask = (1 << litterCount) - 1;

        Queue<State> q = new LinkedList<>();

        // Starting state
        q.offer(
            new State(
                startR,
                startC,
                energy,
                0,
                0
            )
        );

        /*
            visited[r][c][energy][mask]
        */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            State curr = q.poll();

            int r = curr.r;
            int c = curr.c;
            int currEnergy = curr.energy;
            int mask = curr.mask;
            int moves = curr.moves;

            // All litter collected
            if (mask == targetMask) {
                return moves;
            }

            // Energy khatam
            if (currEnergy == 0) {
                continue;
            }

            // 4 directions
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Boundary check
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                char ch = classroom[nr].charAt(nc);

                // Obstacle
                if (ch == 'X') {
                    continue;
                }

                // One move costs 1 energy
                int newEnergy = currEnergy - 1;

                // Reset area
                if (ch == 'R') {
                    newEnergy = energy;
                }

                // Current mask
                int newMask = mask;

                // Litter found
                if (ch == 'L') {

                    int index = litterIndex[nr][nc];

                    newMask = mask | (1 << index);
                }

                // Same state already visited?
                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                q.offer(
                    new State(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    )
                );
            }
        }

        return -1;
    }
}