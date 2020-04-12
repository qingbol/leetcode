/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
  //// ------------------start(Approach1)-------------------
  // 20200408, divide and conquer + memo
  // Your runtime beats 29.45 % of java submissions
  public int getMoneyAmount1(int n) {
    // System.out.format("%d\n", n);
    int[][] memo = new int[n + 1][n + 1];
    return helper1(1, n, memo);
  }

  private int helper1(int lo, int hi, int[][] memo) {
    if (lo >= hi) {
      return 0;
      // } else if (lo + 1 == hi) {
      // return lo;
      // } else if (lo + 2 == hi) {
      // return lo + 1;
    }

    if (memo[lo][hi] > 0) {
      return memo[lo][hi];
    }

    int ret = Integer.MAX_VALUE;
    for (int i = lo; i <= hi; i++) {
      ret = Math.min(ret, i + Math.max(helper1(lo, i - 1, memo), helper1(i + 1, hi, memo)));
    }

    memo[lo][hi] = ret;
    return ret;
  }

  //// ------------------ end (Approach1)-------------------
  //// ------------------start(Approach2)-------------------
  // 20200408, by myself, divide and conquer + memo
  // Your runtime beats 90.74 % of java submissions
  public int getMoneyAmount2(int n) {
    int[][] dp = new int[n + 1][n + 1];

    for (int lo = n - 1; lo >= 1; lo--) {
      for (int hi = lo + 1; hi <= n; hi++) {
        if (hi == lo + 1) {
          dp[lo][hi] = lo;
        } else if (hi == lo + 2) {
          dp[lo][hi] = lo + 1;
        } else {
          int tmp = Integer.MAX_VALUE;
          for (int i = lo; i < hi; i++) {
            // for (int i = lo; i <= hi; i++) {
            tmp = Math.min(tmp, i + Math.max(dp[lo][i - 1], dp[i + 1][hi]));
          }
          dp[lo][hi] = tmp;
        }
      }
    }

    return dp[1][n];
  }

  //// ------------------ end (Approach2)-------------------
  //// ------------------start(Approach3)-------------------
  // 20200408, dp + tabulation. improvement of approah2.
  // Your runtime beats 96.44 % of java submissions
  public int getMoneyAmount(int n) {
    int[][] dp = new int[n + 1][n + 1];

    for (int len = 2; len <= n; len++) {
      for (int lo = 1; lo <= n - len + 1; lo++) {
        // for (int lo = n - 1; lo >= 1; lo--) {
        int hi = lo + len - 1;
        int min = Integer.MAX_VALUE;
        for (int piv = lo + (len - 1) / 2; piv < hi; piv++) {
          min = Math.min(min, piv + Math.max(dp[lo][piv - 1], dp[piv + 1][hi]));
        }
        dp[lo][hi] = min;
      }
    }
    // System.out.format("dp:%s\n", Arrays.deepToString(dp).replaceAll("\\],",
    // "\n"));
    return dp[1][n];
  }
  //// ------------------ end (Approach3)-------------------
}
// @lc code=end
