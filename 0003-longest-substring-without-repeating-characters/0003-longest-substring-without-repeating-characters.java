import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            
            char ch = s.charAt(right);

            // agar duplicate mila
            while (set.contains(ch)) {
                set.remove(s.charAt(left)); // left remove karo
                left++; // left aage badhao
            }

            set.add(ch); // current add karo

            // max update
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}