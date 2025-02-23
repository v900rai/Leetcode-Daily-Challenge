class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        while(n > 2) {
            String nstr = "";
            for(int i=1; i<n; i++) {
                int next = ((s.charAt(i)-'0')+(s.charAt(i-1)-'0')) % 10;
                nstr += next;
            }
            n--;
            s = nstr;
        }
        return s.charAt(0) == s.charAt(1);
    }
}