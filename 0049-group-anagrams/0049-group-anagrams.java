import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // एक HashMap जिसका key होगा sorted string और value होगी words की list जो anagram हैं
        Map<String, List<String>> map = new HashMap<>();
        
        // सभी शब्दों पर iterate करें
        for (String word : strs) {
            // शब्द को character array में बदलें और उसे sort करें
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            // यदि sortedWord पहले से map में नहीं है, तो एक नई list बनाएँ
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            // SortedWord वाले group में current word जोड़ें
            map.get (sortedWord).add(word);
        }
        
        // सभी values (anagram groups) को एक list में बदलकर return करें
        return new ArrayList<>(map.values());
    }
}
