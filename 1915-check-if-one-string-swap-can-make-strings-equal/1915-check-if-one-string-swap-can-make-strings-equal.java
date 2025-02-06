class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int x = -1;
        char[] s2Arr = s2.toCharArray();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (x == -1) {
                    x = i;
                } else {
                    // Swap characters
                    char temp = s2Arr[i];
                    s2Arr[i] = s2Arr[x];
                    s2Arr[x] = temp;
                    
                    return s1.equals(new String(s2Arr));
                }
            }
        }
        
        return s1.equals(s2);
    }
}
