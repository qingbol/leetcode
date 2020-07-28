/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200118)//////////////////////////////////////
  ////////////////// first round(20200118)//////////////////////////////////////
  // -------------------start(Approach1)---------------------------
  // 20200118.
  // cspiration: stack overflow. backtrack

  // public void solveSudoku(char[][] board) {
  public void solveSudoku1(char[][] board) {
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
          if (isValid1(board, i, j, k)) {
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

  private boolean isValid1(char[][] board, int row, int col, int letter) {
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
  //optimal

  // 6/6 cases passed (7 ms)
  // Your runtime beats 79.69 % of java submissions
  // Your memory usage beats 19.32 % of java submissions (39.1 MB)

  public void solveSudoku2(char[][] board) {
    // public void solveSudoku(char[][] board) {
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
  //////////////// second round(20200727)//////////////////////////////////////
  //////////////// second round(20200727)//////////////////////////////////////
  // -------------------start(Approach3)---------------------------
  // 20200727. by myself.

  // Time Limit Exceeded
  // Your Input
  // [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]

  public void solveSudoku(char[][] board) {
  // public void solveSudoku3(char[][] board) {
    helper3(board, 0);
  }

  private boolean helper3(char[][] board, int idx) {
    int n = board.length;
    int row = idx / n;
    int col = idx % n;

    if (idx == 81) {
      return true;
    }
    // System.out.format("board: %s\n", Arrays.deepToString(board));

    if (board[row][col] != '.')
      helper3(board, idx + 1);

    for (int i = 1; i <= 9; i++) {
      if (!isValid3(board, row, col, i))
        // if (!isValid3(board, row, col, (char)(i + '0')))
        continue;
      board[row][col] = (char) (i + '0');
      boolean ret = helper3(board, idx + 1);
      if (ret)
        return true;
      board[row][col] = '.';
    }
    return false;
  }

  private boolean isValid3(char[][] board, int row, int col, int num) {
    // System.out.format("row: %d, col: %d\n", row, col);
    int n = board.length;
    int ch = (char) (num + '0');
    // check col.
    for (int i = 0; i < n; i++) {
      if (board[i][col] == ch)
        return false;
    }
    // check row
    for (int j = 0; j < n; j++) {
      if (board[row][j] == ch)
        return false;
    }
    // check sub-boxes
    int r = row / 3 * 3;
    int l = col / 3 * 3;
    // System.out.format("r: %d, l: %d\n", r, l);
    for (int i = r; i < r + 3; i++) {
      for (int j = l; j < l + 3; j++) {
        // System.out.format("i: %d, j: %d\n", i, j);
        if (board[i][j] == ch)
          return false;
      }
    }
    return true;
  }

  // ------------------- end (Approach3)---------------------------
  // -------------------start(Approach4)---------------------------
  //20200727. 
  //refer to leetcode discussion.
  //https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking

  // public void solveSudoku(char[][] board) {
  public void solveSudoku4(char[][] board) {
    if (board == null || board.length == 0)
      return;
    solve(board);
  }

  public boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {// trial. Try 1 through 9
            if (isValid(board, i, j, c)) {
              board[i][j] = c; // Put c for this cell

              if (solve(board))
                return true; // If it's the solution return true
              else
                board[i][j] = '.'; // Otherwise go back
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] != '.' && board[i][col] == c)
        return false; // check row
      if (board[row][i] != '.' && board[row][i] == c)
        return false; // check column
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
          && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false; // check 3*3 block
    }
    return true;
  }
  // ------------------- end (Approach4)---------------------------

}
// @lc code=end
