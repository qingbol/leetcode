/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200404)///////////////////////////////////
  ////////////////// first round(20200404)///////////////////////////////////
  //// --------------start(Approach1)---------------------------
  // 20200404. dp
  // wrong
  public int rob1(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    int prev = 0;
    int cur = nums[0];
    for (int i = 1; i < n; i++) {
      int tmp = cur;
      if (i % 2 == 1) {
        cur = Math.max(cur, prev + nums[i]);
      } else {
        cur = Math.max(cur, Math.max(prev, prev + nums[i] - nums[0]));
      }
      prev = tmp;
    }
    return cur;
  }

  //// -------------- end (Approach1)---------------------------
  //// --------------start(Approach2)---------------------------
  // 20200404. dp with circle.
  // Your runtime beats 100 % of java submissions

  // public int rob(int[] nums) {
  public int rob2(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return nums[0];
    }

    return Math.max(helper2(nums, 0, n - 2), helper2(nums, 1, n - 1));
  }

  private int helper2(int[] nums, int l, int r) {
    int prev = 0;
    int cur = nums[l];
    for (int i = l + 1; i <= r; i++) {
      int tmp = cur;
      cur = Math.max(cur, nums[i] + prev);
      prev = tmp;
    }

    return cur;
  }
  //// -------------- end (Approach2)---------------------------
  ////////////////// second round(20200814)///////////////////////////////////
  ////////////////// second round(20200814)///////////////////////////////////
  //// --------------start(Approach3)---------------------------
  // 20200814. can't come up with a solution by myself.
  //refer to labuladong<团灭 LeetCode 打家劫舍问题>

  // 74/74 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 85.01 % of java submissions (36.7 MB)

  // public int rob3(int[] nums) {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    if (n == 1)
      return nums[0];
    return Math.max(helper3(nums, 0, n - 2), helper3(nums, 1, n - 1));
  }

  private int helper3(int[] nums, int l, int r) {
    int n = r - l + 1;
    int[] dp = new int[n + 2];

    for (int i = 2; i < n + 2; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[l + i - 2]);
    }
    return dp[n + 1];
  }
  //// -------------- end (Approach3)---------------------------
}
// @lc code=end
