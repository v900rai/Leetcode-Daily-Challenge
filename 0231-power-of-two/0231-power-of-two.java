class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean val=false;
        if(n==0)
        return false;
        else if(n==1)
        return true;
        while(n!=1)
        {
            if(n%2!=0){
                val=false;
                break;
            }
            else{
                val=true;
            }
            n=n/2;
        }
        return val;
        
        
    }

}