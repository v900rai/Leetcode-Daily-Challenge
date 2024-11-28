class Solution {
    public int reverse(int num) {
        long reverse=0;
        int temp;
        while(num!=0){
            temp=num%10;
            reverse=reverse*10+temp;
            num=num/10;


            // ek adge case hona h es m ku ki dono condition m se ek true hona chaihiye
            
            if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) reverse;
        
    }
}