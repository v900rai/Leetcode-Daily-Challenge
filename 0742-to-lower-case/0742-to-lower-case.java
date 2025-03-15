class Solution {
  public String toLowerCase(String str) {
    // inbuiled methods are use sometimes are not satiesfied interviewers' thats why
    // i will use simple methods
    // return s.toLowerCase();

    // StringBuilder st=new StringBuilder();

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
      sb.append(Character.toLowerCase(str.charAt(i)));
    }
    return sb.toString();
  }
}