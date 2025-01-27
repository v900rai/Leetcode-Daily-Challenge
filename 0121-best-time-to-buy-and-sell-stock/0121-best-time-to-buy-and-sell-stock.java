class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int min=prices[0];
        for(int i=0; i<prices.length; i++){
            int cost=prices[i]-min;
            maxProfit=Math.max(maxProfit, cost);
            min=Math.min(min, prices[i]);
        }
        return maxProfit;
        
    }
}