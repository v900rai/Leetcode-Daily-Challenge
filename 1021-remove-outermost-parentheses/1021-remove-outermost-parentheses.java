class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder(); // final answer store karne ke liye
        int openCount = 0; // count karega kitne '(' abhi tak open hain

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Agar ye outermost '(' nahi hai to result me add karo
                if (openCount > 0) {
                    result.append(ch);
                }
                openCount++; // ek '(' open ho gaya
            } else {
                openCount--; // ek ')' close ho gaya
                // Agar ye outermost ')' nahi hai to result me add karo
                if (openCount > 0) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
