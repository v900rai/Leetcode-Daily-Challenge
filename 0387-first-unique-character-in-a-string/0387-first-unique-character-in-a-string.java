class Solution {
    public int firstUniqChar(String s) {

      Map<Character , Integer> map = new HashMap<>();

      for( char ch : s.toCharArray()){
        map.put(ch ,getOrDefault(s,0)+1);

        if(map.get(charAt(i)==1)){
          return i;
        }
      }
      return -1;
        
    }
}