class Solution {

    private static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // pow10[i] = 10^i % MOD
        long[] pow10 = new long[n + 1];

        // digitSum[i] = first i digits ka sum
        long[] digitSum = new long[n + 1];

        // nonZeroCount[i] = first i characters me kitne non-zero digits hain
        int[] nonZeroCount = new int[n + 1];

        // prefixNumber[i] =
        // first i characters ke non-zero digits concatenate karke bana number
        long[] prefixNumber = new long[n + 1];


        // -------------------------
        // STEP 1: Powers of 10
        // -------------------------

        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {

            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }


        // -------------------------
        // STEP 2: Build Prefix Arrays
        // -------------------------

        for (int i = 1; i <= n; i++) {

            int digit = s.charAt(i - 1) - '0';


            // Prefix digit sum
            digitSum[i] = digitSum[i - 1] + digit;


            // Initially previous values copy karo
            nonZeroCount[i] = nonZeroCount[i - 1];

            prefixNumber[i] = prefixNumber[i - 1];


            // Sirf non-zero digit ko concatenate karenge
            if (digit != 0) {

                nonZeroCount[i]++;

                prefixNumber[i] =
                        (prefixNumber[i - 1] * 10 + digit) % MOD;
            }
        }


        // -------------------------
        // STEP 3: Process Queries
        // -------------------------

        int[] answer = new int[queries.length];


        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];

            int right = queries[i][1];


            // Substring ka digit sum
            long sum =
                    digitSum[right + 1] - digitSum[left];


            // Substring me non-zero digits ki count
            int count =
                    nonZeroCount[right + 1]
                    - nonZeroCount[left];


            /*
             prefixNumber[right + 1]

             Structure:

             prefixNumber[left] * 10^count
                        +
             requiredNumber


             Therefore:

             requiredNumber =

             prefixNumber[right + 1]
             -
             prefixNumber[left] * 10^count
            */


            long number =

                    (prefixNumber[right + 1]

                    - (prefixNumber[left] * pow10[count]) % MOD

                    + MOD) % MOD;


            // Final Answer

            answer[i] = (int) ((number * (sum % MOD)) % MOD);
        }


        return answer;
    }
}