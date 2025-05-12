class Solution {
    public int lengthOfLastWord(String s) {
      s=s.trim(); //remove the space 
      int n=s.length()-1;
     int  count=0;
      for(int i=n; i>=0; i--){
        if(s.charAt(i)==' '){
          break;
        }
        count++;
      }
        return count;
    }
}