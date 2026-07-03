class Solution {
    public int lengthOfLastWord(String s) {

        // Step 1: Starting aur ending spaces remove karo
        s = s.trim();

        // Step 2: Last index nikal lo
        int n = s.length() - 1;

        // Step 3: Count variable
        int count = 0;

        // Step 4: Last se reverse loop
        for (int i = n; i >= 0; i--) {

            // Agar space mil gaya to last word khatam
            if (s.charAt(i) == ' ') {
                break;
            }

            // Character last word ka hai
            count++;
        }

        // Step 5: Answer return
        return count;
    }
}