class Solution {
    public int smallestNumber(int n) {
        int ans = 0;
        int pow = 0;
        while(n>0){
            n=n/2;
            ans+=Math.pow(2,pow);
            pow++;
        }

        return ans;
    }
}