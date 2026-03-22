import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: sort intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        // first interval add
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] last = list.get(list.size() - 1); // last added
            int[] curr = intervals[i];              // current

            // overlap check
            if (curr[0] <= last[1]) {
                // merge
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // no overlap
                list.add(curr);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}