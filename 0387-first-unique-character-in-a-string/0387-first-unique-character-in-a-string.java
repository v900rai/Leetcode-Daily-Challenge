class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Create an array to store character frequencies
        int[] count = new int[26]; // Assuming only lowercase English letters
        
        // Step 2: Count the frequency of each character in the string
        for(char ch: s.toCharArray()){
            count[ch-'a']++;
            
        }
        
        // Step 3: Find the first character with a frequency of 1
        int n=s.length();
        for (int i = 0; i < n; i++) {
            char ch=s.charAt(i);
            if(count[ch-'a']==1){
                return i;
            }
        }
        
        // Step 4: If no unique character is found, return -1
        return -1;
    }
}
