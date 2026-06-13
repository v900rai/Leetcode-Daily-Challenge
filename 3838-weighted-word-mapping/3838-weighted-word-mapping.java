class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        // Final answer store karne ke liye
        StringBuilder ans = new StringBuilder();

        // Har word par iterate karo
        for (String word : words) {

            // Current word ka total weight
            int sum = 0;

            // Word ke har character par loop
            for (char ch : word.toCharArray())

                // Character ka weight add karo
                // 'a' -> index 0
                // 'b' -> index 1
                // ...
                // 'z' -> index 25
                sum += weights[ch - 'a'];

            // Sum ko 26 ke range me lao
            sum %= 26;

            // Character generate karo
            ans.append((char) ('z' - sum));
        }

        // Final string return karo
        return ans.toString();
    }
}