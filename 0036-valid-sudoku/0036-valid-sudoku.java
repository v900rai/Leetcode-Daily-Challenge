/**
 * Most Optimized solution using Bit Manipulation
 * 
 * Using only one int to store the bits for Row, Column and Box.
 *
 * This Solution uses True O(1) space and requires True O(N^2) time.
 *
 * Bit 0 -> 8 will represent ith Row
 * Bit 9 -> 17 will represent ith Column
 * Bit 18 -> 26 will represent ith Box
 *
 * Time Complexity: O(9*9)
 *
 * Space Complexity: O(1). Using only one integer.
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Input is invalid");
        }

        int rowColBox = 0;

        for (int i = 0; i < 9; i++) { // Index of row, column and box
            for (int j = 0; j < 9; j++) {
                // Check ith row
                rowColBox = validateAndAddCell(board[i][j], 0, rowColBox);
                if (rowColBox == -1) {
                    return false;
                }

                // Check ith column
                rowColBox = validateAndAddCell(board[j][i], 1, rowColBox);
                if (rowColBox == -1) {
                    return false;
                }

                // Check ith box
                int boxRow = 3 * (i / 3) + (j / 3);
                int colRow = 3 * (i % 3) + (j % 3);
                rowColBox = validateAndAddCell(board[boxRow][colRow], 2, rowColBox);
                if (rowColBox == -1) {
                    return false;
                }
            }
            rowColBox = 0;
        }

        return true;
    }

    private int validateAndAddCell(char c, int type, int rowColBox) {
        if (c == '.') {
            return rowColBox;
        }
        if (c < '1' || c > '9') {
            return -1;
        }

        int bitIdx = type * 9 + (c - '1');
        if (((rowColBox >> bitIdx) & 1) == 1) {
            return -1;
        }

        return rowColBox | (1 << bitIdx);
    }
}