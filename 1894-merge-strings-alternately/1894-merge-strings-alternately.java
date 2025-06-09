class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Initialize a StringBuilder to efficiently build the merged string
        StringBuilder result = new StringBuilder();
        
        // Initialize a pointer to traverse both strings
        int i = 0;
        
        // Loop until we reach the end of either word1 or word2
        while (i < word1.length() || i < word2.length()) {
            // If the current index is within word1's bounds, append the character
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            // If the current index is within word2's bounds, append the character
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            // Move to the next index
            i++;
        }
        
        // Convert the StringBuilder to a String and return
        return result.toString();
    }
}