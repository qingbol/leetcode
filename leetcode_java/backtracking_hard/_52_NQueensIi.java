/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
  private int res = 0;

  public int totalNQueens(int n) {
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
}
// @lc code=end
