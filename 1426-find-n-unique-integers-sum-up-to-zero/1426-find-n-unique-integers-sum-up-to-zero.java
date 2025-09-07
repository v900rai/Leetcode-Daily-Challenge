class Solution {
    public int[] sumZero(int n) {
        // Create an array to store result
        int[] result = new int[n];
        int sum = 0;

        // Fill first (n-1) elements with positive numbers
        for (int i = 0; i < n - 1; i++) {
            result[i] = i + 1;   // 1, 2, 3, ...
            sum += result[i];    // Keep track of the sum
        }

        // Last element will balance the sum to 0
        result[n - 1] = -1 * sum;

        return result;
    }
}
