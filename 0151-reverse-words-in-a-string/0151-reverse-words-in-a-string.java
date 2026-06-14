class Solution {
    public String reverseWords(String s) {

        // Starting aur ending spaces remove karne ke liye
        String[] words = s.trim().split(" ");

        // Final answer store karne ke liye
        StringBuilder sb = new StringBuilder();


        // Last word se first word tak loop
        for (int i = words.length - 1; i >= 0; i--) {

            // Extra spaces se empty string aa sakti hai
            if (words[i].length() > 0) {

                // Word add karo
                sb.append(words[i]);

                // Word ke baad space add karo
                sb.append(' ');
            }
        }

        // Last extra space remove karke answer return karo
        return sb.substring(0, sb.length() - 1).toString();
    }
}