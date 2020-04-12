/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)---------------------------
  // 20200328,dp, space:O(mn)
  public int uniquePaths1(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  //// --------------- end (Approach1)---------------------------
  //// ---------------start(Approach2)---------------------------
  // 20200328,dp, space:O(n)
  public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[j] = dp[j] + dp[j - 1];
      }
    }

    return dp[n - 1];
  }
  //// --------------- end (Approach2)---------------------------

}
// @lc code=end
