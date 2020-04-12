/*
 * @lc app=leetcode id=256 lang=java
 *
 * [256] Paint House
 */

// @lc code=start
class Solution {
  //// -----------------------start(Approach1)-------------------------
  // 20200407. recursion
  // Time Limit Exceeded 19/101 cases passed (N/A)
  public int minCost1(int[][] costs) {
    int n = costs.length;
    if (n == 0) {
      return 0;
    }
    int[] res = helper1(costs, n - 1);
    return Math.min(Math.min(res[0], res[1]), res[2]);
  }

  private int[] helper1(int[][] costs, int num) {
    if (num == 0) {
      return costs[num];
    }

    int[] res = new int[3];
    for (int i = 0; i < costs[0].length; i++) {
      int min = Integer.MAX_VALUE;
      int[] ret = helper1(costs, num - 1);
      for (int j = 0; j < ret.length; j++) {
        if (j != i && ret[j] < min) {
          min = ret[j];
        }
      }
      res[i] = costs[num][i] + min;
    }
    return res;
  }

  //// ----------------------- end (Approach1)-------------------------
  //// -----------------------start(Approach1)-------------------------
  // 20200407, by myself. dp
  // Your runtime beats 50.14 % of java submissions
  public int minCost(int[][] costs) {
    int n = costs.length;
    if (n == 0) {
      return 0;
    }

    int[] dp = costs[0].clone();
    // int[] dp = new int[3];
    // System.arraycopy(costs[0], 0, dp, 0, 3);
    // System.out.format("dp:%s\n", Arrays.toString(dp));

    for (int i = 1; i < n; i++) {
      int[] tmp = dp.clone();
      dp[0] = costs[i][0] + Math.min(tmp[1], tmp[2]);
      dp[1] = costs[i][1] + Math.min(tmp[0], tmp[2]);
      dp[2] = costs[i][2] + Math.min(tmp[0], tmp[1]);
    }
    return Math.min(Math.min(dp[0], dp[1]), dp[2]);
  }
  //// ----------------------- end (Approach1)-------------------------
}
// @lc code=end
