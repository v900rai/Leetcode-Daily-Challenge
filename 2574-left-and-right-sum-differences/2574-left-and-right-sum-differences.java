class Solution {
    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Total sum of array
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            // Current element ko right sum se hata do
            rightSum -= nums[i];

            // Absolute difference store karo
            answer[i] = Math.abs(leftSum - rightSum);

            // Current element ko left sum me add karo
            leftSum += nums[i];
        }

        return answer;
    }
}