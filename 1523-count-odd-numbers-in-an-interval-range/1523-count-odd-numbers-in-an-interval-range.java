class Solution {
  public int countOdds(int low, int high) {
    int total = high - low;
    int count = 0;
    if (high % 2 != 0) {
      count++;
      total--;
    }
    
    if (low % 2 != 0) {
      count++;
      total--;
    }
    
    count =count + total / 2;
    return count;

  }
}