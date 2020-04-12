/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
  //// ---------------------start(Approach1)----------------------
  // 20200409, by myself. divide and conquer + memo
  // Your runtime beats 100 % of java submissions
  public int numTrees1(int n) {
    int[][] memo = new int[n + 1][n + 1];
    for (int[] mem : memo) {
      Arrays.fill(mem, -1);
    }

    int res = helper1(1, n, memo);
    // System.out.format("memo:\n%s\n", Arrays.deepToString(memo).replaceAll("\\],",
    // "\n"));
    return res;
  }

  private int helper1(int lo, int hi, int[][] memo) {
    if (lo >= hi) {
      return 1;
    }
    if (memo[lo][hi] != -1) {
      return memo[lo][hi];
    }

    int ret = 0;
    for (int i = lo; i <= hi; i++) {
      ret += helper1(lo, i - 1, memo) * helper1(i + 1, hi, memo);
    }

    memo[lo][hi] = ret;
    return ret;
  }

  //// --------------------- end (Approach1)----------------------
  //// ---------------------start(Approach2)----------------------
  // 20200409, by myself. dp + tabulation. space: O(n^2)
  // Your runtime beats 100 % of java submissions
  public int numTrees2(int n) {
    int[][] dp = new int[n + 2][n + 2];
    for (int[] d : dp) {
      Arrays.fill(d, 1);
    }

    for (int len = 2; len <= n; len++) {
      for (int lo = 1; lo <= n - len + 1; lo++) {
        int hi = lo + len - 1;
        int ret = 0;
        for (int piv = lo; piv <= hi; piv++) {
          ret += dp[lo][piv - 1] * dp[piv + 1][hi];
        }
        dp[lo][hi] = ret;
      }
    }
    // System.out.format("dp:\n%s\n", Arrays.deepToString(dp).replaceAll("\\],",
    // "\n"));

    return dp[1][n];
  }

  //// --------------------- end (Approach2)----------------------
  //// ---------------------start(Approach3)----------------------
  // 20200409, leetcode standard. dp + tabulation. space: O(n)
  // Your runtime beats 100 % of java submissions
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;

    for (int hi = 2; hi <= n; hi++) {
      for (int lo = 1; lo <= hi; lo++) {
        dp[hi] += dp[lo - 1] * dp[hi - lo];
      }
    }

    return dp[n];
  }
  //// --------------------- end (Approach3)----------------------
}
// @lc code=end
