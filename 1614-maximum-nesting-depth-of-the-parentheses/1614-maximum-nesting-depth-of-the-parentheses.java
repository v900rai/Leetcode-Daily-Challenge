class Solution {
    public int maxDepth(String s) {

        // Current depth of nested parentheses
        int depth = 0;

        // Store the maximum depth found so far
        int maxDepth = 0;

        // Convert the string into a character array
        // and traverse each character one by one
        for (char c : s.toCharArray()) {

            // Check if the current character is an opening parenthesis
            if (c == '(') {

                // Increase the current depth by 1
                depth++;

                // Check if the current depth is greater
                // than the maximum depth found so far
                if (depth > maxDepth) {

                    // Update the maximum depth
                    maxDepth = depth;
                }

            }
            // Check if the current character is a closing parenthesis
            else if (c == ')') {

                // Decrease the current depth by 1
                // because one level of nesting is completed
                depth--;
            }
        }

        // Return the maximum nesting depth
        return maxDepth;
    }
}