class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length; // ग्रिड का आकार (n x n)
        int size = n * n; // कुल संख्याओं की सीमा (1 से size तक)
        int[] freq = new int[size + 1]; // प्रत्येक संख्या की उपस्थिति को ट्रैक करने के लिए एक फ़्रीक्वेंसी ऐरे
        int repeated = -1, missing = -1; // दोहराई गई और गायब संख्या के लिए वेरिएबल्स
        
        // ग्रिड में मौजूद प्रत्येक संख्या की गिनती करें
        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++; // संख्या की गिनती बढ़ाएँ
            }
        }
        
        // 1 से size तक प्रत्येक संख्या की उपस्थिति जाँचें
        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2) repeated = num; // यदि कोई संख्या दो बार आई है, तो उसे दोहराया गया मान मानें
            if (freq[num] == 0) missing = num;  // यदि कोई संख्या नहीं आई है, तो उसे गायब मान मानें
        }
        
        // दोहराया गया और गायब मान एक ऐरे के रूप में लौटाएँ
        return new int[]{repeated, missing};
    }
}
