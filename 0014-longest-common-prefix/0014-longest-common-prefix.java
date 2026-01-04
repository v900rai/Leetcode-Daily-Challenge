class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Edge case: empty array
        if (strs == null || strs.length == 0)
            return "";

        // First string ko prefix maan lo
        String prefix = strs[0];

        // Baaki strings ke saath compare karo
        for (int i = 1; i < strs.length; i++) {

            // Jab tak current string prefix se start nahi karti
            while (!strs[i].startsWith(prefix)) {

                // prefix ka last character hata do
                prefix = prefix.substring(0, prefix.length() - 1);

                // Agar prefix empty ho gaya
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }
}
