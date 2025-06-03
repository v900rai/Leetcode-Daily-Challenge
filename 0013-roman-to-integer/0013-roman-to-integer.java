class Solution {
    public int romanToInt(String s) {
        int ans = 0;  // Final result
        int num = 0;  // Holds the value of the current Roman character

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // Map the current Roman character to its corresponding integer value
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }

            // If current value is less than one-fourth of ans, subtract it
            // This handles cases like IV (4), IX (9), etc.
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }

        return ans;  // Return the final integer value
    }
}
