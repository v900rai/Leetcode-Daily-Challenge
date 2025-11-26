class Solution {
  public int missingNumber(int[] arr) {

    // int ans = 0;
    // for(int i=0; i<= nums.length; i++){
    //   ans = ans^i;
    // }
    // for(int i=0; i< nums.length; i++){
    //   ans = ans ^ nums[i];
    // }

    // return ans;
    int sum = 0;
    for (int n : arr)
      sum += n;
    int total = arr.length * (arr.length + 1) / 2;
    return total - sum;

  }
}