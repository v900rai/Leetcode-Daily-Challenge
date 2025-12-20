class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;          // number of strings (rows)
        int m = strs[0].length();     // length of each string (columns)

        int count = 0;                // number of columns to delete

        // loop through each column
        for (int i = 0; i < m; i++) {
            // compare characters row-wise
            for (int j = 1; j < n; j++) {
                // if current char is smaller than above char
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;          // delete this column
                    break;            // no need to check further rows
                }
            }
        }
        return count;
    }
}
