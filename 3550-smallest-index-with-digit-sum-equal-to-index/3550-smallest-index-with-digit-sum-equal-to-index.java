class Solution {

    public int smallestIndex(int[] nums) {

        // Traverse every index
        for (int i = 0; i < nums.length; i++) {

            // Calculate digit sum of nums[i]
            int sum = digitSum(nums[i]);

            // If digit sum is equal to index
            if (sum == i) {
                return i;   // Smallest index mil gaya
            }
        }

        // No index found
        return -1;
    }

    // Function to calculate digit sum
    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;  // Last digit add karo
            num /= 10;        // Last digit remove karo
        }

        return sum;
    }
}