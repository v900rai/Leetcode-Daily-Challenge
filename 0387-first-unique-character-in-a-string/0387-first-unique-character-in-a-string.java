class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Create an array to store character frequencies
        int[] charCount = new int[26]; // Assuming only lowercase English letters
        
        // Step 2: Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++; // Map 'a' to index 0, 'b' to 1, ..., 'z' to 25
        }
        
        // Step 3: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }
        
        // Step 4: If no unique character is found, return -1
        return -1;
    }
}
