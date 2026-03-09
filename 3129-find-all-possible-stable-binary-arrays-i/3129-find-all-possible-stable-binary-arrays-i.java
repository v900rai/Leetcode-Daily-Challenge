import java.util.*;

class Solution {

    final int mod = 1_000_000_007;
    final int[][][] arr = new int[201][201][2];

    public int numberOfStableArrays(int zero, int one, int limit) {

        for(int i=0;i<201;i++){
            for(int j=0;j<201;j++){
                Arrays.fill(arr[i][j], -1);
            }
        }

        int startwithone = solve(zero, one, true, limit);
        int startwithzero = solve(zero, one, false, limit);

        return (startwithone + startwithzero) % mod;
    }

    public int solve(int zeroes, int ones, boolean isitOnes, int limit){

        if(zeroes < 0 || ones < 0) return 0;

        if(zeroes == 0 && ones == 0) return 1;

        int idx = isitOnes ? 1 : 0;

        if(arr[zeroes][ones][idx] != -1)
            return arr[zeroes][ones][idx];

        int result = 0;

        if(isitOnes){

            for(int i = 1; i <= Math.min(ones, limit); i++){
                result = (result + solve(zeroes, ones - i, false, limit)) % mod;
            }

        }else{

            for(int i = 1; i <= Math.min(zeroes, limit); i++){
                result = (result + solve(zeroes - i, ones, true, limit)) % mod;
            }
        }

        return arr[zeroes][ones][idx] = result;
    }
}