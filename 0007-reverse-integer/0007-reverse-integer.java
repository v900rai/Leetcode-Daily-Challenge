class Solution {
    public int reverse(int num) {
        long reversedNumber = 0;  
        
        while (num != 0) {
            int digit = num % 10;  
            reversedNumber = reversedNumber * 10 + digit;  
            num /= 10;  

            // Overflow check (Integer limit से बाहर जाने पर return 0)
            if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
                return 0;
            }
        }
        
        return (int) reversedNumber;  
    }
}
