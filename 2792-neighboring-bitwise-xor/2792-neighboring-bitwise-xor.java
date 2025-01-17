class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res=0;
        for(int val : derived ){
            res=res ^ val;

            // val ko ->>> o[i] xor o[i+1]

        }
        return (res==0);
        
    }
}