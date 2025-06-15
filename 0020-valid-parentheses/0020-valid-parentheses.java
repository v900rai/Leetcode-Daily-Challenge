class Solution {
  public boolean isValid(String s) {
    // Create a stack to keep track of expected closing brackets
    Stack<Character> stack = new Stack<>();
    
    // Iterate through each character in the input string
    for (char c : s.toCharArray()) {
      // If it's an opening bracket, push the corresponding closing bracket to stack
      if (c == '(')
        stack.push(')');
      
      // Same for curly braces
      else if (c == '{')
        stack.push('}');
      
      // Same for square brackets
      else if (c == '[')
        stack.push(']');
      
      // If it's a closing bracket
      else if (stack.isEmpty() || stack.pop() != c)
        // Return false if stack is empty (no matching opening bracket)
        // or if the popped bracket doesn't match the current closing bracket
        return false;
    }
    // After processing all characters, the stack should be empty for valid string
    return stack.isEmpty();
  }
}