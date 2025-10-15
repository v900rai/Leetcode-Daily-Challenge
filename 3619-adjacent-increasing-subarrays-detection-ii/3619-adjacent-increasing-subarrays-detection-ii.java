
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int currRun = 1;
        int prevRun = 0;
        int maxResult = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                currRun++;
            } else { // increasing order breaks here
                prevRun = currRun;
                currRun = 1;
            }

            maxResult = Math.max(maxResult, currRun / 2);
            maxResult = Math.max(maxResult, Math.min(prevRun, currRun));
        }

        return maxResult;
    }
}