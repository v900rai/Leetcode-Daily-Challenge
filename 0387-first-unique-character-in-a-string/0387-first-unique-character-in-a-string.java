class Solution {
    public int firstUniqChar(String s) {

      Map<Character, Integer> map = new HashMap<>();

      for( char ch : s.toCharArray()){
      //  map.put(ch, getOrDefault(ch, 0)+1);
         map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
      for(int i=0; i<s.length(); i++){
        if(map.get(s.charAt(i))==1){
          return i;

        }
      }
        return -1;
    }
}
// }
// class Solution {
//     public int firstUniqChar(String s) {
//         // Step 1: Create a HashMap to store frequency of each character
//         Map<Character, Integer> mp = new HashMap<>();

//         // Step 2: Traverse the string and count frequency of each character
//         for (char a : s.toCharArray()) {
//             mp.put(a, mp.getOrDefault(a, 0) + 1); // Increment frequency
//         }

//         // Step 3: Traverse the string again to find the first character with frequency 1
//         for (int i = 0; i < s.length(); i++) {
//             if (mp.get(s.charAt(i)) == 1) {
//                 return i; // Return the index of first unique character
//             }
//         }

//         // Step 4: If no unique character found, return -1
//         return -1;
//     }
// }