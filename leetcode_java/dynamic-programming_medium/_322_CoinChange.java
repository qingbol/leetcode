/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
  //// -----------------start(Approach1)----------------
  // 20200407, by myself. backtracking
  // Your runtime beats 23.25 % of java submissions
  public int coinChange1(int[] coins, int amount) {
    Integer[] memo = new Integer[amount + 1];
    memo[0] = 0;
    return helper1(coins, amount, memo);
  }

  private int helper1(int[] coins, int amount, Integer[] memo) {
    if (memo[amount] != null) {
      return memo[amount];
    }
    // if (amount == 0) {
    // return 0;
    // }

    int ret = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (amount >= coin) {
        int cnt = helper1(coins, amount - coin, memo);
        if (cnt != -1) {
          ret = Math.min(ret, cnt + 1);
        }
      }
    }

    ret = ret == Integer.MAX_VALUE ? -1 : ret;
    memo[amount] = ret;
    return ret;
  }

  //// ----------------- end (Approach1)----------------
  //// -----------------start(Approach2)----------------
  // 20200407, dp
  // Your runtime beats 64.28 % of java submissions
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        }
      }
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
  //// ----------------- end (Approach2)----------------
}
// @lc code=end
