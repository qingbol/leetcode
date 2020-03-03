/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 */

// @lc code=start
class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (sum < target) {
          res += hi - lo;
          lo++;
        } else {
          hi--;
        }
      }
    }
    return res;
  }
}
// @lc code=end
