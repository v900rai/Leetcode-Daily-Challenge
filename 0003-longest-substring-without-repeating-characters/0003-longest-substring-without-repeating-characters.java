class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet<>();
      int left =0;
      int maxLength = 0;

      for(int right = 0; right<s.length(); right++){
        char ch = s.charAt(right);
        while(set.contains(ch)){ // ager mil gya to 

        set.remove(s.charAt(left)); /// remove 

        left++;
      }
      //agr nii mila to 
      set.add(ch);
      maxLength = Math.max(maxLength, right-left+1);

        
    }
    return maxLength;
}
}