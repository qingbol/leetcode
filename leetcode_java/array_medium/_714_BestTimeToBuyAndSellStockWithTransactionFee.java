/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200814)///////////////////////////////////
  ////////////////// first round(20200814)///////////////////////////////////
  //// -------------start(Approach1)--------------------------
  // 20200814. by myself

  // 44/44 cases passed (19 ms)
  // Your runtime beats 13.7 % of java submissions
  // Your memory usage beats 53.52 % of java submissions (49.2 MB)

  public int maxProfit(int[] prices, int fee) {
    // public int maxProfit1(int[] prices, int fee) {
    int n = prices.length;
    int[][] dp = new int[n + 1][2];
    // base case
    dp[0][1] = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
    }
    return dp[n][0];
  }
  //// ------------- end (Approach1)--------------------------
}
// @lc code=end
