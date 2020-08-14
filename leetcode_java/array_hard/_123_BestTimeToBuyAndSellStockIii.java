/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200402)///////////////////////////////////
  ////////////////// first round(20200402)///////////////////////////////////
  //// ---------------------start(Approach1)---------------------
  // 20200402,by myself.
  // wrong
  public int maxProfit1(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    int max = 0;
    int secondMax = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (prices[j] - prices[i] > max) {
          max = prices[j] - prices[i];
        } else if (prices[j] - prices[i] > secondMax) {
          secondMax = prices[j] - prices[i];
        }
      }
      System.out.format("max:%d, second:%d\n", max, secondMax);
    }
    return max + secondMax;
  }

  //// --------------------- end (Approach1)---------------------
  //// ---------------------start(Approach2)---------------------
  // 20200402, dp. from
  //// https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti
  // Your runtime beats 23.51 % of java submissions
  public int maxProfit2(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    int k = 2;
    int[][][] profit = new int[n][k + 1][2];

    //// =============start(base case)=================
    for (int l = 0; l < k + 1; l++) {
      profit[0][l][0] = 0;
      profit[0][l][1] = -prices[0];
      // profit[0][l][1] = Integer.MIN_VALUE;
    }
    for (int i = 0; i < n; i++) {
      profit[i][0][0] = 0;
      profit[i][0][1] = Integer.MIN_VALUE;
    }
    //// ============= end (base case)=================

    for (int i = 1; i < n; i++) {
      for (int l = 1; l <= k; l++) {
        profit[i][l][0] = Math.max(profit[i - 1][l][0], profit[i - 1][l][1] + prices[i]);
        profit[i][l][1] = Math.max(profit[i - 1][l][1], profit[i - 1][l - 1][0] - prices[i]);
      }
    }
    // System.out.format("profit: \n%s\n",
    // Arrays.deepToString(profit).replaceAll("\\]\\],", "\\]\n"));
    return profit[n - 1][k][0];
  }

  //// --------------------- end (Approach2)---------------------
  //// ---------------------start(Approach3)---------------------
  // 20200402, dp. from
  //// https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti
  // improvement of Approch2. simplify the base case initialization
  // Your runtime beats 18.44 % of java submissions

  // public int maxProfit(int[] prices) {
  public int maxProfit3(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    int k = 2;
    int[][][] profit = new int[n][k + 1][2];

    //// =============start(base case)=================
    for (int l = 1; l < k + 1; l++) {
      // for (int l = 0; l < k + 1; l++) {
      // profit[0][l][0] = 0;
      profit[0][l][1] = -prices[0];
      // profit[0][l][1] = Integer.MIN_VALUE;
    }

    // for (int i = 0; i < n; i++) {
    // profit[i][0][0] = 0;
    // profit[i][0][1] = Integer.MIN_VALUE;
    // }
    //// ============= end (base case)=================

    for (int i = 1; i < n; i++) {
      for (int l = 1; l <= k; l++) {
        profit[i][l][0] = Math.max(profit[i - 1][l][0], profit[i - 1][l][1] + prices[i]);
        profit[i][l][1] = Math.max(profit[i - 1][l][1], profit[i - 1][l - 1][0] - prices[i]);
        // profit[i][l][1] = Math.max(profit[i - 1][l][1], profit[i - 1][l][0] -
        // prices[i]);
      }
    }
    // System.out.format("profit: \n%s\n",
    // Arrays.deepToString(profit).replaceAll("\\]\\],", "\\]\n"));
    return profit[n - 1][k][0];
  }

  //// --------------------- end (Approach3)---------------------
  //// ---------------------start(Approach4)---------------------
  // 20200402, dp. from
  //// https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti
  // improvement of Approch3. remove the for loop of k.
  // Your runtime beats 91.77 % of java submissions
  public int maxProfit4(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    //// =============start(base case)=================
    // when k == 0, for any day i, and don't hold stock, the profit equals 0;
    int dp_i00 = 0;
    // when k == 1, for the first day i == 0, the initial value
    int dp_i10 = 0;
    int dp_i11 = -prices[0];
    // when k == 2, for the first day i == 0, the initial value
    int dp_i20 = 0;
    int dp_i21 = -prices[0];
    //// ============= end (base case)=================

    for (int i = 1; i < n; i++) {
      // when k == 1;
      dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
      dp_i11 = Math.max(dp_i11, dp_i00 - prices[i]);

      // when k == 2;
      dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
      dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
    }
    return dp_i20;
  }

  //// --------------------- end (Approach4)---------------------
  //// ---------------------start(Approach5)---------------------
  // 20200402, dp. from
  //// https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti
  // variation of Approch4. start from i = -1;
  // Your runtime beats 91.77 % of java submissions

  public int maxProfit5(int[] prices) {
    // public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }

    //// =============start(base case)=================
    // when k == 0, for any day i, and don't hold stock, the profit equals 0;
    int dp_i00 = 0;
    // when k == 1, for the first day i == 0, the initial value
    int dp_i10 = 0;
    int dp_i11 = Integer.MIN_VALUE;
    // when k == 2, for the first day i == 0, the initial value
    int dp_i20 = 0;
    int dp_i21 = Integer.MIN_VALUE;
    //// ============= end (base case)=================

    for (int i = 0; i < n; i++) {
      // when k == 1;
      dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
      dp_i11 = Math.max(dp_i11, dp_i00 - prices[i]);

      // when k == 2;
      dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
      dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
    }
    return dp_i20;
  }
  //// --------------------- end (Approach5)---------------------
  ////////////////// second round(20200813)///////////////////////////////////
  ////////////////// second round(20200813)///////////////////////////////////
  //// ---------------------start(Approach6)---------------------
  // 20200813
  //refer to labuladong<团灭 LeetCode 股票买卖问题>

  // 200/200 cases passed (5 ms)
  // Your runtime beats 29.89 % of java submissions
  // Your memory usage beats 42.52 % of java submissions (40.8 MB)

  public int maxProfit(int[] prices) {
    // public int maxProfit6(int[] prices) {
    int n = prices.length;
    int k = 2;
    // int[day][transaction times][stock hold status]
    // day1's price is prices[day1 - 1]
    int[][][] profit = new int[n + 1][k + 1][2];
    // base case
    for (int l = 0; l <= k; l++) {
      profit[0][l][1] = Integer.MIN_VALUE;
    }

    for (int i = 1; i <= n; i++) {
      for (int l = 1; l <= k; l++) {
        profit[i][l][0] = Math.max(profit[i - 1][l][0], profit[i - 1][l][1] + prices[i - 1]);
        profit[i][l][1] = Math.max(profit[i - 1][l][1], profit[i - 1][l - 1][0] - prices[i - 1]);
      }
    }
    return profit[n][k][0];
  }
  //// --------------------- end (Approach6)---------------------
}
// @lc code=end
