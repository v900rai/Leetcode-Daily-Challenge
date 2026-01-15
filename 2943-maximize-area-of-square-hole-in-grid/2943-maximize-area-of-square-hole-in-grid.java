class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // int ans = 1;
        int h = hBars.length;
        int v = vBars.length;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int chmax = 1;
        int curr = 1;
        for (int i=1; i<h; i++) {
            if (hBars[i]-hBars[i-1]==1) {
                chmax = Math.max(++curr, chmax);
            } else {
                curr = 1;
            }
        }
        curr = 1;
        int cvmax = 1;
        for (int i=1; i<v; i++) {
            if (vBars[i]-vBars[i-1]==1) {
                cvmax = Math.max(++curr, cvmax);
            } else {
                curr = 1;
            }
        }
        return (int)Math.pow(Math.min(cvmax, chmax)+1, 2);
    }
}