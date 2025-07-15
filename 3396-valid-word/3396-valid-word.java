class Solution {
    public boolean isValid(String word) {
        // शब्द की लंबाई कम से कम 3 होनी चाहिए
        // Word length must be at least 3
        if (word.length() < 3) {
            return false;
        }

        // स्वर (vowel) और व्यंजन (consonant) के लिए फ्लैग
        // Flags for vowel and consonant
        boolean Vowel = false;
        boolean Consonant = false;

        // शब्द के प्रत्येक अक्षर की जाँच करें
        // Check each character in the word
        for (char ch : word.toCharArray()) {
            // यदि अक्षर है (letter)
            // If it's a letter
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                // जाँचें कि यह स्वर (vowel) है
                // Check if it's a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    Vowel = true;
                } else {
                    // अन्यथा यह व्यंजन (consonant) है
                    // Otherwise it's a consonant
                    Consonant = true;
                }
            } 
            // यदि अंक (digit) नहीं है तो अमान्य
            // If it's not a digit, it's invalid
            else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        // शब्द में कम से कम एक स्वर और एक व्यंजन होना चाहिए
        // Word must have at least one vowel and one consonant
        return Vowel && Consonant;
    }
}