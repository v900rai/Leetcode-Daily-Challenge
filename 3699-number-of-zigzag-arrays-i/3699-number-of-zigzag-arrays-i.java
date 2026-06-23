class Solution {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length 2 initialization
        for (int i = 0; i < m; i++) {

            up[i] = i;              // smaller values before it

            down[i] = m - 1 - i;    // greater values before it
        }

        // Build lengths 3...n
        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefixUp = new long[m + 1];
            long[] prefixDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixUp[i + 1] =
                    (prefixUp[i] + up[i]) % MOD;

                prefixDown[i + 1] =
                    (prefixDown[i] + down[i]) % MOD;
            }

            long totalUp = prefixUp[m];
            long totalDown = prefixDown[m];

            for (int x = 0; x < m; x++) {

                // y < x
                newUp[x] = prefixDown[x];

                // y > x
                newDown[x] =
                    (totalUp - prefixUp[x + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}