class Solution {
    public String reverseWords(String s) {
        // Split the input string into an array of words, removing extra spaces
        // "\\s+" matches one or more spaces
        String[] words = s.split("\\s+");

        // Use StringBuilder to efficiently build the reversed string
        StringBuilder res = new StringBuilder();

        // Loop through the words array from the end to the beginning
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]); // Add the current word to the result
            if (i != 0) { // If it's not the last word, add a space
                res.append(" ");
            }
        }

        // Convert the StringBuilder to a string and return it
        // Use trim() to ensure no leading or trailing spaces
        return res.toString().trim();
    }
}
