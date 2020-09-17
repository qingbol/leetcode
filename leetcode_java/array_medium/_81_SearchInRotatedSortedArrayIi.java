/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200119)///////////////////////////////////
  ////////////////// first round(20200119)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200119
  // public boolean search(int[] nums, int target) {
  public boolean search1(int[] nums, int target) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915
  // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28218/My-8ms-C%2B%2B-solution-(o(logn)-on-average-o(n)-worst-case)


  // 275/275 cases passed (1 ms)
  // Your runtime beats 41.62 % of java submissions
  // Your memory usage beats 13.87 % of java submissions (41.2 MB)

  public boolean search(int[] nums, int target) {
    // public boolean search2(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        return true;
      }

      if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
        lo++;
        hi--;
      } else if (nums[mid] >= nums[lo]) {
        if (nums[lo] <= target && target < nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else if (nums[mid] <= nums[lo]) {
        if (nums[mid] < target && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }

    return false;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
