class Solution {
    public long removeZeros(long n) {
        String s = "";  // To store digits (without zeros)
        
        while (n > 0) {
            long rem = n % 10;  // Extract last digit
            
            if (rem != 0) {
                s = rem + s;    // Add digit to front if it's not zero
            }
            
            n = n / 10;  // Remove last digit
        }
        
        // Convert the final string back to long and return
        return Long.parseLong(s);
    }
}
