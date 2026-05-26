class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> st=new HashSet<>();
        int cnt=0;
        for(int i=0;i<word.length();i++)
        {
           if(word.charAt(i)>='A' && word.charAt(i)<='Z')
           st.add(word.charAt(i));
        }
         for(int i=0;i<word.length();i++)
         {
          if(word.charAt(i)>='a' && word.charAt(i)<='z'&&  st.contains(Character.toUpperCase(word.charAt(i))))
          {
          cnt++;
          st.remove(Character.toUpperCase(word.charAt(i)));
          }
         }
         return cnt;
    }
}