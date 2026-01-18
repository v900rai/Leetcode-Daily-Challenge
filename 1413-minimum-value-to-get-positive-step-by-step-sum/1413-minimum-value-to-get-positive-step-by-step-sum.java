class Solution {
     public static int minStartValue(int[] nums) {
        int total = 0;
        int nev = 0;
        for(int x : nums){
            total = total + x;
            if(total < nev){
                nev = total;
            }
        }

        return Math.abs(nev) +1;
    }
}