/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200404)///////////////////////////////////
  ////////////////// first round(20200404)///////////////////////////////////
  //// --------------start(Approach1)------------------
  // 20200404
  // by myself. dp
  // Your runtime beats 100 % of java submissions

  // public int rob(int[] nums) {
  public int rob1(int[] nums) {
    int n = nums.length;
    if (n < 1) {
      return 0;
    }

    int prev2 = 0;
    int cur = nums[0];
    for (int i = 1; i < n; i++) {
      int tmp = cur;
      cur = Math.max(cur, prev2 + nums[i]);
      prev2 = tmp;
    }
    return cur;
  }
  //// -------------- end (Approach1)------------------
  ////////////////// second round(20200814)///////////////////////////////////
  ////////////////// second round(20200814)///////////////////////////////////
  //// --------------start(Approach1)------------------
  // 20200814 // by myself. dp

  // 69/69 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 92.76 % of java submissions (36.6 MB)

  public int rob(int[] nums) {
    // public int rob2(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n + 2];

    for (int i = 2; i < n + 2; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
    }
    return dp[n + 1];
  }
  //// -------------- end (Approach1)------------------
}
// @lc code=end
