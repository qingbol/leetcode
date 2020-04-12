/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
  //// --------------start(Approach1)------------------
  // 20200405, dp + space:O(1)
  public int minPathSum(int[][] grid) {
    int nr = grid.length;
    int nc = grid[0].length;
    for (int i = 1; i < nr; i++) {
      grid[i][0] = grid[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < nc; j++) {
      grid[0][j] = grid[0][j] + grid[0][j - 1];
    }

    for (int i = 1; i < nr; i++) {
      for (int j = 1; j < nc; j++) {
        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
      }
    }

    return grid[nr - 1][nc - 1];
  }
  //// -------------- end (Approach1)------------------
}
// @lc code=end
