/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
  public boolean search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        return true;
      }
      while (lo <= hi && nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
        lo++;
        hi--;
      }
      if (lo > hi)
        break;

      if (nums[mid] >= nums[lo]) {
        if (nums[lo] <= target && target < nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else if (nums[mid] <= nums[hi]) {
        if (nums[mid] < target && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }
    return false;
  }
}
// @lc code=end
