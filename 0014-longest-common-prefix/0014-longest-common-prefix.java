class Solution {
    public String longestCommonPrefix(String[] strs) {
        // English: If the input array is null or empty, return an empty string
        // Hindi: अगर दिया हुआ array null या खाली है, तो empty string return कर दो
        if (strs == null || strs.length == 0) 
            return "";
        
        // English: Assume the first string as the initial prefix
        // Hindi: सबसे पहली string को prefix मान लो
        String prefix = strs[0];
        
        // English: Loop through the rest of the strings
        // Hindi: बाकी की सभी strings पर loop चलाओ
        for (int i = 1; i < strs.length; i++) {
            
            // English: Keep reducing the prefix until the current string starts with it
            // Hindi: जब तक current string इस prefix से शुरू नहीं होती, 
            // तब तक prefix को छोटा करते रहो
            while (strs[i].indexOf(prefix) != 0) {
                
                // English: Remove the last character from the prefix
                // Hindi: prefix का आखिरी character हटा दो
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // English: If prefix becomes empty, return ""
                // Hindi: अगर prefix खाली हो जाए तो empty string return कर दो
                if (prefix.isEmpty()) return "";
            }
        }
        
        // English: Return the longest common prefix
        // Hindi: सबसे बड़ा common prefix return कर दो
        return prefix;
    }
}
