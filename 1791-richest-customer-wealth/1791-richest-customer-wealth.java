class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for(int person =0; person <accounts.length;person++){
            int sum =0;
            for(int i =0;  i<accounts[person].length; i++){
                sum+=accounts[person][i];
            }
            if(sum>ans)
            {
                ans =sum;
            }
        }
        return ans;
    }
}