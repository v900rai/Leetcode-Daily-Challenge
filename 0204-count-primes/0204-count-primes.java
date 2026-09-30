public class Solution {
    public int countPrimes(int n) {

        // Initially, assume all numbers are prime
        boolean[] notPrime = new boolean[n];

        // Stores the count of prime numbers
        int count = 0;

        // Start checking from 2 because 0 and 1 are not prime
        for (int i = 2; i < n; i++) {

            // If i is not marked, it is a prime number
            if (notPrime[i] == false) {

                // Increase prime count
                count++;

                // Mark all multiples of i as non-prime
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        // Return total prime numbers
        return count;
    }
}