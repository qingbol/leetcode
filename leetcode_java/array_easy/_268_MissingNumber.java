package easy;
/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
  public int missingNumber(int[] nums) {
    // int[] numsHelper = new int[nums.length + 1];
    // for (int i = 0; i < nums.length + 1; i++) {
    // numsHelper[i] = i;
    // }
    // int target = numsHelper[numsHelper.length - 1];
    int target = nums.length;
    for (int i = 0; i < nums.length; i++) {
      target ^= i ^ nums[i];
    }
    return target;
  }
}
// @lc code=end
