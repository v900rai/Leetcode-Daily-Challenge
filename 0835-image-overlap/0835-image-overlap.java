import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        Map<String, Integer> map = new HashMap<>();

        int max = 0;

        // Step 1: Find every 1 in img1
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {

                if (img1[i][j] == 1) {

                    // Step 2: Find every 1 in img2
                    for (int x = 0; x < img2.length; x++) {
                        for (int y = 0; y < img2[0].length; y++) {

                            if (img2[x][y] == 1) {

                                // Required shift
                                int dx = x - i;
                                int dy = y - j;

                                String key = dx + "," + dy;

                                // Count this shift
                                int count = map.getOrDefault(key, 0) + 1;

                                map.put(key, count);

                                max = Math.max(max, count);
                            }
                        }
                    }
                }
            }
        }

        return max;
    }
}