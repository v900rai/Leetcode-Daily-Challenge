class Solution {
    public int maxProfit(int[] price) {
        int maxProfit = 0; // Initialize with 0 as no profit is made yet
        int minSofar = price[0]; // First element as the initial minimum
        
        for(int i = 0; i < price.length; i++){
            minSofar = Math.min(minSofar, price[i]); // Update minimum price
            int profit = price[i] - minSofar; // Calculate profit with the current price
            maxProfit = Math.max(maxProfit, profit); // Update maxProfit
        }
        
        return maxProfit;
    }
}
