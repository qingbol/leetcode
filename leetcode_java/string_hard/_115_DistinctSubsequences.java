/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
  public int numDistinct(String s, String t) {
    int m = t.length();
    int n = s.length();

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        // any string can contain one empty string.
        // an empty string can't contain any other string
        if (i == 0) {
          dp[i][j] = 1;
        } else if (j == 0) {
          dp[i][j] = 0;
        } else if (s.charAt(j - 1) == t.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else if (s.charAt(j - 1) != t.charAt(i - 1)) {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }
    return dp[m][n];
  }
}
// @lc code=end
