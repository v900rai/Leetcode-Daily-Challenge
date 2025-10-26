
class Solution {
    public long removeZeros(long n) {
        String s ="";
        while(n>0){
            long rem = n%10;
            if(rem!=0){
                s=rem+s;
            }
            n=n/10;
        }

         return Long.parseLong(s);

    }
}