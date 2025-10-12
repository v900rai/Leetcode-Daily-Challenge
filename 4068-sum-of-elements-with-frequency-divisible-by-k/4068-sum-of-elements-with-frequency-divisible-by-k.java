class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
      int [] freq = new int[101];
      for(int num :nums){
        freq[num]++;
      }
      int sum =0;
      for(int num : nums){
        if(freq[num] % k ==0){
          sum = sum+num;
        }
      }
      return sum;
        
    }
}