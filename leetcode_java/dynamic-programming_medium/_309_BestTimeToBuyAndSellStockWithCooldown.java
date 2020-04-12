/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
  //// -------------start(Approach1)--------------------------
  // 20200404. dp
  // Your runtime beats 56.08 % of java submissions
  public int maxProfit1(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      if (i > 1) {
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
      } else {
        dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
      }
    }

    return dp[n - 1][0];
  }

  //// ------------- end (Approach1)--------------------------
  //// -------------start(Approach2)--------------------------
  // 20200404. dp. improvement of Approach1
  // Your runtime beats 100 % of java submissions
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int dp_i10 = 0;
    int dp_i11 = -prices[0];
    int dp_pre20 = 0;

    for (int i = 1; i < n; i++) {
      int tmp = dp_i10;
      dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
      dp_i11 = Math.max(dp_i11, dp_pre20 - prices[i]);
      dp_pre20 = tmp;
    }

    return dp_i10;
  }
  //// ------------- end (Approach2)--------------------------
}
// @lc code=end
