
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length;
        int count =0;

        for (int i = n - 1; i >= n - k; --i) {
            happiness[i] = Math.max(happiness[i] - count++, 0);
            res += happiness[i];
        }

        return res;
    }
}