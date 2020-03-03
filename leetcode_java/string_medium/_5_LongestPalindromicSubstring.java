/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
  //// :--------------------start(approach 1)------------------------------
  public String longestPalindrome1(String s) {
    if (s.length() < 2) {
      return s;
    }
    int n = s.length();
    String res = "";
    boolean[][] dp = new boolean[n][n];
    // for (int i = 0; i < n; i++) {
    // dp[i][i] = true;
    // res = s.substring(i, i + 1);
    // }
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (i + 1 >= j - 1) {
          dp[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        }
        if (dp[i][j] && (j - i + 1) > res.length()) {
          res = s.substring(i, j + 1);
        }
        // System.out.format("dp:%s\n", Arrays.deepToString(dp));
      }
    }
    return res;
  }

  //// :-------------------- end (approach 1)------------------------------
  //// :--------------------start(approach 2)------------------------------
  private String res = "";

  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      helper(s, i, i);
      helper(s, i, i + 1);
    }
    return res;
  }

  private void helper(String ss, int l, int r) {
    while (l >= 0 && r < ss.length() && ss.charAt(l) == ss.charAt(r)) {
      l--;
      r++;
    }
    if ((r - l - 1) > res.length()) {
      res = ss.substring(l + 1, r);
    }
  }
  //// :--------------------start(approach 2)------------------------------
  //// :-------------------- end (approach 3)------------------------------
  //// :-------------------- end (approach 3)------------------------------
}
// @lc code=end
