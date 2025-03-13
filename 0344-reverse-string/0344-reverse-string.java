class Solution {

  public void reverseString(char[] s) {
    int left=0;
    int right=s.length-1;
    while(left<right){
        char temp=s[left];
        s[left]=s[right];
        s[right]=temp;
        left++;
        right--;
    }
  }
}


//      public class Solution {
//     public String reverseString(String s) {

    // jb String parameterized m string s to us ko char k cob=nvert krna padega
//         char[] word = s.toCharArray();
//         int i = 0;
//         int j = s.length() - 1;
//         while (i < j) {
//             char temp = word[i];
//             word[i] = word[j];
//             word[j] = temp;
//             i++;
//             j--;
//         }
//         return new String(word);
//     }
// }   
    
