class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long sum = 0;
        long mul = 1;
        

        while (n > 0) {
            int digit = n % 10;
            sum += digit;

            if (digit > 0) {
                num = (digit * mul) + num;
                mul = mul * 10;
            }

            n = n / 10;
        }
        return (sum * num);
    }
}