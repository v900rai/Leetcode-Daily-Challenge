class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // अगर दोनों स्ट्रिंग पहले से ही समान हैं
        if (s1.equals(s2)) {
            return true;
        }

        // अलग-अलग अक्षरों की सूची रखने के लिए
        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                // पहले और दूसरे गलत इंडेक्स को स्टोर करें
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // अगर दो से ज्यादा गलतियाँ हो गईं तो सीधे false
                    return false;
                }
            }
        }

        // अगर ठीक दो गलतियाँ हैं, तो चेक करें कि वे स्वैप योग्य हैं
        return count == 2 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
}
