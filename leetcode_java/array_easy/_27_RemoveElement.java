/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
  public int removeElement1(int[] nums, int val) {
    int low = 0;
    int high = nums.length - 1;
    int tmp = 0;
    int res = nums.length;
    while (low <= high) {
      while (low <= high && nums[low] != val) {
        low++;
      }
      while (low <= high && val == nums[high]) {
        high--;
        res--;
      }
      if (low <= high) {
        nums[low++] = nums[high--];
        res--;
      }
    }
    return res;
  }

  // optimal
  public int removeElement(int[] nums, int val) {
    if (null == nums && 0 == nums.length) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[res++] = nums[i];
      }
    }
    return res;
  }
}
// @lc code=end
