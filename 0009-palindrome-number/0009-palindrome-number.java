class Solution {
     public boolean isPalindrome(int m) {
        boolean flag=true;
        if(m<0){
            return false;
        }
        long rev=0;
        int temp=m;
        while(temp !=0){
            int digit=(temp %10);
            rev=rev*10+digit;
            temp=temp/10;
        }
        return (rev==m);

        
    }
}