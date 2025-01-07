import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        // Iterate through each word and check if it's a substring of another word
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Skip if it's the same word
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further for this word
                }
            }
        }

        return result;
    }
}
