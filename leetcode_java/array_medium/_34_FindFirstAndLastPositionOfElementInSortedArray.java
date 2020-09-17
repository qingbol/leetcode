/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120

  public int[] searchRange1(int[] nums, int target) {
    // public int[] searchRange(int[] nums, int target) {
    if (null == nums || 0 == nums.length) {
      return new int[] {-1, -1};
    }
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        int left = mid - 1;
        int right = mid + 1;
        while (left >= lo && nums[left] == target) {
          left--;
        }
        while (right <= hi && nums[right] == target) {
          right++;
        }
        return new int[] {++left, --right};
      } else if (nums[mid] > target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return new int[] {-1, -1};
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public int[] searchRange(int[] nums, int target) {
  public int[] searchRange2(int[] nums, int target) {
    int start = firstGreaterEqual(nums, target);
    if (start == nums.length || nums[start] != target) {
      return new int[] {-1, -1};
    }
    int end = firstGreaterEqual(nums, target + 1);
    return new int[] {start, end - 1};
  }

  private int firstGreaterEqual(int[] arr, int aim) {
    int lo = 0;
    int hi = arr.length;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] < aim) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200915.
  // just like approach2. the method to find the end is a little tricky.
  // int end = firstGreaterEqual(nums, target + 1);
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
