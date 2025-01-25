class Solution {
    public int maximumWealth(int[][] nums) {
        int vishu = Integer.MIN_VALUE;
        for(int i=0; i <nums.length;i++){
            int sum =0;
            for(int j =0 ;j<nums[i].length;j++){
                sum+=nums[i][j];
            }
            if(sum>vishu)
            {
                vishu =sum;
            }
        }
        return vishu;
    }
}