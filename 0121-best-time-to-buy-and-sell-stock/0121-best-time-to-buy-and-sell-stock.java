class Solution {

    public int maxProfit(int[] prices) {

        // Ab tak ka minimum buying price
        int minPrice = prices[0];

        // Maximum profit
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Agar aaj sell karein to profit
            int currentProfit = prices[i] - minPrice;

            // Maximum profit update
            maxProfit = Math.max(maxProfit, currentProfit);

            // Minimum buying price update
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}