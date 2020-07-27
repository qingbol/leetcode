/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
  ////////////////////// first round(20200407)////////////////////
  ////////////////////// first round(20200407)////////////////////
  //// -----------------start(Approach1)----------------------
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
  // public int coinChange(int[] coins, int amount) {
  public int coinChange2(int[] coins, int amount) {
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
  ////////////////////// second round(20200724)////////////////////
  ////////////////////// second round(20200724)////////////////////
  //// -----------------start(Approach3)----------------------
  // 20200724, by myself. backtracking1(bad mod for this problem)

  // Time Limit Exceeded
  // 15/182 cases passed (N/A)

  // public int coinChange(int[] coins, int amount) {
  public int coinChange3(int[] coins, int amount) {
    int[] numOfCoins = new int[] { Integer.MAX_VALUE };
    helper3(coins, amount, 0, numOfCoins);
    return numOfCoins[0] == Integer.MAX_VALUE ? -1 : numOfCoins[0];
  }

  private void helper3(int[] coins, int amount, int localNum, int[] numOfCoins) {
    if (amount == 0) {
      numOfCoins[0] = Math.min(numOfCoins[0], localNum);
      return;
    } else if (amount < 0) {
      return;
    }

    for (int coin : coins) {
      helper3(coins, amount - coin, localNum + 1, numOfCoins);
    }

  }
  //// ----------------- end (Approach3)----------------------
  //// -----------------start(Approach4)----------------------
  // 20200724, by myself. backtracking1(good mode for this problem)

  // Time Limit Exceeded
  // 15/182 cases passed (N/A)

  public int coinChange(int[] coins, int amount) {
    // public int coinChange3(int[] coins, int amount) {
    return helper4(coins, amount);
  }

  private int helper4(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    } else if (amount < 0) {
      return -1;
    }

    int localMinNumOfCoins = Integer.MAX_VALUE;
    for (int coin : coins) {
      int ret = helper4(coins, amount - coin);
      if (ret != -1) {
        localMinNumOfCoins = Math.min(localMinNumOfCoins, ret + 1);
      }
    }

    return localMinNumOfCoins == Integer.MAX_VALUE ? -1 : localMinNumOfCoins;
  }
  //// ----------------- end (Approach4)----------------------
}
// @lc code=end
