/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200119)///////////////////////////////////
  ////////////////// first round(20200119)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200119

  // public int searchInsert(int[] nums, int target) {
  public int searchInsert1(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return left;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915. by myself

//   62/62 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.01 % of java submissions (41.2 MB)

  public int searchInsert(int[] nums, int target) {
    // public int searchInsert2(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.format("mid: %d\n", mid);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
  //// ---------------- end (Approach2)-------------------------------------

}
// @lc code=end
