/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
  //// ---------------------start(Approach1)---------------------
  // 20200405, after reading the idea on leetcode, I implemented it.
  // Your runtime beats 96.47 % of java submissions
  public int numDecodings1(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Integer[] memo = new Integer[s.length()];
    return helper1(s, 0, memo);
  }

  private int helper1(String s, int start, Integer[] memo) {
    if (start == s.length()) {
      return 1;
    }

    if (s.charAt(start) == '0') {
      return 0;
    }

    if (memo[start] != null) {
      return memo[start];
    }

    int cnt1 = 0;
    int cnt2 = 0;
    int oneDigit = Integer.valueOf(s.substring(start, start + 1)).intValue();
    // System.out.format("oneDigit: %d\n", oneDigit);
    cnt1 = helper1(s, start + 1, memo);
    if (start + 2 <= s.length()) {
      int twoDigits = Integer.valueOf(s.substring(start, start + 2)).intValue();
      // System.out.format("twoDigit: %d\n", twoDigits);
      if (twoDigits <= 26) {
        // if (0 < twoDigits && twoDigits <= 26) {
        cnt2 = helper1(s, start + 2, memo);
      }
    }

    memo[start] = cnt1 + cnt2;
    return memo[start];
  }

  //// --------------------- end (Approach1)---------------------
  //// ---------------------start(Approach2)---------------------
  // 20200405, dp. + space :O(n)
  // Your runtime beats 58.47 % of java submissions
  public int numDecodings2(String s) {
    if (s == null && s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    // base case
    dp[n] = 1;

    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        dp[i] = 0;
      } else {
        dp[i] = dp[i + 1];
        if (i + 1 < n && Integer.valueOf(s.substring(i, i + 2)).intValue() <= 26) {
          dp[i] += dp[i + 2];
        }
      }
    }

    return dp[0];
  }

  //// --------------------- end (Approach2)---------------------
  //// ---------------------start(Approach3)---------------------
  // 20200405, dp. + space: O(1)
  // Your runtime beats 96.47 % of java submissions
  public int numDecodings(String s) {
    if (s == null && s.length() == 0) {
      return 0;
    }
    int n = s.length();
    // int[] dp = new int[n + 1];
    // base case
    // dp[n] = 1;
    int dp_i2 = 1;
    int dp_i1 = 1;

    for (int i = n - 1; i >= 0; i--) {
      int tmp = dp_i1;
      if (s.charAt(i) == '0') {
        dp_i1 = 0;
      } else {
        if (i + 1 < n && Integer.valueOf(s.substring(i, i + 2)).intValue() <= 26) {
          dp_i1 += dp_i2;
          // dp[i] += dp[i + 2];
        }
      }
      dp_i2 = tmp;
    }

    return dp_i1;
  }
  //// --------------------- end (Approach3)---------------------
}
// @lc code=end
