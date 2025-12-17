class Solution {
    int [] prices;
    int k;
    Long dp[][][];
    final long NEG = (long) -1e11;
    int n;

    long dfs(int i,int t,int state){
        if(i == n){
            return state == 0 ? 0 : NEG;
        }

        if(dp[i][t][state] != null){
            return dp[i][t][state];
        }
        long ans = dfs(i+1,t,state);

        if(state == 0){
            ans = Math.max(ans,dfs(i+1,t,1)-prices[i]);
            ans = Math.max(ans,dfs(i+1,t,2)+prices[i]);
        }
        else if(state == 1 && t < k){
            ans = Math.max(ans,dfs(i+1,t+1,0)+prices[i]);
        }
        else if(state == 2 && t < k){
            ans = Math.max(ans,dfs(i+1,t+1,0)-prices[i]);
        }

        return dp[i][t][state] = ans;
    }

    public long maximumProfit(int[] prices, int k) {
        n = prices.length;
        this.k = k;
        this.prices = prices;
        dp = new Long[n+1][k+1][3];
        return dfs(0,0,0);
    }
}