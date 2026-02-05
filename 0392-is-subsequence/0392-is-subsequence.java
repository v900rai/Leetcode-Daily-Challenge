class Solution {

    public boolean isSubsequence(String s, String t) {

        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {

            // If characters match
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move s pointer
            }

            // Always move t pointer
            j++;
        }

        // If i reached end -> subsequence found
        return i == s.length();
    }
}
