/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200809)///////////////////////////////////
  ////////////////// first round(20200809)///////////////////////////////////
  // -------------------start(Approach1)-------------------
  // 20200809, by myself. dp

  // wrong
  // Your Input
  // 5
  // [1,2,5]
  // Output (6 ms)
  // 9
  // Expected Answer
  // 4

  // public int change(int amount, int[] coins) {
  public int change1(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin) {
          dp[i] += dp[i - coin];
        }
      }
    }
    System.out.format("dp: %s\n", Arrays.toString(dp));
    return dp[amount];
  }

  // ------------------- end (Approach1)-------------------
  // -------------------start(Approach2)-------------------
  // 20200809,
  // refer to labuladong<经典动态规划：完全背包问题>

  // 27/27 cases passed (146 ms)
  // Your runtime beats 5.04 % of java submissions
  // Your memory usage beats 35.26 % of java submissions (45.9 MB)

  // public int change(int amount, int[] coins) {
  public int change2(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= amount; j++) {
        for (int k = 0; k <= j / coins[i - 1]; k++) {
          // for (int k = 0; k <= amount / cons[i - 1]) {
          dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
        }
      }
    }
    return dp[n][amount];
  }
  // ------------------- end (Approach2)-------------------
  // -------------------start(Approach3)-------------------
  // 20200809, optimized version
  // refer to labuladong<经典动态规划：完全背包问题>

  // 27/27 cases passed (2 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 91.03 % of java submissions (36.8 MB)

  public int change(int amount, int[] coins) {
    // public int change3(int amount, int[] coins) {
    int n = coins.length;
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int i = 0; i < n; i++) {
      // for (int j = 1; j <= amount; j++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] = dp[j] + dp[j - coins[i]];
      }
    }
    return dp[amount];
  }
  // ------------------- end (Approach3)-------------------
}
// @lc code=end
