class Solution {
      public int maxAbsoluteSum(int[] A) {
        int sum=0;
        int min = 0;
        int  max = 0;
        for (int a: A) {
            sum += a;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        return max - min;
    }
}