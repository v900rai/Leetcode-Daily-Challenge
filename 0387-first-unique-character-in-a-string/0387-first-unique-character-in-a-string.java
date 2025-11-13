class Solution {
    public int firstUniqChar(String s) {

        // Map to store frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find the first character whose frequency is 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;   // index of first unique character
            }
        }

        // Step 3: No unique character found
        return -1;
    }
}
