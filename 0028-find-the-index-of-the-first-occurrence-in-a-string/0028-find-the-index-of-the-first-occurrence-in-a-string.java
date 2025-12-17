class Solution {
    public int strStr(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (m == 0) {
            return 0;
        }

        for (int s1 = 0; s1 <= n - m; s1++) {
            if (a.charAt(s1) == b.charAt(0)) {
                int start = s1;
                boolean isMatch = true;

                for (int i = 0; i < m; i++) {
                    if (a.charAt(start + i) != b.charAt(i)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    return s1;
                }
            }
        }

        return -1;
    }
}