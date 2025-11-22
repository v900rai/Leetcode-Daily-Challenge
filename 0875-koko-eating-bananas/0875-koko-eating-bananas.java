class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1; // minimum speed
        int right = 0;

        // find maximum pile -> maximum limit for speed
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2; // speed guess

            // check if she can eat all piles with speed mid
            if (eatAll(piles, mid, h)) {
                ans = mid;        // mid is a valid answer
                right = mid - 1;  // try to reduce speed
            } else {
                left = mid + 1;   // increase speed
            }
        }
        return ans;
    }

    // check function
    boolean eatAll(int[] nums, int x, int h) {

        long eatingTime = 0;

        for (int num : nums) {
            // ceil(num/x)
            eatingTime += (num + x - 1) / x;
        }

        return eatingTime <= h;
    }
}
