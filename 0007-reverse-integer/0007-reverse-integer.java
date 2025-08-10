class Solution {
  public int reverse(int num) {
    
    long revers =0;
    while(num !=0){
    int digit =num % 10;

    revers =revers * 10 +digit;
    num/=10;
    if(revers>Integer.MAX_VALUE || revers< Integer.MIN_VALUE){
      return 0;
    }



    
  }
  return (int) revers;
}
}
