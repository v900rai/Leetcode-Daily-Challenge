class Solution {
    public int minimumDistance(int[] nums) {

      int len = nums.length;
      int minDist= Integer.MAX_VALUE;
       boolean hasTriplet = false;


      for(int a =0; a<len; a++){
        for(int b= a+1; b<len; b++){
          for(int c= b+1; c<len; c++){
            if(nums[a]==nums[b] && nums[b]==nums[c]){
              hasTriplet = true;
              int totalDist = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
              if(totalDist<minDist){
                minDist=totalDist;
              }
            }
          }
        }
      }
      return hasTriplet? minDist:-1;
        
    }
}