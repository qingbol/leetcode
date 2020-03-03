/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    int[] queens = new int[n];
    helper1(res, queens, 0);
    return res;
  }

  private void helper1(List<List<String>> res, int[] queens, int curRow) {
    if (curRow == queens.length) {
      addSolution1(res, queens);
      return;
    }

    for (int col = 0; col < queens.length; col++) {
      queens[curRow] = col;
      if (isValid1(queens, curRow)) {
        helper1(res, queens, curRow + 1);
      }
    }
  }

  private boolean isValid1(int[] queen, int curRow) {
    for (int i = 0; i < curRow; i++) {
      if (queen[i] == queen[curRow]) {
        return false;
      } else if (Math.abs(curRow - i) == Math.abs(queen[curRow] - queen[i])) {
        return false;
      }
    }
    return true;
  }

  private void addSolution1(List<List<String>> res, int[] queens) {
    List<String> lst = new ArrayList<>();
    for (int i = 0; i < queens.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < queens.length; j++) {
        if (queens[i] == j) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      lst.add(sb.toString());
    }
    res.add(lst);
  }
}
// @lc code=end
