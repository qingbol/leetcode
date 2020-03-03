/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 */

// @lc code=start
class Solution {
  public int[] getModifiedArray1(int length, int[][] updates) {
    int[] nums = new int[length];
    for (int i = 0; i < updates.length; i++) {
      for (int j = updates[i][0]; j <= updates[i][1]; j++) {
        nums[j] += updates[i][2];
      }
      // System.out.println("nums: " + Arrays.toString(nums));
    }
    return nums;
  }

  //
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] nums = new int[length];
    for (int[] update : updates) {
      nums[update[0]] += update[2];
      if (update[1] + 1 < length) {
        nums[update[1] + 1] -= update[2];
      }
    }
    for (int i = 1; i < length; i++) {
      nums[i] += nums[i - 1];
    }
    return nums;
  }
}
// @lc code=end
