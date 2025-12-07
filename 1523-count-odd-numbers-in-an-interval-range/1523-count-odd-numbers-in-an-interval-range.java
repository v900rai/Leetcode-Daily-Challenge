class Solution {
    public int countOdds(int low, int high) {
      int totalDiff = high -low;
      int count = 0;
      if(high % 2 != 0){
        count++;
        totalDiff--;
      }
      if(low % 2 !=0){
        count++;
        totalDiff--;
      }
        count = count+totalDiff/2;
        return count;
    }
}