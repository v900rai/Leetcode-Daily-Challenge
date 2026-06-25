class Solution {
    public int[] plusOne(int[] digits) {

        // Get length of input array
        int n = digits.length;

        // Start from the last digit (least significant digit)
        int i = n - 1;

        // Traverse from right to left
        while (i >= 0) {

            // If current digit is less than 9
            // simply increase it by 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, then after adding 1
            // it becomes 0 and carry moves to left
            digits[i] = 0;
            i--;
        }

        // If all digits were 9
        // Example: [9,9,9] -> [1,0,0,0]

        // Create new array of size n + 1
        int[] result = new int[n + 1];

        // Put 1 at first position
        result[0] = 1;

        // Remaining positions are already 0 by default
        return result;
    }
}