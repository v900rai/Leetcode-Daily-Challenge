class Solution {
    public String convertToTitle(int col) {
        StringBuilder sb = new StringBuilder();

        while (col > 0) {
            int r = (col - 1) % 26; // remainder for the last letter
            sb.append((char)(r + 'A')); // convert 0-25 → 'A'-'Z'
            col = (col - 1) / 26; // move to the next “digit”
        }

        return sb.reverse().toString(); // reverse to get correct order
    }
}
