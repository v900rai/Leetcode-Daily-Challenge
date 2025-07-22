// class Solution {
  
//     public String longestCommonPrefix(String[] v) {
//         StringBuilder ans = new StringBuilder();
//         Arrays.sort(v);
//         String first = v[0];
//         String last = v[v.length-1];
//         for (int i=0; i<Math.min(first.length(), last.length()); i++) {
//             if (first.charAt(i) != last.charAt(i)) {
//                 return ans.toString();
//             }
//             ans.append(first.charAt(i));
//         }
//         return ans.toString();
//     }
// }
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) 
    return "";
    
    String prefix = strs[0];
    
    for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    
    return prefix;
}
}
