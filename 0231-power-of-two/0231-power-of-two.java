class Solution {

    public boolean isPowerOfTwo(int n) {

        // Step 1: Agar n 0 ya negative hai → power of 2 nahi ho sakta
        if (n <= 0) return false;

        // Step 2: Base case
        // 2^0 = 1 → isliye agar n == 1, to true
        if (n == 1) {
            return true;
        }

        // Step 3: Agar number odd hai (2 se divide nahi hota)
        // to power of 2 nahi ho sakta
        if (n % 2 != 0) {
            return false;
        }

        // Step 4: Recursive call
        // n ko 2 se divide karte jao
        return isPowerOfTwo(n / 2);
    }
}
