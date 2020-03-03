/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
  public int[][] generateMatrix(int n) {
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
}
// @lc code=end
