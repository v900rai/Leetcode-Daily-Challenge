import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (seen.add(n)) {  // अगर n पहले से set में नहीं है, तो उसे add करो
            int sumOfSquares = 0;
            
            while (n > 0) {
                int digit = n % 10;
                sumOfSquares += digit * digit;
                n /= 10;
            }
            
            if (sumOfSquares == 1) return true;
            n = sumOfSquares;
        }
        
        return false;  // Cycle detect हो गई, मतलब happy number नहीं है
    }
}
