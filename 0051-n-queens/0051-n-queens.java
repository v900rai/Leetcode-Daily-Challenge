class Solution {

  List<List<String>> ans = new ArrayList<>();

  // Main function
  public List<List<String>> solveNQueens(int n) {

    // Chess board initialize karo
    char[][] board = new char[n][n];

    // Sab jagah '.'
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], '.');
    }

    backtrack(board, 0);

    return ans;
  }

  // Row by row queen place karenge
  private void backtrack(char[][] board, int row) {

    // Agar sab rows fill ho gayi
    if (row == board.length) {

      // Current board ko answer me add karo
      ans.add(construct(board));
      return;
    }

    // Har column try karo
    for (int col = 0; col < board.length; col++) {

      // Safe hai ya nahi?
      if (isSafe(board, row, col)) {

        // Queen place karo
        board[row][col] = 'Q';

        // Next row
        backtrack(board, row + 1);

        // Backtracking
        board[row][col] = '.';
      }
    }
  }

  // Check whether queen can be placed
  private boolean isSafe(char[][] board, int row, int col) {

    // Check same column
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 'Q')
        return false;
    }

    // Check left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

      if (board[i][j] == 'Q')
        return false;
    }

    // Check right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {

      if (board[i][j] == 'Q')
        return false;
    }

    return true;
  }

  // Convert board into List<String>
  private List<String> construct(char[][] board) {

    List<String> list = new ArrayList<>();

    for (char[] row : board) {
      list.add(new String(row));
    }

    return list;
  }
}