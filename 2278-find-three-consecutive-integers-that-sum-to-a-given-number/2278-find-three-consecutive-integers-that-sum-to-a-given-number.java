class Solution {
    public long[] sumOfThree(long num) {
        // Step 1: Check if num is divisible by 3
        // If not, it's impossible to have 3 consecutive numbers whose sum is num
        if (num % 3 != 0) 
            return new long[0]; // return empty array if num is not divisible by 3

        // Step 2: Find the middle number of the 3 consecutive numbers
        // Formula: num = (x - 1) + x + (x + 1) = 3x
        long x = num / 3;

        // Step 3: Create an array to store the 3 consecutive numbers
        long[] arr = new long[3];

        // Step 4: Assign values
        // The three consecutive numbers are (x-1), x, (x+1)
        arr[0] = x - 1; // first number
        arr[1] = x;     // middle number
        arr[2] = x + 1; // third number

        // Step 5: Return the result array
        return arr;
    }
}
