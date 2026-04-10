class Solution {
    public int minimumDistance(int[] nums) {

        // Length of array
        int len = nums.length;

        // Store minimum distance found so far
        int minDist = Integer.MAX_VALUE;

        // To check whether any valid triplet exists
        boolean hasTriplet = false;

        // Pick first index
        for (int a = 0; a < len; a++) {

            // Pick second index after first
            for (int b = a + 1; b < len; b++) {

                // Pick third index after second
                for (int c = b + 1; c < len; c++) {

                    // Check if all three values are same
                    if (nums[a] == nums[b] && nums[b] == nums[c]) {

                        hasTriplet = true;

                        // Calculate total pairwise distance
                        int totalDist =
                                Math.abs(a - b) +
                                Math.abs(b - c) +
                                Math.abs(c - a);

                        // Update minimum distance if smaller found
                        if (totalDist < minDist) {
                            minDist = totalDist;
                        }
                    }
                }
            }
        }

        // If triplet found return min distance else return -1
        return hasTriplet ? minDist : -1;
    }
}