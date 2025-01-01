class Solution {
    public int maxScore(String s) {
         int n = s.length();
        int result = Integer.MIN_VALUE;
        int totalOnes = (int) s.chars().filter(ch -> ch == '1').count();

        int zeros = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                totalOnes--;
            } else {
                zeros++;
            }

            result = Math.max(result, zeros + totalOnes);
        }

        return result;
    
    }
}