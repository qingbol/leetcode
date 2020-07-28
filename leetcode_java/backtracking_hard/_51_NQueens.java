/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200301)////////////////////////
  ////////////////// first round(20200301)////////////////////////
  //// ----------------start(Approach1)-------------------
  // 20200301.

  // public List<List<String>> solveNQueens(int n) {
  public List<List<String>> solveNQueens1(int n) {
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

  //// ---------------- end (Approach1)-------------------
  ////////////////// second round(202000726)////////////////////////////////////
  //// ----------------start(Approach1)-------------------
  // 20200301. by myself. backtracking

  // 9/9 cases passed (4 ms)
  // Your runtime beats 70.59 % of java submissions
  // Your memory usage beats 40.4 % of java submissions (39.8 MB)

  public List<List<String>> solveNQueens(int n) {
    // public List<List<String>> solveNQueens2(int n) {
    List<List<String>> res = new ArrayList<>();
    helper2(n, new ArrayList<>(), res);
    return res;
  }

  private void helper2(int n, List<Integer> track, List<List<String>> res) {
    if (track.size() == n) {
      List<String> lst = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder(n);
        // System.out.format("track[i]: %d\n", track.get(i));
        for (int j = 0; j < n; j++) {
          if (j == track.get(i)) {
            sb.append('Q');
          } else {
            sb.append('.');
          }
        }
        // System.out.format("sb: %s\n", sb.toString());
        lst.add(sb.toString());
      }
      res.add(new ArrayList<>(lst));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!isValid2(track, i))
        continue;
      track.add(i);
      helper2(n, track, res);
      track.remove(track.size() - 1);
    }
  }

  private boolean isValid2(List<Integer> track, int curY) {
    int n = track.size();
    int curX = n;
    for (int preX = 0; preX < n; preX++) {
      int preY = track.get(preX);
      if (preY == curY || preX + preY == curX + curY || preY - preX == curY - curX) {
        // System.out.format("track:%s\n", track);
        // System.out.format("curX: %d, curY: %d, preX: %d, preY: %d\n", curX, curY,
        // preX, preY);
        return false;
      }
    }
    return true;
  }
  //// ---------------- end (Approach1)-------------------
}
// @lc code=end
