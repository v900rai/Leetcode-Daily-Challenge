class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int i = n - 1; // start from LSB like normal addition

        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // digit was 9
            digits[i] = 0;
            i--;
        }

        // carry reached beyond the most significant digit
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}