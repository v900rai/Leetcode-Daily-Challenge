class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // s ke liye pointer
        int j = 0; // t ke liye pointer

        while (i < s.length() && j < t.length()) {
            // agar dono characters same hain
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        // agar s ke saare characters match ho gaye
        return i == s.length();
    }
}