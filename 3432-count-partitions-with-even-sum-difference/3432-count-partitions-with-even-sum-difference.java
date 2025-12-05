class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for( int num : nums ) {
            sum += num;
        }

        int res = 0;
        int currSum = 0;
        for( int i = 0; i < n - 1; i++ ) {
            currSum += nums[i];
            sum -= nums[i];

            if( (sum - currSum) % 2 == 0 ) {
                res += 1;
            }
        }
        return res;
    }
}