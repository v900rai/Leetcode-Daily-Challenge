class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // शुरुआत और अंत की स्पेस हटाएं
        int n = s.length();
        int wLength = 0;

        // लास्ट से शुरू करते हैं और पहले स्पेस मिलने तक वर्ड की लंबाई गिनते हैं
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break; // स्पेस मिलते ही लूप से बाहर निकलें
            }
            wLength++; // जब तक अक्षर मिले, वर्ड की लंबाई बढ़ाएं
        }
        return wLength;
    }
}
