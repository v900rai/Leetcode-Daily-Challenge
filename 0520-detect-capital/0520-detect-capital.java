class Solution {
    public boolean detectCapitalUse(String word) {
        // Check if all characters in the word are uppercase

        if (word.equals(word.toUpperCase())) {
            return true;
        }
        
        // Check if all characters in the word are lowercase
        
        if (word.equals(word.toLowerCase())) {
            return true;
        }
        
        // Check if only the first character is uppercase and the rest are lowercase
        if (Character.isUpperCase(word.charAt(0)) && 
            word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        
        // If none of the conditions are met, return false
        return false;
    }
}
