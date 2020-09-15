/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116

  // public int[][] generateMatrix(int n) {
  public int[][] generateMatrix1(int n) {
    int[][] res = new int[n][n];
    int rowStart = 0;
    int rowEnd = n - 1;
    int colLeft = 0;
    int colRight = n - 1;
    int val = 1;
    while (rowStart < rowEnd && colLeft < colRight) {
      for (int j = colLeft; j <= colRight; j++) {
        res[rowStart][j] = val++;
      }
      // System.out.format("res: %s\n", Arrays.deepToString(res));
      rowStart++;
      for (int i = rowStart; i <= rowEnd; i++) {
        res[i][colRight] = val++;
      }
      // System.out.format("res: %s\n", Arrays.deepToString(res));
      colRight--;
      for (int j = colRight; j >= colLeft; j--) {
        res[rowEnd][j] = val++;
      }
      // System.out.format("res: %s\n", Arrays.deepToString(res));
      rowEnd--;
      for (int i = rowEnd; i >= rowStart; i--) {
        res[i][colLeft] = val++;
      }
      // System.out.format("res: %s\n", Arrays.deepToString(res));
      colLeft++;
      // System.out.format("rowStart: %d, rowEnd: %d, colLeft: %d, colR: %d\n",
      // rowStart, rowEnd, colLeft, colRight);
      // System.out.println("-----------------");
    }
    if (n % 2 == 1) {
      res[rowStart][colLeft] = val;
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200913)///////////////////////////////////
  ////////////////// second round(20200913)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200914
  //refer to leetcode: Approach 2: Optimized spiral traversal

  // 20/20 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 45.26 % of java submissions (37.5 MB)

  public int[][] generateMatrix(int n) {
    // public int[][] generateMatrix2(int n) {
    if (n == 0)
      return new int[][] {};
    int[][] res = new int[n][n];
    int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int val = 1;
    int r = 0, c = 0;
    int candidateR = 0, candidateC = 0;
    int d = 0;

    while (val <= Math.pow(n, 2)) {
      // while (val <= n^2) {
      res[r][c] = val++;
      // System.out.format("r:%d, c:%d\n", r, c);
      candidateR = (r + dir[d][0] + n) % n;
      candidateC = (c + dir[d][1] + n) % n;
      // System.out.format("cr:%d, cc:%d\n", candidateR, candidateC);
      if (res[candidateR][candidateC] != 0) {
        // d = (d + 1) % n;
        d = (d + 1) % 4;
      }
      r += dir[d][0];
      c += dir[d][1];
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
