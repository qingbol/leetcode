/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120

  // public int findMin(int[] nums) {
  public int findMin1(int[] nums) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915
  // optimal, refer to leetcode: Approach 1: Variant of Binary Search

  // 192/192 cases passed (1 ms)
  // Your runtime beats 40.48 % of java submissions
  // Your memory usage beats 5.1 % of java submissions (41.5 MB)

  public int findMin(int[] nums) {
    // public int findMin2(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else if (nums[mid] < nums[hi]) {
        hi = mid;
      } else if (nums[mid] == nums[hi]) {
        hi--;
      }
    }
    return nums[lo];
  }

  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
