/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200404)///////////////////////////////////
  ////////////////// first round(20200404)///////////////////////////////////
  //// -----------------start(Approach1)--------------------------
  // 20200404. dp.
  // Memory Limit Exceeded 209/211 cases passed (N/A)
  // Testcase 1000000000 ' + '[106,373, ...]
  public int maxProfit1(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int[][][] dp = new int[n][k + 1][2];
    // base case
    for (int l = 1; l <= k; l++) {
      dp[0][l][1] = -prices[0];
    }

    for (int i = 1; i < n; i++) {
      for (int l = 1; l <= k; l++) {
        dp[i][l][0] = Math.max(dp[i - 1][l][0], dp[i - 1][l][1] + prices[i]);
        dp[i][l][1] = Math.max(dp[i - 1][l][1], dp[i - 1][l - 1][0] - prices[i]);
      }
    }

    return dp[n - 1][k][0];
  }

  //// ----------------- end (Approach1)--------------------------
  //// -----------------start(Approach2)--------------------------
  // 20200404. dp. improvement of approach1
  // Your runtime beats 23.93 % of java submissions

  // public int maxProfit(int k, int[] prices) {
  public int maxProfit2(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    if (k >= n / 2) {
      // return kInf1(prices, n);
      return kInf2(prices, n);
    }

    int[][][] dp = new int[n][k + 1][2];
    // base case
    for (int l = 1; l <= k; l++) {
      dp[0][l][1] = -prices[0];
    }
    for (int i = 1; i < n; i++) {
      for (int l = 1; l <= k; l++) {
        dp[i][l][0] = Math.max(dp[i - 1][l][0], dp[i - 1][l][1] + prices[i]);
        dp[i][l][1] = Math.max(dp[i - 1][l][1], dp[i - 1][l - 1][0] - prices[i]);
      }
    }

    return dp[n - 1][k][0];
  }

  private int kInf1(int[] prices, int n) {
    int dp_i0 = 0;
    int dp_i1 = -prices[0];
    for (int i = 1; i < n; i++) {
      dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
      dp_i1 = Math.max(dp_i1, dp_i0 - prices[i]);
    }
    return dp_i0;
  }

  private int kInf2(int[] prices, int n) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
      if (prices[i] > prices[i - 1]) {
        sum += prices[i] - prices[i - 1];
      }
    }
    return sum;
  }
  //// ----------------- end (Approach2)--------------------------
  ////////////////// second round(20200813)///////////////////////////////////
  ////////////////// second round(20200813)///////////////////////////////////
  //// -----------------start(Approach3)--------------------------
  // 20200813
  // refer to labuladong<团灭 LeetCode 股票买卖问题>

  // without k >= n / 2 branch
  // Memory Limit Exceeded
  // 209/211 cases passed (N/A)
  // Testcase
  // 1000000000

  // with k>= n/2 branch.
  // 211/211 cases passed (9 ms)
  // Your runtime beats 25.41 % of java submissions
  // Your memory usage beats 12.93 % of java submissions (41.4 MB)

  public int maxProfit(int k, int[] prices) {
    // public int maxProfit3(int k, int[] prices) {
    int n = prices.length;
    // k>=n/2
    if (k >= n / 2) {
      return infProfit3(prices);
    }
    // k < n/2
    int[][][] dp = new int[n + 1][k + 1][2];

    // base case:. prices[-1]
    for (int l = 0; l <= k; l++) {
      dp[0][l][1] = Integer.MIN_VALUE;
    }

    for (int i = 1; i <= n; i++) {
      for (int l = 1; l <= k; l++) {
        dp[i][l][0] = Math.max(dp[i - 1][l][0], dp[i - 1][l][1] + prices[i - 1]);
        dp[i][l][1] = Math.max(dp[i - 1][l][1], dp[i - 1][l - 1][0] - prices[i - 1]);
      }
    }
    return dp[n][k][0];
  }

  private int infProfit3(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n + 1][2];
    // base case
    dp[0][1] = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
    }
    return dp[n][0];
  }
  //// ----------------- end (Approach3)--------------------------
}
// @lc code=end
