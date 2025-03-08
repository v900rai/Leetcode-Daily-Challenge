class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();  // स्ट्रिंग की लंबाई
        int i = 0, j = 0;  // स्लाइडिंग विंडो के लिए दो pointers
        int result = k;  // अधिकतम बदलाव k से ज्यादा नहीं होंगे, इसलिए initial result = k
        int W = 0;  // विंडो में मौजूद 'W' (White Blocks) की गिनती

        // पूरे स्ट्रिंग पर स्लाइडिंग विंडो अप्रोच लागू करें
        while (j < n) {
            // यदि करंट ब्लॉक 'W' है, तो W की गिनती बढ़ाएं
            if (blocks.charAt(j) == 'W') {
                W++;
            }

            // यदि विंडो का साइज k तक पहुँच गया
            if (j - i + 1 == k) {
                // न्यूनतम बदलाव अपडेट करें
                result = Math.min(result, W);

                // यदि leftmost character 'W' है, तो उसे हटाने के लिए W की गिनती घटाएं
                if (blocks.charAt(i) == 'W') {
                    W--;
                }
                // विंडो को एक स्टेप आगे स्लाइड करें
                i++;
            }

            // अगले ब्लॉक पर जाएं
            j++;
        }

        // सबसे कम सफेद ब्लॉक्स को काले में बदलने की संख्या रिटर्न करें
        return result;
    }
}
