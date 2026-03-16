class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }

        // t ke jo characters abhi tak match nahi hue
        return t.length() - j;
    }
}