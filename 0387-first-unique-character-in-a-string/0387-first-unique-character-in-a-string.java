// class Solution {
//     public int firstUniqChar(String s) {
//         // Step 1: Create an array to store character frequencies
//         int[] count = new int[26]; // Assuming only lowercase English letters
        
//         // Step 2: Count the frequency of each character in the string
//         for(char ch: s.toCharArray()){
//             count[ch-'a']++;
            
//         }
        
//         // Step 3: Find the first character with a frequency of 1
//         int n=s.length();
//         for (int i = 0; i < n; i++) {
//             char ch=s.charAt(i);
//             if(count[ch-'a']==1){
//                 return i;
//             }
//         }
        
//         // Step 4: If no unique character is found, return -1
//         return -1;
//     }
// }



class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Create a HashMap to store frequency of each character
        Map<Character, Integer> mp = new HashMap<>();

        // Step 2: Traverse the string and count frequency of each character
        for (char a : s.toCharArray()) {
            mp.put(a, mp.getOrDefault(a, 0) + 1); // Increment frequency
        }

        // Step 3: Traverse the string again to find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i)) == 1) {
                return i; // Return the index of first unique character
            }
        }

        // Step 4: If no unique character found, return -1
        return -1;
    }
}
