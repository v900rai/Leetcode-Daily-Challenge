class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        // First element must be 1 (can only decrement, not increment)
        if (arr[0] != 1) arr[0] = 1;

        // Each element can be at most 1 more than the previous
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) <= 1) continue;
            arr[i] = arr[i - 1] + 1;
        }

        return arr[n - 1];
    }
}
