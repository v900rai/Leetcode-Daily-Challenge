import java.util.ArrayList;
import java.util.List;

class Solution {
    // Method to find indices of words containing character x
    public List<Integer> findWordsContaining(String[] words, char x) {
        // Create a list to store the indices of words containing the character x
        List<Integer> list = new ArrayList<>();
        // Loop through each word in the words array
        for(int i = 0; i < words.length; i++) {
            // Check if the current word contains the character x
            if(words[i].indexOf(x) != -1) {
                // If found, add the index to the list
                list.add(i);
            }
        }
        // Return the list of indices
        return list;
    }
}