class Solution {

    static final long MOD = 1_000_000_007L;

    public int numberOfSets(int n, int k) {

        // Formula:
        // C(n + k - 1, 2 * k)

        int N = n + k - 1;
        int R = 2 * k;

        long ans = 1;

        // Calculate combination C(N, R)
        for (int i = 1; i <= R; i++) {

            // ans = ans * (N - R + i)
            ans = ans * (N - R + i) % MOD;

            // Divide by i using modular inverse
            ans = ans * modPow(i, MOD - 2) % MOD;
        }

        return (int) ans;
    }

    // Fast Power:
    // Calculates (a ^ b) % MOD
    private long modPow(long a, long b) {

        long result = 1;

        while (b > 0) {

            // If b is odd
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            // a = a * a
            a = a * a % MOD;

            // b = b / 2
            b = b >> 1;
        }

        return result;
    }
}