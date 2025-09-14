

class Solution {
    Set<String> exactWords = new HashSet<>();                 // stores original words
    Map<String, String> caseMap = new HashMap<>();            // lowercase : original word
    Map<String, String> vowelMap = new HashMap<>();           // masked vowels : original word

    private String toLower(String s) {
        return s.toLowerCase();
    }

    private String maskVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String checkForMatch(String query) {
        // 1. Exact match
        if (exactWords.contains(query)) {
            return query;
        }

        // 2. Case-insensitive match
        String lowerQuery = toLower(query);
        if (caseMap.containsKey(lowerQuery)) {
            return caseMap.get(lowerQuery);
        }

        // 3. Vowel-insensitive match
        String maskedQuery = maskVowels(lowerQuery);
        if (vowelMap.containsKey(maskedQuery)) {
            return vowelMap.get(maskedQuery);
        }

        // 4. No match
        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        exactWords.clear();
        caseMap.clear();
        vowelMap.clear();

        // Preprocess wordlist
        for (String word : wordlist) {
            exactWords.add(word);

            String lowerWord = toLower(word);
            caseMap.putIfAbsent(lowerWord, word);  // keep only first occurrence

            String maskedWord = maskVowels(lowerWord);
            vowelMap.putIfAbsent(maskedWord, word); // keep only first occurrence
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = checkForMatch(queries[i]);
        }
        return result;
    }
}