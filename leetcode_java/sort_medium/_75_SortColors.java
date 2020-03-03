/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
  public void sortColors(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int[] count = new int[max + 1];

    // scatter
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]] += 1;
    }

    // gather
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i]; j++) {
        nums[index++] = i;
      }
    }

  }
}
// @lc code=end
