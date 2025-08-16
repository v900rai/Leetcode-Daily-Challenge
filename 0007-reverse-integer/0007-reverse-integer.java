class Solution {
    public int reverse(int nums) {
      long revers =0;
      while(nums!=0){
        int digit =nums%10;
        revers =revers*10+digit;
        nums=nums/10;
      }
      if(revers>Integer.MAX_VALUE || revers<Integer.MIN_VALUE){
        return 0;
      }
      return (int) revers;
    }
        
    
}