/*
 * @lc app=leetcode id=265 lang=java
 *
 * [265] Paint House II
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)------------------------------
  // 20200407, by myself. backtracking + memo
  // Your runtime beats 38.59 % of java submissions
  public int minCostII1(int[][] costs) {
    int n = costs.length;
    if (n == 0) {
      return 0;
    }
    int k = costs[0].length;

    // memo
    int[][] memo = new int[n][k];
    for (int[] mem : memo) {
      Arrays.fill(mem, -1);
    }
    memo[n - 1] = costs[n - 1].clone();
    // System.out.format("memo:%s\n", Arrays.toString(memo[n - 1]));

    int res = Integer.MAX_VALUE;
    for (int j = 0; j < k; j++) {
      res = Math.min(res, helper1(costs, 0, j, memo));
    }

    return res;
  }

  private int helper1(int[][] costs, int house, int color, int[][] memo) {
    if (memo[house][color] != -1) {
      return memo[house][color];
    }

    int childCost = Integer.MAX_VALUE;
    for (int j = 0; j < costs[0].length; j++) {
      if (j != color) {
        childCost = Math.min(childCost, helper1(costs, house + 1, j, memo));
      }
    }

    int totalCost = childCost + costs[house][color];
    memo[house][color] = totalCost;
    return totalCost;
  }

  //// --------------- end (Approach1)------------------------------
  //// ---------------start(Approach2)------------------------------
  // 20200407, by myself. dp + space :O(n)
  // Your runtime beats 91.29 % of java submissions
  public int minCostII(int[][] costs) {
    int n = costs.length;
    if (n == 0) {
      return 0;
    }
    int k = costs[0].length;

    int[][] dp = new int[n][k];
    for (int[] d : dp) {
      Arrays.fill(d, -1);
    }
    dp[n - 1] = costs[n - 1].clone();

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j < k; j++) {

        int childCost = Integer.MAX_VALUE;
        for (int l = 0; l < k; l++) {
          if (l != j) {
            childCost = Math.min(childCost, dp[i + 1][l]);
          }
        }
        dp[i][j] = costs[i][j] + childCost;
      }
    }

    int res = dp[0][0];
    for (int r : dp[0]) {
      res = Math.min(res, r);
    }
    return res;
  }
  //// --------------- end (Approach2)------------------------------
}
// @lc code=end
