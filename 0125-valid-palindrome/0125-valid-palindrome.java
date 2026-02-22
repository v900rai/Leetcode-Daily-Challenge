
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
      char startchar = Character.toLowerCase(s.charAt(start));
      
      char endchar = Character.toLowerCase(s.charAt(end));
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


//     int start = 0; // Pointer at the beginning of the string
//     int end = s.length() - 1; // Pointer at the end of the string

//     while (start < end) {
//       // Skip non-alphanumeric characters from the left
      
    
     
//       while(start< end && !Character.isLetterOrDigit(s.charAt(start))){
//         start++;
//       }

//       // Skip non-alphanumeric characters from the right
//       while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
//         end--;
//       }

//       // Convert both characters to lowercase and compare

//       char startchar = Character.toLowerCase(s.charAt(start));
      
//       char endchar = Character.toLowerCase(s.charAt(end));

//       // If characters don't match, it's not a palindrome
//       if (startchar != endchar) {
//         return false;
//       }

//       // Move both pointers towards the center
//       start++;
//       end--;
//     }

//     // If all characters matched, it's a palindrome
//     return true;
//   }
// }
