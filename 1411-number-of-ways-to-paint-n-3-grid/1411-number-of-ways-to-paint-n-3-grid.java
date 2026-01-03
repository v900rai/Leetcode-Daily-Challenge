class Solution {
    public int numOfWays(int n) {
        int mod = 1_000_000_007;

        long aba = 6;
        long abc = 6;

        for (int i = 1; i < n; i++) {
            long nextAba = (3 * aba + 2 * abc) % mod;
            long nextAbc = (2 * aba + 2 * abc) % mod;

            aba = nextAba;
            abc = nextAbc;
        }

        return (int)((aba + abc) % mod);
    }
}