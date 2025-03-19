class Solution {
   
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push it to the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If it's a closing bracket, check if stack is empty or not matching
            else {
                if (stack.isEmpty()) {
                    return false; // No opening bracket for this closing bracket
                }

                char top = stack.pop(); // Get the last opened bracket

                // Check if the popped bracket matches the current closing bracket
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // If stack is empty, it means all brackets were matched properly
        return stack.isEmpty();
    }
}
// }
//     public static void main(String[] args) {
//         // Test cases
//         System.out.println(isValid("()"));       // ✅ true
//         System.out.println(isValid("()[]{}"));   // ✅ true
//         System.out.println(isValid("(]"));       // ❌ false
//         System.out.println(isValid("([)]"));     // ❌ false
//         System.out.println(isValid("{[]}"));     // ✅ true
//     }
// }
