/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200402)///////////////////////////////////
  ////////////////// first round(20200402)///////////////////////////////////
  //// --------------start(Approach1)------------------------------
  // 20200402, by myself, one pass
  // Your runtime beats 91.29 % of java submissions
  public int maxProfit1(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int valley = prices[0];
    int sum = 0;
    for (int i = 1; i < n; i++) {
      if (prices[i] > valley) {
        sum += prices[i] - valley;
        // valley = prices[i];
        // } else if (prices[i] < valley) {
        // valley = prices[i];
      }
      valley = prices[i];
    }
    return sum;
  }

  //// -------------- end (Approach1)------------------------------
  //// --------------start(Approach2)------------------------------
  // 20200402, by myself, one pass
  // improvement of approach1
  // Your runtime beats 91.29 % of java submissions
  public int maxProfit2(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int res = 0;
    for (int i = 1; i < n; i++) {
      if (prices[i] > prices[i - 1]) {
        res += prices[i] - prices[i - 1];
      }
    }
    return res;
  }

  //// -------------- end (Approach2)------------------------------
  //// --------------start(Approach3)------------------------------
  // 20200403, dp
  // Your runtime beats 6.5 % of java submissions
  public int maxProfit3(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int[][] dp = new int[n][2];
    // base case
    dp[0][0] = 0;
    dp[0][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }

    return dp[n - 1][0];
  }

  //// -------------- end (Approach3)------------------------------
  //// --------------start(Approach4)------------------------------
  // 20200403, dp
  // improvement of approach2
  // Your runtime beats 91.17 % of java submissions

  // public int maxProfit(int[] prices) {
  public int maxProfit4(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int dp_i0 = 0;
    int dp_i1 = -prices[0];

    for (int i = 1; i < n; i++) {
      dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
      dp_i1 = Math.max(dp_i1, dp_i0 - prices[i]);
    }

    return dp_i0;
  }
  //// -------------- end (Approach4)------------------------------
  ////////////////// second round(20200813)///////////////////////////////////
  ////////////////// second round(20200813)///////////////////////////////////
  //// --------------start(Approach5)------------------------------
  // 20200813,
  // refer to approach4

  // 200/200 cases passed (1 ms)
  // Your runtime beats 94.51 % of java submissions
  // Your memory usage beats 76.73 % of java submissions (39.4 MB)

  public int maxProfit(int[] prices) {
    // public int maxProfit5(int[] prices) {
    int n = prices.length;
    if (n == 0)
      return 0;
    int dp0 = 0;
    int dp1 = -prices[0];
    for (int i = 1; i < n; i++) {
      dp0 = Math.max(dp0, dp1 + prices[i]);
      dp1 = Math.max(dp1, dp0 - prices[i]);
    }

    return dp0;
  }
  //// -------------- end (Approach5)------------------------------
}
// @lc code=end
