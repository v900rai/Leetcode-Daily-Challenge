class Solution {
  public int addDigits(int num) {
    while (num / 10 >= 1) {
      int d = num % 10;
      num /= 10;
      num += d;
    }
    return num;
  }
}