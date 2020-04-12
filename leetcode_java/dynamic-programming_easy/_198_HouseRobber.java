/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
  //// --------------start(Approach1)------------------
  // by myself. dp
  // Your runtime beats 100 % of java submissions
  public int rob(int[] nums) {
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
    //// -------------- end (Approach1)------------------
  }
}
// @lc code=end
