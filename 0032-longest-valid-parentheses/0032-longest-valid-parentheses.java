class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index to calculate length
        int max = 0; // Stores the maximum valid length
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                stack.push(i); // Push index of '('
            } 
            else { // ch == ')'
                stack.pop(); // Pop the last '(' or base index
                
                if (stack.isEmpty()) {
                    stack.push(i); // Update base index if stack is empty
                } 
                else {
                    // Calculate current valid length and update max
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}