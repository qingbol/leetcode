package easy;
/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
  ////////////////////first round(20200103)////////////////////////////
  ////////////////////first round(20200103)////////////////////////////
  ////--------------------start(Approach1)----------------------
  //20200103
  // public int missingNumber(int[] nums) {
  public int missingNumber1(int[] nums) {
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
  ////-------------------- end (Approach1)----------------------
  ////////////////////second round(20200720)////////////////////////////
  ////////////////////second round(20200720)////////////////////////////
  ////--------------------start(Approach2)----------------------
  //20200103
  //122/122 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 9.21 % of java submissions (48 MB)

  public int missingNumber(int[] nums) {
  // public int missingNumber2(int[] nums) {
    int target = nums.length;
    for (int i = 0; i < nums.length; i++) {
      target ^= i ^ nums[i];
    }
    return target;
  }
  ////-------------------- end (Approach2)----------------------
}
// @lc code=end
