/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
  public boolean increasingTriplet(int[] nums) {
    int localMin1 = Integer.MAX_VALUE;
    int localMin2 = Integer.MAX_VALUE;
    int localMin3 = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= localMin1) {
        localMin1 = nums[i];
      } else if (nums[i] <= localMin2) {
        localMin2 = nums[i];
      } else if (nums[i] < localMin3) {
        // } else if (nums[i] > localMin2) {
        localMin3 = nums[i];
        return true;
      }
    }
    return false;
  }
}
// @lc code=end
