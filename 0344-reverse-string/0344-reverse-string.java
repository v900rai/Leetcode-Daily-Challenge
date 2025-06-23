class Solution {
    public void reverseString(char[] s) {
        // Initialize two pointers: one at the start (left) and one at the end (right) of the array
        int left = 0;
        int right = s.length - 1;
        
        // Loop until the two pointers meet in the middle
        while (left < right) {
            // Swap the characters at the left and right pointers
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move the left pointer forward and the right pointer backward
            left++;
            right--;
        }
    }
}