// class Solution {
//     public int missingNumber(int[] nums) {

//       int ans =0;
//       for(int i=0; i<= nums.length; i++){
//         ans = ans ^ i;
//       }
//       for(int i=0; i<nums.length; i++){
//         ans = ans^nums[i];
//       }
//       return ans;
        
//     }
// }
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        
        return res;       
    }
}