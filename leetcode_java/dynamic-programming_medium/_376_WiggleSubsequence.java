/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
class Solution {
  // recursion
  public int wiggleMaxLength1(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    return 1 + Math.max(wigLength(nums, 0, true), wigLength(nums, 0, false));
  }

  public int wigLength(int[] arr, int start, boolean isUp) {
    int max = 0;
    for (int i = start + 1; i < arr.length; i++) {
      if (isUp && arr[i] > arr[i - 1] || !isUp && arr[i] < arr[i - 1]) {
        max = Math.max(max, 1 + wigLength(arr, i, !isUp));
      }
    }
    return max;
  }

  // dynamic programming
  public int wiggleMaxLength2(int[] nums) {
    int up[] = new int[nums.length];
    int down[] = new int[nums.length];

    up[0] = down[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        up[i] = 1 + down[i - 1];
        down[i] = down[i - 1];
      } else if (nums[i] < nums[i - 1]) {
        down[i] = 1 + up[i - 1];
        up[i] = up[i - 1];
      } else {
        up[i] = up[i - 1];
        down[i] = down[i - 1];
      }
    }
    return Math.max(up[nums.length - 1], down[nums.length - 1]);
  }

  //
  public int wiggleMaxLength(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    // int count = 1;
    int isUp = nums[1] - nums[0];
    // if (isUp != 0) {
    // count++;
    // }
    int count = isUp == 0 ? 1 : 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] > nums[i - 1] && isUp <= 0 || nums[i] < nums[i - 1] && isUp >= 0) {
        count++;
        isUp = nums[i] - nums[i - 1];
      }
    }
    return count;
  }
}
// @lc code=end
