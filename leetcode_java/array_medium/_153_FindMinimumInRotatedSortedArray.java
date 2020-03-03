/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
  public int findMin1(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.format("lo: %d, mid: %d, hi: %d\n", lo, mid, hi);
      // System.out.format("low: %d, middle: %d, high: %d\n", nums[lo], nums[mid],
      // nums[hi]);
      // System.out.println("---------------------------------------");
      if (nums[lo] <= nums[mid] && nums[mid] <= nums[hi]) {
        hi = lo;
      } else if (nums[lo] <= nums[mid] && nums[mid] >= nums[hi]) {
        lo = mid + 1;
      } else if (nums[lo] >= nums[mid] && nums[mid] <= nums[hi]) {
        hi = mid;
      }
    }
    return nums[lo];
  }

  //
  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
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
