class Solution {
    public int countDigits(int num) {
        int count=0;
        int val=num;
        while(num>0){
            int dig=num%10;
            if(val%dig==0){
                count++;
            }
            num/=10;
        }
        return count;
    }
}