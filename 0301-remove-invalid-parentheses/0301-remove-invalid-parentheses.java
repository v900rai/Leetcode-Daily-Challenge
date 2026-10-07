import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        // BFS queue
        Queue<String> queue = new LinkedList<>();

        // Duplicate strings avoid करने के लिए
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check whether current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // अगर valid मिल गया,
            // तो आगे characters remove करने की जरूरत नहीं
            if (found) {
                continue;
            }

            // हर character को एक-एक करके remove करो
            for (int i = 0; i < current.length(); i++) {

                // केवल parentheses remove करेंगे
                char ch = current.charAt(i);

                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next =
                    current.substring(0, i)
                    + current.substring(i + 1);

                // अगर पहले नहीं देखा है
                if (!visited.contains(next)) {

                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }


    // Valid parentheses check
    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;
            }

            // ')' ज्यादा हो गया
            if (count < 0) {
                return false;
            }
        }

        // '(' और ')' बराबर होने चाहिए
        return count == 0;
    }
}