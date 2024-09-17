

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Step 2: Use a HashMap to count occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Step 3: Find words that appear only once
        List<String> uncommonWords = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        
        // Step 4: Convert the list of uncommon words to an array and return
        return uncommonWords.toArray(new String[0]);
    }
}
