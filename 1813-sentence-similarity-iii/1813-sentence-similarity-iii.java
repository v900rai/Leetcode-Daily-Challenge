class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split both sentences into words arrays
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        // Use two pointers: one starting from the beginning (left) and the other from the end (right)
        int i = 0; // Left pointer
        int j = 0; // Right pointer
        
        // Move the left pointer as long as the words match from the start
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        
        // Move the right pointer as long as the words match from the end
        while (j < words1.length - i && j < words2.length - i && 
               words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }
        
        // If the left pointer and right pointer together cover all the words in one sentence, they are similar
        return i + j >= Math.min(words1.length, words2.length);
    }
}
