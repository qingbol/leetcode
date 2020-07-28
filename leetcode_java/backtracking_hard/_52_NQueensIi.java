/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
  ////////////////// first round(202000301)////////////////////////////////////
  ////////////////// first round(202000301)////////////////////////////////////
  //// ----------------start(Approach1)-------------------
  // 20200301.
  private int res = 0;

  // public int totalNQueens(int n) {
  public int totalNQueens1(int n) {
    boolean[] cols = new boolean[n];
    boolean[] hill = new boolean[2 * n - 1];
    boolean[] dale = new boolean[2 * n - 1];

    helper1(cols, hill, dale, n, 0);
    return res;
  }

  private void helper1(boolean[] cols, boolean[] hill, boolean[] dale, int n, int row) {
    if (row == n) {
      res++;
      return;
    }

    for (int col = 0; col < n; col++) {
      // if this row,col is invalid, skip it
      if (cols[col] || hill[row + col] || dale[row - col + n - 1]) {
        continue;
      }
      // if this row,col is valid. place the queen
      cols[col] = true;
      hill[row + col] = true;
      dale[row - col + n - 1] = true;
      helper1(cols, hill, dale, n, row + 1);
      // backtrack
      cols[col] = false;
      hill[row + col] = false;
      dale[row - col + n - 1] = false;
    }
  }

  //// ---------------- end (Approach1)-------------------
  ////////////////// second round(202000727)////////////////////////////////////
  ////////////////// second round(202000727)////////////////////////////////////
  //// ----------------start(Approach1)-----------------------------------------
  //20200727, 
  //refer to labuladong <回溯算法解题套路框架>
  1
  //9/9 cases passed (19 ms)
// Your runtime beats 5.61 % of java submissions
// Your memory usage beats 5.22 % of java submissions (39.3 MB)
// 
  public int totalNQueens(int n) {
    // public int totalNQueens2(int n) {
    int[] res = new int[1];
    // build the chessboard
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append('.');
    }
    List<String> board = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      board.add(sb.toString());
    }
    // System.out.format("board: %s\n", board);

    helper2(board, 0, res);
    return res[0];
  }

  private void helper2(List<String> board, int row, int[] res) {
    if (row == board.size()) {
      res[0]++;
      // System.out.format("row: %d, res: %d\n", row, res[0]);
      return;
    }

    for (int col = 0; col < board.size(); col++) {
      if (!isValid2(board, row, col))
        continue;
      // System.out.format("row: %d, col: %d\n", row, col);
      String tmp = board.get(row);
      board.set(row, tmp.substring(0, col) + 'Q' + tmp.substring(col + 1));
      // System.out.format("board: %s, row: %d, col: %d\n", board, row, col);
      helper2(board, row + 1, res);
      tmp = board.get(row);
      board.set(row, tmp.substring(0, col) + '.' + tmp.substring(col + 1));
    }
  }

  private boolean isValid2(List<String> board, int row, int col) {
    // System.out.format("board: %s, row: %d, col: %d\n", board, row, col);
    // conflict with vertical direction
    for (int i = 0; i < row; i++) {
      if (board.get(i).charAt(col) == 'Q')
        return false;
    }
    // check the hill direction on the right above
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
      if (board.get(i).charAt(j) == 'Q')
        return false;
    }
    // check the dale direction on the right above
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board.get(i).charAt(j) == 'Q')
        return false;
    }
    return true;
  }
  //// ---------------- end (Approach1)-----------------------------------------
}
// @lc code=end
