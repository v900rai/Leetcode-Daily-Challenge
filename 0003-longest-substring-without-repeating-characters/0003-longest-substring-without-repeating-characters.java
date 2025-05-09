class Solution {
  public int lengthOfLongestSubstring(String s) {
    int n = s.length(); // Get the length of the input string

    int maxLength = 0; // To store the length of the longest substring without repeating characters

    int left = 0; // Left pointer of the sliding window
    Set<Character> charSet = new HashSet<>(); // HashSet to store characters in the current window (no duplicates allowed)

    // Iterate over the string using right pointer
    for (int right = 0; right < n; right++) {
      // If the character at 'right' is not already in the set, it's safe to add
      if (!charSet.contains(s.charAt(right))) {
        charSet.add(s.charAt(right)); // Add character to the set
        // Update the maximum length of substring found so far
        maxLength = Math.max(maxLength, right - left + 1);
      } else {
        // If character is already in the set (duplicate found), we need to move the left pointer
        while (charSet.contains(s.charAt(right))) {
          charSet.remove(s.charAt(left)); // Remove characters from the left until duplicate is removed
          left++; // Move left pointer forward
        }
        // After removing the duplicate, add the current character
        charSet.add(s.charAt(right));
      }
    }

    return maxLength; // Return the length of the longest substring without repeating characters
  }
}
