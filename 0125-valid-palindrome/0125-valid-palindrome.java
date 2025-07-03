class Solution {
    // Method to check if the given string is a palindrome (ignoring non-alphanumeric characters and case)
    public boolean isPalindrome(String s) {
        // Initialize two pointers: one from the start and one from the end of the string
        int left = 0;
        int right = s.length() - 1;

        // Loop until the two pointers meet or cross
        while (left < right) {
            // Move the left pointer to the right if current character is not a letter or digit
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++; // skip non-alphanumeric characters from the left
            }
            // while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            //   left++;
            // }

            // Move the right pointer to the left if current character is not a letter or digit
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--; // skip non-alphanumeric characters from the right
            }

            // Convert characters to lowercase and compare them
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // If characters do not match, it's not a palindrome
                return false;
            }

            // Move both pointers towards the center for next comparison
            left++;
            right--;
        }

        // If loop completes without returning false, the string is a palindrome
        return true;
    }
}
