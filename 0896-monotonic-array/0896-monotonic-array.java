class Solution {
    public boolean isMonotonic(int[] nums) {

        // maan lo array increasing hai
        boolean inc = true;

        // maan lo array decreasing hai
        boolean dec = true;

        for (int i = 1; i < nums.length; i++) {

            // agar current < previous → increasing possible nahi
            if (nums[i] < nums[i - 1]) {
                inc = false;
            }

            // agar current > previous → decreasing possible nahi
            if (nums[i] > nums[i - 1]) {
                dec = false;
            }
        }

        // agar inc ya dec koi ek bhi true hai → monotonic
        return inc || dec;
    }
}
