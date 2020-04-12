/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
  //// --------------------start(Approach1)----------------
  // 20200407, by myself. backtracking + memo
  // Your runtime beats 34.65 % of java submissions
  public int numSquares1(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    memo[0] = 0;
    return helper1(n, memo);
  }

  private int helper1(int n, int[] memo) {
    if (memo[n] != -1) {
      return memo[n];
    }

    int cnt = Integer.MAX_VALUE;
    for (int i = (int) Math.sqrt(n); i >= 1; i--) {
      cnt = Math.min(cnt, 1 + helper1(n - i * i, memo));
    }

    memo[n] = cnt;
    return cnt;
  }

  //// -------------------- end (Approach1)----------------
  //// --------------------start(Approach2)----------------
  // 20200407, by myself. backtracking + memo
  // Your runtime beats 75.29 % of java submissions
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = (int) Math.sqrt(i); j >= 1; j--) {
        dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
      }
    }
    return dp[n];
  }
  //// -------------------- end (Approach2)----------------
}
// @lc code=end
