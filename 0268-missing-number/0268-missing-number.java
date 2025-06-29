class Solution {
    // public int missingNumber(int[] nums) {
    //   int ans=0;
    //   int n=nums.length;
    //   for(int i=0; i<=n; i++){
    //     ans=ans^i;// 0;
    //   }
    //   for(int i=0; i<n; i++){
    //     ans=ans^nums[i];
    //   }
    //   return ans;
        
    // }


public int missingNumber(int[] nums) {
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
        xor ^= nums[i] ^ (i + 1);
    }
    return xor;
}
}