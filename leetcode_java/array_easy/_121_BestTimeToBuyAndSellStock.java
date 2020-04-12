/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
  //// ------------start(Approch1)--------------------------
  // 20200402. by myself, brute force.
  // Your runtime beats 15.52 % of java submissions
  public int maxProfit1(int[] prices) {
    int n = prices.length;
    int max = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (prices[j] > prices[i]) {
          max = Math.max(max, prices[j] - prices[i]);
        }
      }
    }
    return max;
  }

  //// ------------ end (Approch1)--------------------------
  //// ------------start(Approch2)--------------------------
  // 20200402. one pass
  // Your runtime beats 99.09 % of java submissions
  public int maxProfit2(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    int valley = prices[0];
    int hill = prices[0];
    int diff = 0;

    for (int i = 1; i < n; i++) {
      if (prices[i] < valley) {
        valley = prices[i];
        hill = prices[i];
      } else if (prices[i] > hill) {
        hill = prices[i];
        diff = Math.max(diff, hill - valley);
      }
    }
    return diff;
  }

  //// ------------ end (Approch2)--------------------------
  //// ------------start(Approch3)--------------------------
  // 20200402. one pass. improvement of Approch2
  // Your runtime beats 99.09 % of java submissions
  public int maxProfit3(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    int valley = prices[0];
    // int hill = prices[0];
    int diff = 0;

    for (int i = 1; i < n; i++) {
      if (prices[i] < valley) {
        valley = prices[i];
        // hill = prices[i];
      } else if (prices[i] - valley > diff) {
        diff = prices[i] - valley;
        // } else if (prices[i] > hill) {
        // hill = prices[i];
        // diff = Math.max(diff, hill - valley);
      }
    }
    return diff;
  }

  //// ------------ end (Approch3)--------------------------
  //// ------------start(Approch4)--------------------------
  // 20200403. dp
  // Your runtime beats 18.67 % of java submissions
  public int maxProfit4(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    // dp[day][hold or not]
    int[][] dp = new int[n][2];

    // base case;
    // on first day, dont hold any stock. the profit is 0;
    dp[0][0] = 0;
    // on first day, do hold a stock. it must be bought today.
    dp[0][1] = -prices[0];

    // traverse all the days
    // there's a trap here.
    // you shoule use
    // dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
    // instead of
    // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }

    // System.out.format("dp:%s\n", Arrays.deepToString(dp));
    return dp[n - 1][0];
  }

  //// ------------ end (Approch4)--------------------------
  //// ------------start(Approch5)--------------------------
  // 20200403. dp
  // Your runtime beats 99.1% of java submissions
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    // dp[day][hold or not]
    // int[][] dp = new int[n][2];
    int dp_i0 = 0;
    int dp_i1 = -prices[0];

    for (int i = 1; i < n; i++) {
      dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
      dp_i1 = Math.max(dp_i1, -prices[i]);
    }

    // System.out.format("dp:%s\n", Arrays.deepToString(dp));
    return dp_i0;
  }
  //// ------------ end (Approch5)--------------------------
}
// @lc code=end
