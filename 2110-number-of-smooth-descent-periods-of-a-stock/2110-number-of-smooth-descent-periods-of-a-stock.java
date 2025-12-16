class Solution {
    public long getDescentPeriods(int[] prices) {
        // Store the array length in variable 'n'
        int n = prices.length;
        
        // If there's only one element, there's exactly one descent period
        if (n == 1) return 1;
        
        // Initialize 'nb' (total number of descent periods found so far)
        // If the first two elements are not consecutive in descending order, start with 1
        // Otherwise, initialize with 0 since it will be counted later
        long nb = prices[0] - prices[1] != 1 ? 1 : 0;
        
        // 'sub' tracks the number of descent periods in the current continuous descending sequence
        long sub = prices[0] - prices[1] != 1 ? 0 : 1;
        
        // 'count' tracks the current streak length of successive descending elements
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            // Check whether the current pair (prices[i-1], prices[i]) forms a descending step by 1
            if (prices[i - 1] - prices[i] == 1) {
                // Continue the descending sequence
                count++;
                sub += count;
                
                // If we reached the end of the array, merge the current sub-result into total
                if (i == n - 1) nb += sub;
            } else {
                // The sequence broke — add the accumulated 'sub' to the total
                nb += sub;
                
                // If this is the last element and no sequence continuation, count it as 1
                if (i == n - 1) nb++;
                
                // Reset 'sub' and 'count' for the next descent sequence
                sub = 1;
                count = 1;
            }
        }
        
        // Return the total number of descent periods
        return nb;
    }
}