class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Initialize start and end pointers
        int start = 0;
        int end = arr.length - 1;

        // Perform binary search
        while (start <= end) {
            int mid = start + (end - start) / 2; // corrected mid formula
            int missing = arr[mid] - mid - 1;

            if (missing < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Return the k-th missing number
        return k + start;
    }
}
