/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
  //// ------------------start(Approach1)---------------------
  // 20200405, by myself, dp + space:o(nc);
  // Your runtime beats 100 % of java submissions
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int nr = obstacleGrid.length;
    int nc = obstacleGrid[0].length;
    int[] dp = new int[nc];
    for (int j = 0; j < nc; j++) {
      if (j == 0) {
        dp[j] = obstacleGrid[0][j] == 1 ? 0 : 1;
      } else {
        dp[j] = obstacleGrid[0][j] == 1 ? 0 : dp[j - 1];
      }
    }
    // System.out.format("dp:%s\n", Arrays.toString(dp));

    for (int i = 1; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (j == 0) {
          dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j];
        } else if (obstacleGrid[i][j] == 1) {
          dp[j] = 0;
        } else {
          dp[j] = dp[j] + dp[j - 1];
        }
      }
    }
    // System.out.format("dp:%s\n", Arrays.toString(dp));
    return dp[nc - 1];
  }
}
// @lc code=end
