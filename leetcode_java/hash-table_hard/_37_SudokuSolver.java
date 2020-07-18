/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
  // -------------------start(Approach1)---------------------------
  // 20200118.
  // cspiration: stack overflow. backtrack
  public void solveSudoku(char[][] board) {
    solveSudokuHelper(board);
  }

  private boolean solveSudokuHelper(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];
        if (c != '.') {
          continue;
        }
        for (char k = '1'; k <= '9'; k++) {
          if (isValid(board, i, j, k)) {
            board[i][j] = k;
            if (solveSudokuHelper(board)) {
              return true;
            } else {
              board[i][j] = '.';
            }
          }
        }
        return false;
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int row, int col, int letter) {
    // int idx = row / 3 * 3 + col / 3;
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == letter)
        return false;
      if (board[i][col] == letter)
        return false;
      // if (board[(idx + i) / 3][(idx + i) % 3] == letter)
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == letter)
        return false;
    }
    return true;
  }
  // ------------------- end (Approach1)-------------------------------

  // -------------------start(Appraoch2)-------------------------------
  // 20200118
  public void solveSudoku1(char[][] board) {
    dfs(board, 0);
  }

  private boolean dfs(char[][] board, int d) {
    if (d == 81) {
      return true;
    }
    int i = d / 9;
    int j = d % 9;
    if (board[i][j] != '.') {
      return dfs(board, d + 1);
    }

    boolean[] flag = new boolean[10];
    validate(board, i, j, flag);
    // System.out.format("i: %d, j: %d, flag: %s\n", i, j,
    // Arrays.deepToString(board));
    for (int k = 1; k <= 9; k++) {
      if (flag[k]) {
        board[i][j] = (char) ('0' + k);
        if (dfs(board, d + 1)) {
          return true;
        }
      }
    }
    board[i][j] = '.';
    return false;
  }

  private void validate(char[][] board, int i, int j, boolean[] flag) {
    Arrays.fill(flag, true);
    for (int k = 0; k < 9; k++) {
      if (board[i][k] != '.')
        flag[board[i][k] - '0'] = false;
      if (board[k][j] != '.')
        flag[board[k][j] - '0'] = false;
      int r = i / 3 * 3 + k / 3;
      int c = j / 3 * 3 + k % 3;
      if (board[r][c] != '.')
        flag[board[r][c] - '0'] = false;
    }
  }
  // ------------------- end (Approach2)--------------------------

}
// @lc code=end
