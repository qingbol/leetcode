/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)--------------------------
  // by myself. dp, space:o(n)
  // Your runtime beats 100 % of java submissions
  public int climbStairs1(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  //// --------------- end (Approach1)--------------------------
  //// ---------------start(Approach2)----
  // by myself. dp, space:o(1)
  // Your runtime beats 100 % of java submissions
  public int climbStairs(int n) {
    int prev = 1;
    int cur = 1;
    for (int i = 2; i < n + 1; i++) {
      int tmp = cur;
      cur = cur + prev;
      prev = tmp;
    }

    return cur;
  }
  //// --------------- end (Approach1)--------------------------
}
// @lc code=end
