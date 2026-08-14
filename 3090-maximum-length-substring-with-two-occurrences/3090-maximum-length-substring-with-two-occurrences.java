class Solution {
    public int maximumLengthSubstring(String s) {

        int[] freq = new int[26];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Current character ki frequency increase karo
            freq[s.charAt(right) - 'a']++;

            // Agar current character 2 se zyada ho gaya
            // to left se window shrink karo
            while (freq[s.charAt(right) - 'a'] > 2) {

                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // Current valid window ki length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}