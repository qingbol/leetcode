/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200811)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200811

  // 43/43 cases passed (9 ms)
  // Your runtime beats 89.05 % of java submissions
  // Your memory usage beats 83.66 % of java submissions (42.9 MB)

  public int longestCommonSubsequence(String text1, String text2) {
    // public int longestCommonSubsequence1(String text1, String text2) {
    int n1 = text1.length(), n2 = text2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];

    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n1][n2];
  }
  //// -------------- end (Approach1)------------------------
}
// @lc code=end
