class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            // If the string length is odd, it cannot be valid
            return false;
        }
        
        // Left-to-right pass
        int openCount = 0; // Tracks potential '(' count
        int balance = 0;   // Tracks current balance of parentheses
        
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                // If the character is locked
                if (s.charAt(i) == '(') {
                    openCount++;
                } else {
                    openCount--;
                }
            } else {
                // If the character is unlocked
                openCount++; // Treat it as '(' for now
            }
            balance++;
            
            if (openCount < 0) {
                // More ')' than '(' at this point, not valid
                return false;
            }
        }
        
        // Right-to-left pass
        int closeCount = 0; // Tracks potential ')' count
        balance = 0;        // Reset balance for reverse pass
        
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    closeCount++;
                } else {
                    closeCount--;
                }
            } else {
                closeCount++; // Treat it as ')' for now
            }
            balance++;
            
            if (closeCount < 0) {
                // More '(' than ')' at this point, not valid
                return false;
            }
        }
        
        return true;
    }
}
