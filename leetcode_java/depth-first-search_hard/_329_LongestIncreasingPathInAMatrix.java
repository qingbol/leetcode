/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
  //// -----------------start(Approach1)-------------------------------
  // 20200309
  // dfs + memorization
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int res = 0;
    int[][] memo = new int[matrix.length][matrix[0].length];
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        res = Math.max(res, dfs1(matrix, memo, directions, i, j));
      }
    }
    return res;
  }

  private int dfs1(int[][] matrix, int[][] memo, int[][] directions, int r, int c) {
    if (memo[r][c] != 0) {
      return memo[r][c];
    }
    int curLen = 0;
    for (int[] dir : directions) {
      int newR = r + dir[0];
      int newC = c + dir[1];
      if (newR < 0 || newR >= matrix.length || newC < 0 || newC >= matrix[0].length
          || matrix[newR][newC] <= matrix[r][c]) {
        continue;
      }
      int ret = dfs1(matrix, memo, directions, newR, newC);
      curLen = Math.max(curLen, ret);
    }
    // why put curLen = 1 hear? because when it's the last layer, it should be 1
    curLen = 1 + curLen;
    memo[r][c] = curLen;
    return curLen;
  }
  //// ----------------- end (Approach1)-------------------------------
}
// @lc code=end
