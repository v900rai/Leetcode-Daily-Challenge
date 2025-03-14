class Solution {
    public char findTheDifference(String s, String t) {
        int total = 0;

        // Add all characters of t to total
       for(int i=0; i<t.length(); i++){
        total=total+t.charAt(i);
       }

        // Subtract all characters of s from total
        for (int i = 0; i < s.length(); i++) {
            total -= s.charAt(i);
        }

        // The difference will be the extra character in t
        return (char) total;
    }
}
