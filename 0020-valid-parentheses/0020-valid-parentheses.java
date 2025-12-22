import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        // har character par loop
        for (char ch : s.toCharArray()) {

            // 1️⃣ opening bracket → push
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            // 2️⃣ closing bracket
            else {

                // stack empty hai to invalid
                if (st.isEmpty())
                    return false;

                char top = st.pop();

                // matching check
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // agar stack empty → valid
        return st.isEmpty();
    }
}
