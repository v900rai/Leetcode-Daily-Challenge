class Solution {
  public String toLowerCase(String str) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
      sb.append(Character.toLowerCase(str.charAt(i)));
    }
    return sb.toString();
  }
}