/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start
class Solution {
  int[] nums;
  Random rand;

  public Solution(int[] nums) {
    this.nums = nums;
    this.rand = new Random();
  }

  public int pick(int target) {
    int idx = -1;
    int cnt = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target && rand.nextInt(cnt++) == 0) {
        idx = i;
      }
    }
    return idx;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */
// @lc code=end
