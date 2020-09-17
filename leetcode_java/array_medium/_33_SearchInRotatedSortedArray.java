/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200119)///////////////////////////////////
  ////////////////// first round(20200119)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200119
  // public int search(int[] nums, int target) {
  public int search1(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] >= nums[start]) {
        if (target >= nums[start] && target < nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (nums[mid] <= nums[end]) {
        // } else if (nums[mid] < nums[start]) {
        if (target > nums[mid] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915. Cant figure out the solution by myself. //The logic is hard to figure out. The only way is to remember it
  //refer to leetcode: Approach 2: One-pass Binary Search

  public int search(int[] nums, int target) {
  // public int search2(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] >= nums[lo]) {
        if (nums[lo] <= target && target < nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }
    return -1;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
