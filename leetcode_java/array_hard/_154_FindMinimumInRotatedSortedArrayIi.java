/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      // while (lo < hi && nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
      // lo++;
      // hi--;
      // }
      while (mid < hi && nums[mid] == nums[hi]) {
        hi--;
      }
      // System.out.format("lo: %d, mid: %d, hi: %d\n", lo, mid, hi);
      // System.out.format("low: %d, middle: %d, high: %d\n", nums[lo], nums[mid],
      // nums[hi]);
      // System.out.println("---------------------------------------");
      if (nums[mid] <= nums[hi]) {
        hi = mid;
      } else if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      }
    }
    return nums[lo];
  }
}
// @lc code=end
