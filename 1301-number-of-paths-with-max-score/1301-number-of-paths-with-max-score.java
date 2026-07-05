
class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int MOD = 1000000007;

        // Maximum score
        int[][] score = new int[n][n];

        // Number of ways
        int[][] ways = new int[n][n];

        // Initialize score with -1 (unreachable)
        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        // Starting point (S)
        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                // Skip obstacle
                if (ch == 'X')
                    continue;

                // Skip starting cell
                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;
                long count = 0;

                // Down
                if (i + 1 < n && score[i + 1][j] != -1) {

                    if (score[i + 1][j] > best) {
                        best = score[i + 1][j];
                        count = ways[i + 1][j];
                    } else if (score[i + 1][j] == best) {
                        count = (count + ways[i + 1][j]) % MOD;
                    }
                }

                // Right
                if (j + 1 < n && score[i][j + 1] != -1) {

                    if (score[i][j + 1] > best) {
                        best = score[i][j + 1];
                        count = ways[i][j + 1];
                    } else if (score[i][j + 1] == best) {
                        count = (count + ways[i][j + 1]) % MOD;
                    }
                }

                // Diagonal
                if (i + 1 < n && j + 1 < n && score[i + 1][j + 1] != -1) {

                    if (score[i + 1][j + 1] > best) {
                        best = score[i + 1][j + 1];
                        count = ways[i + 1][j + 1];
                    } else if (score[i + 1][j + 1] == best) {
                        count = (count + ways[i + 1][j + 1]) % MOD;
                    }
                }

                // No path
                if (best == -1)
                    continue;

                int value = 0;

                if (Character.isDigit(ch))
                    value = ch - '0';

                score[i][j] = best + value;
                ways[i][j] = (int) (count % MOD);
            }
        }

        if (ways[0][0] == 0)
            return new int[] {0, 0};

        return new int[] {score[0][0], ways[0][0]};
    }
}