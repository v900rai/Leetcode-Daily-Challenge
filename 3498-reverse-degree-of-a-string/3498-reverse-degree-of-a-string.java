class Solution {
    public int reverseDegree(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            // Normal alphabet position
            int normalValue = s.charAt(i) - 'a' + 1;

            // Reverse alphabet value
            int reverseValue = 26 - normalValue + 1;

            // String position = i + 1
            sum += reverseValue * (i + 1);
        }

        return sum;
    }
}