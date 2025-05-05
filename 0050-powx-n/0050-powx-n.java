class Solution {
    public double myPow(double x, int n) {
        // Convert n to long to safely handle Integer.MIN_VALUE
        long N = n;

        // If n is negative, convert it to positive and take reciprocal of x
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;

        // Fast exponentiation using bit manipulation
        while (N > 0) {
            if ((N % 2) == 1) {
                result *= x;
            }
            x *= x;       // Square the base
            N /= 2;       // Halve the exponent
        }

        return result;
    }
}
