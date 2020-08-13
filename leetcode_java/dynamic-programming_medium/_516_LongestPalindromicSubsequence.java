/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200811)///////////////////////////////////
  ////////////////// first round(20200811)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  //20200811, part by by myself.
  //refer to labuladong<动态规划之子序列问题解题模板>

//   83/83 cases passed (43 ms)
// Your runtime beats 63.77 % of java submissions
// Your memory usage beats 85.54 % of java submissions (49.5 MB)

  public int longestPalindromeSubseq1(String s) {
  // public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];

    for (int l = 1; l <= n; l++) {
      for (int i = 1; i <= n - l + 1; i++) {
        int j = i + l - 1;
        // base case;
        if (l == 1) {
          dp[i][j] = 1;
          continue;
        }
        // otherwise
        if (s.charAt(i - 1) == s.charAt(j - 1)) {
          // if (i + 1 <= j - 1) {
            dp[i][j] = 2 + dp[i + 1][j - 1];
          // } else {
          //   dp[i][j] = 2;
          // }
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }

      }
    }
    return dp[1][n];
  }
  //// -------------- end (Approach1)------------------------
}
// @lc code=end
