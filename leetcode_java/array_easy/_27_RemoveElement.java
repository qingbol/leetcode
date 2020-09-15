/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200111
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
  //// --------------------------- end (Approach1)-----------------------
  //// ---------------------------start(Approach2)-----------------------

  // optimal
  // public int removeElement(int[] nums, int val) {
  public int removeElement2(int[] nums, int val) {
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
  //// --------------------------- end (Approach2)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200908, by myself.

//   113/113 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 84.27 % of java submissions (37.9 MB)

  // public int removeElement3(int[] nums, int val) {
  public int removeElement(int[] nums, int val) {
    int n = nums.length;
    int left = 0, right = 0; 
    while (right < n) {
      if (nums[right] != val) {
        nums[left] = nums[right];
        left++;
      }
      right++;
    }
    return left;
  }

  //// --------------------------- end (Approach2)-----------------------
}
// @lc code=end
