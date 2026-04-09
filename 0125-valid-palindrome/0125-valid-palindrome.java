
class Solution {
  public boolean isPalindrome(String s) {
    int start = 0;
    int end   = s.length()-1;
    while(start <end){
      
      while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
        start++;
      }
      while(start <end && !Character.isLetterOrDigit(s.charAt(end))){
        end--;
      }
      
      
      char endchar = Character.toLowerCase(s.charAt(end));
      char startchar = Character.toLowerCase(s.charAt(start));
      if (startchar != endchar) {
        return false;
      }
       // Move both pointers towards the center
      start++;
      end--;
    }

    // If all characters matched, it's a palindrome
    return true;

    }
}
