import java.util.HashMap;

public class Solution {

    // Helper method to calculate sum of digits of a number
    private int findDigitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10; // Add last digit
            num /= 10;       // Remove last digit
        }
        return sum;
    }

    // Method to count the number of groups having the largest size
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxSize = 0; // Maximum frequency of any group
        int count = 0;   // Count of groups with maxSize

        for (int num = 1; num <= n; num++) {
            int digitsSum = findDigitsSum(num); // Sum of digits of current number

            // Update the frequency of this digitsSum
            map.put(digitsSum, map.getOrDefault(digitsSum, 0) + 1);

            int freq = map.get(digitsSum);

            if (freq == maxSize) {
                count++; // One more group with maxSize
            } else if (freq > maxSize) {
                maxSize = freq; // Update new maxSize
                count = 1;      // Reset count for new maxSize
            }
        }

        return count;
    }
}
