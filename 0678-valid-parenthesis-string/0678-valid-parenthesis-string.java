
class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            }
            else if (ch == ')') {
                low--;
                high--;
            }
            else { // ch == '*'
                low--;  // Treat * as ')'
                high++; // Treat * as '('
            }

            // Balance cannot be negative in any case
            if (high < 0) {
                return false;
            }

            // Minimum open brackets cannot be negative
            low = Math.max(low, 0);
        }

        // A valid string is possible if zero is in the range
        return low == 0;
    }
}
