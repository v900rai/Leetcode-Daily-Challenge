class Solution {
    public int binaryGap(int n) {
        int dis = 0;
        int max = Integer.MIN_VALUE;

        while(n>0){
            int last = n & 1;
            n >>= 1;
            if(last==1){
                max = Math.max(max,dis);
                dis = 1;
            }else if(dis > 0){
                dis++;
            }
        }
        return max;
    }
}