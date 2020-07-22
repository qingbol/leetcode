/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
  //// ---------------------start(Approach1)------------------------
  // 20200111.
  public int removeDuplicates1(int[] nums) {
    // public int removeDuplicates(int[] nums) {
    int left = 0;
    int right = 0;
    int res = 1;
    while (right < nums.length) {
      while (right < nums.length && nums[left] == nums[right]) {
        right++;
      }
      if (right < nums.length) {
        nums[++left] = nums[right++];
        res++;
      }
    }
    return res;
  }

  //// --------------------- end (Approach1)------------------------
  //// ---------------------start(Approach2)------------------------
  // 20200111.
  //
  // public int removeDuplicates(int[] nums) {
  public int removeDuplicates2(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return 0;
    }
    int res = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] != nums[i]) {
        nums[res++] = nums[i];
      }
    }
    return res;
  }

  //// --------------------- end (Approach2)------------------------
  //////////////////// 20200718_secound round///////////////////////
  //////////////////// 20200718_secound round///////////////////////
  //// ---------------------start(Approach3)------------------------
  // 2020718
  // 161/161 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  public int removeDuplicates(int[] nums) {
    // public int removeDuplicates3(int[] nums) {
    int newEnd = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[newEnd++] = nums[i];
      }
    }
    return newEnd;
  }
  //// --------------------- end (Approach3)------------------------
}
// @lc code=end
