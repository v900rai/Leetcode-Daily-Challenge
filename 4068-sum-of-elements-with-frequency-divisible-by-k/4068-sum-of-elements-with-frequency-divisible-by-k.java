class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        // Create a frequency array to count occurrences of numbers (assuming numbers are in range 0–100)
        int[] freq = new int[101];

        // Count how many times each number appears in the input array
        for (int num : nums) {
            freq[num]++;
        }

        int sum = 0; // Variable to store the final sum

        // Traverse the array again to check the condition for each element
        for (int num : nums) {
            // If the frequency of this number is divisible by k
            if (freq[num] % k == 0) {
                // Add this number to the sum
                sum = sum + num;
            }
        }

        // Return the total sum of all numbers whose frequency is divisible by k
        return sum;
    }
}
