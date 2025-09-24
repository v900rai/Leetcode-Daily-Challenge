class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((long) numerator * (long) denominator < 0) {
            result.append("-");
        }

        long absNumerator = Math.abs((long) numerator);
        long absDenominator = Math.abs((long) denominator);

        // Integer part
        long integerPart = absNumerator / absDenominator;
        result.append(integerPart);

        long remain = absNumerator % absDenominator;
        if (remain == 0) return result.toString();

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remain != 0) {
            if (map.containsKey(remain)) {
                // Insert "(" at the position where this remainder first appeared
                int insertPos = map.get(remain);
                result.insert(insertPos, "(");
                result.append(")");
                break;
            }

            map.put(remain, result.length());
            remain *= 10;
            long digit = remain / absDenominator;
            result.append(digit);
            remain %= absDenominator;
        }

        return result.toString();
    }
}