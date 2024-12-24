class Solution {
    public int[] plusOne(int[] digit) {
        int n=digit.length;
        for(int i=digit.length-1; i>=0; i--){
            
            if(digit[i]!=9){
                digit[i]++;
                break;
            }
            else{
                digit[i]=0;
            }
        }
     if(digit[0]==0){
        int [] res=new int [n+1];
        res[0]=1;
        return res;
     }
     return digit;
        
    }
}