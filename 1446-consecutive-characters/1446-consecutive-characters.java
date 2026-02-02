class Solution {
  public int maxPower(String s) {
    int maxCharacter = 1;
    int len = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        len++;
      } else {
        if (maxCharacter < len) {
          maxCharacter= len;
        }
        len = 1;
      }
    }
    if (maxCharacter < len) {
      maxCharacter = len;
    }

    return maxCharacter;

  }
}