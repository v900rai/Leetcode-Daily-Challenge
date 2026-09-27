import java.util.*;

class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening bracket
            if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                // Characters ko reverse karte hue nikaalo
                StringBuilder temp = new StringBuilder();

                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                // '(' remove karo
                stack.pop();

                // Reversed characters wapas stack mein daalo
                for (char c : temp.toString().toCharArray()) {
                    stack.push(c);
                }
            }

            // Normal character
            else {
                stack.push(ch);
            }
        }

        // Stack se final answer banao
        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}