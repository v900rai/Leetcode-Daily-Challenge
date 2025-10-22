
/**
 * LeetCode 3347 – Maximum Frequency of an Element After Performing Operations II
 *
 * Algorithm summary:
 * 1. Sort the array to enable range counting with two pointers.
 * 2. For each unique value v:
 *      - Find how many numbers fall within [v - k, v + k].
 *      - We can turn at most numOperations of them into v, so:
 *          candidate = min(coverage, numOperations + freq(v)).
 * 3. For values x that don’t exist in nums:
 *      - Coverage only changes when x crosses num[i] - k or num[i] + k.
 *      - Since coverage increases at left edges (num[i] - k) and decreases
 *        at right edges, its maximum always occurs right after a left edge.
 *      - Therefore, checking only x = num[i] - k is sufficient to find
 *        the maximum coverage among non-existing targets.
 * 4. Return the maximum across both cases.
 *
 * Complexity:
 *   Time  O(n log n) due to sorting
 *   Space O(1)
 */
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) return 0;

        int ans = 0;

        // ---------- Pass 1: existing values ----------
        // Evaluate each distinct value v as the target element.
        int i = 0, left = 0, right = 0;
        while (i < n) {
            int v = nums[i];
            int freq = 0;

            // Count duplicates of v
            while (i < n && nums[i] == v) {
                i++;
                freq++;
            }

            long lo = (long) v - k;
            long hi = (long) v + k;

            // Shrink window left bound
            while (left < n && (long) nums[left] < lo) left++;
            // Expand window right bound
            while (right < n && (long) nums[right] <= hi) right++;

            int coverage = right - left;
            int cand = Math.min(coverage, numOperations + freq);
            ans = Math.max(ans, cand);
        }

        // ---------- Pass 2: non-existing values ----------
        // Only check left edges (x = num[i] - k)
        // because coverage(x) reaches new peaks immediately after these points.
        int L = 0, R = 0;
        for (int j = 0; j < n; ) {
            int v = nums[j];
            long x = (long) v - k;
            long lo = x - k;   // = v - 2k
            long hi = x + k;   // = v

            while (L < n && (long) nums[L] < lo) L++;
            while (R < n && (long) nums[R] <= hi) R++;

            int coverage = R - L;
            int cand = Math.min(coverage, numOperations);
            ans = Math.max(ans, cand);

            // Skip duplicates so we don't re-check identical edges
            while (j < n && nums[j] == v) j++;
        }

        return ans;
    }
}