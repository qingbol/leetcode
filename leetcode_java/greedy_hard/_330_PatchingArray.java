/*
 * @lc app=leetcode id=330 lang=java
 *
 * [330] Patching Array
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)--------------
  // 20200324. I can't come up with thi idea. new knowledge
  // Your runtime beats 100 % of java submissions
  public int minPatches(int[] nums, int n) {
    long miss = 1;
    int patch = 0;
    int i = 0;
    while (miss <= n) {
      if (i < nums.length && nums[i] <= miss) {
        miss += nums[i];
        i++;
      } else {
        miss += miss;
        patch++;
      }
    }

    return patch;
  }
  //// ---------------- end (Approach1)--------------
}
// @lc code=end
