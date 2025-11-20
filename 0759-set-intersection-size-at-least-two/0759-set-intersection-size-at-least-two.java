class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[1] == y[1]) 
                return y[0] - x[0];
            else
                return x[1] - y[1];
        });
        int p1 = -1, p2 = -1, res = 0, n = intervals.length;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean hasP1 = p1 >= start && p1 <= end;
            boolean hasP2 = p2 >= start && p2 <= end;

            if (hasP1 && hasP2) {
                continue;
            } 
            else if (hasP2) {
                p1 = p2;
                p2 = end;
                res += 1;
            } 
            else {
                p1 = end - 1;
                p2 = end;
                res += 2;
            }
        }

        return res;
    }
}