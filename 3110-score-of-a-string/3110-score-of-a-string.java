class Solution {
    public int scoreOfString(String s) {
      int score=0;
      int n=s.length();
      for(int i=0; i<n-1; i++){
        if(s.charAt(i)!=s.charAt(i+1))
        score=score+Math.abs(s.charAt(i)-s.charAt(i+1));
      }
      return score;

        
    }
}