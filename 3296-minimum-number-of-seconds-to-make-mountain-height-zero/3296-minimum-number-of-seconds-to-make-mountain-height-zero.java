import java.util.*;

class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long lo = 1, hi = (long)1e16;  // safe upper bound
        while (lo < hi) {
            long mid = lo + ((hi - lo) >> 1);
            if (canFinish(height, times, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canFinish(int height, int[] times, long maxTime) {
        long total = 0;
        for (int t : times) {
            // Each worker can reduce k units if:
            // t * (k * (k + 1) / 2) <= maxTime
            // Solve quadratic for k
            double limit = (double)maxTime / t * 2 + 0.25;
            long k = (long)(Math.sqrt(limit) - 0.5);
            total += k;
            if (total >= height) return true;
        }
        return total >= height;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.minNumberOfSeconds(4, new int[]{2,1,1}));   // Output: 3
        System.out.println(solver.minNumberOfSeconds(10, new int[]{3,2,2,4})); // Output: 12
        System.out.println(solver.minNumberOfSeconds(5, new int[]{1}));        // Output: 15
    }
}