
class Solution {
    public int minLength(String s) {
        // Initialize a stack to process the string
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (char ch : s.toCharArray()) {
            // Check the top of the stack for pairs "AB" or "CD"
            if (!stack.isEmpty()) {
                if (ch == 'B' && stack.peek() == 'A') {
                    // Found "AB", pop the 'A'
                    stack.pop();
                    continue;
                } else if (ch == 'D' && stack.peek() == 'C') {
                    // Found "CD", pop the 'C'
                    stack.pop();
                    continue;
                }
            }
            // If no pairs found, push the character to the stack
            stack.push(ch);
        }

        // The remaining size of the stack is the length of the resultant string
        return stack.size();
    }

}
