class Solution {
    public int reverse(int num) {
        long reverse=0;
        int temp;
        while(num!=0){
            temp=num%10;
            reverse=reverse*10+temp;
            num=num/10;
            if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) reverse;
        
    }
}