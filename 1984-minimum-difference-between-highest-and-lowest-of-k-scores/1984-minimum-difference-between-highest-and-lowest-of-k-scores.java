class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int max=Integer.MAX_VALUE;
        for(int i=0;i+k<=nums.length;i++)
        { 
            max=Math.min(max,nums[i+k-1]-nums[i]);
        }
        if(max==Integer.MAX_VALUE)
        {
            return 0;
        }
        return max; 

    }
}