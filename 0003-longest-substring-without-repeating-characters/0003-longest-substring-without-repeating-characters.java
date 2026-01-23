import java.util.*;

class Solution {

    // Function to find the length of the longest substring
    // without repeating characters
    public int lengthOfLongestSubstring(String s) {

        // Set to store unique characters of current window
        Set<Character> set = new HashSet<>();

        // Left pointer of sliding window
        int left = 0;

        // Variable to store maximum length found
        int maxLen = 0;

        // Right pointer moves from start to end of string
        for (int right = 0; right < s.length(); right++) {

            // If current character already exists in the set
            // then remove characters from the left side
            // until the duplicate character is removed
            while (set.contains(s.charAt(right))) {

                // Remove character at left pointer from set
                set.remove(s.charAt(left));

                // Move left pointer forward
                left++;
            }

            // Add current character to the set
            set.add(s.charAt(right));

            // Calculate window size and update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the maximum length found
        return maxLen;
    }
}
