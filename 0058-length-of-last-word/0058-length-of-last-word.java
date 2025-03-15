class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // शुरुआत और अंत की स्पेस हटाएं
      int n=s.length()-1;
      int LengthWrd=0;
      for(int i=n; i>=0; i--){
        if(s.charAt(i)==' '){
          break;
        }
        LengthWrd++;

      }
      return LengthWrd;
    }
}
