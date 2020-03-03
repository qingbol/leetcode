/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
  public int removeDuplicates1(int[] nums) {
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

  //
  public int removeDuplicates(int[] nums) {
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
}
// @lc code=end
