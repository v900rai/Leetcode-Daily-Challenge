class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length(); // Input string की लंबाई
        
        // जब तक string की लंबाई 2 से ज्यादा है, प्रोसेस जारी रहेगा
        while (n > 2) {
            String str = ""; // नई string बनाने के लिए

            // हर दो संख्याओं को जोड़कर नई string बनाएंगे
            for (int i = 1; i < n; i++) {
                int next = ((s.charAt(i) - '0') + (s.charAt(i - 1) - '0')) % 10; 
                str += next; // नए कैरेक्टर को जोड़ना
            }

            // स्टेप अपडेट: नई string बन गई, अब इसे प्रोसेस करें
            n--; // String की लंबाई 1 घटती जाएगी
            s = str; // पुरानी string को नई string से बदल दिया
        }

        // अब हमारी string में सिर्फ 2 अंक बचे होंगे, उन्हें compare करना है
        return s.charAt(0) == s.charAt(1);
    }
}
