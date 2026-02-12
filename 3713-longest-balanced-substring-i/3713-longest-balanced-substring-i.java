import java.util.*;

class Solution {

    public int longestBalanced(String s) {

        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int ref = -1;
                boolean valid = true;

                for (int k : map.values()) {

                    if (ref == -1) {
                        ref = k;
                    } 
                    else if (k != ref) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }
}