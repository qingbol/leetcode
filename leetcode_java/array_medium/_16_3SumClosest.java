/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int res = nums[0] + nums[1] + nums[nums.length - 1];
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (sum > target) {
          hi--;
        } else {
          lo++;
        }
        if (Math.abs(sum - target) < Math.abs(res - target)) {
          res = sum;
        }
      }
    }
    return res;
  }
}
// @lc code=end
