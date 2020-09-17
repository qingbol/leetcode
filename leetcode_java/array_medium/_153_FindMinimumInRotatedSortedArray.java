/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public int findMin(int[] nums) {
  public int findMin2(int[] nums) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200915
  // refer to leetcode : Approach 1: Binary Search

  // 146/146 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 65.32 % of java submissions (39.1 MB)

  public int findMin(int[] nums) {
    // public int findMin3(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    if (nums[hi] >= nums[lo])
      return nums[lo];
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }
      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }

      if (nums[mid] > nums[lo]) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
