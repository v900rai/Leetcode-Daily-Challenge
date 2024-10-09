class Solution {
    public int minAddToMakeValid(String s) {
        // Counters to track unmatched left and right parentheses
        int leftCount = 0;  // Unmatched '(' parentheses
        int rightCount = 0; // Unmatched ')' parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Unmatched opening parenthesis
                leftCount++;
            } else if (c == ')') {
                // If there's an unmatched '(', match it
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    // Otherwise, we have an unmatched closing parenthesis
                    rightCount++;
                }
            }
        }

        // Total additions required will be the sum of unmatched '(' and unmatched ')'
        return leftCount + rightCount;
    }
}
