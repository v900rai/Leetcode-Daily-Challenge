class Solution {
    public int maxScore(String s) {
         int n = s.length();
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int zerosLeft = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    zerosLeft++;
                }
            }

            int onesRight = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '1') {
                    onesRight++;
                }
            }

            result = Math.max(result, zerosLeft + onesRight);
        }
        return result;
    
    }
}