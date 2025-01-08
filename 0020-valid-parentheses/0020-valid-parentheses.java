
class Solution {
    public boolean isValid(String s) {
        // Stack to hold opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse through each character in the string
        for (char c : s.toCharArray()) {
            // Push opening brackets to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Check for closing brackets and match with top of stack
            else if (c == ')' || c == '}' || c == ']') {
                // If stack is empty or top of the stack doesn't match, return false
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If stack is empty, all parentheses were matched; otherwise, it's invalid
        return stack.isEmpty();
    }
}
