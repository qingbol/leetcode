/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
  //// --------------------------start(Approach1)-----------------------
  // 20200408, by myself. dp
  // Your runtime beats 24.55 % of java submissions
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int j = 1; j < p.length() + 1; j++) {
      if (p.charAt(j - 1) == '*') {
        // if (p.charAt(j - 1) == '*' || p.charAt(j - 1) == '?' && j != 1) {
        dp[0][j] = dp[0][j - 1];
      }
    }
    // System.out.format("dp:%s\n", Arrays.deepToString(dp).replaceAll("\\],",
    // "\n"));

    for (int i = 1; i < s.length() + 1; i++) {
      for (int j = 1; j < p.length() + 1; j++) {
        if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
          // dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
        } else if (p.charAt(j - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1];
        }
      }
    }

    return dp[s.length()][p.length()];
  }
  //// --------------------------start(Approach2)-----------------------
}
// @lc code=end
