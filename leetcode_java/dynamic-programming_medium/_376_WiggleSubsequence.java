/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // dynamic programming

  public int wiggleMaxLength2(int[] nums) {
    // public int wiggleMaxLength(int[] nums) {
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

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  //
  // public int wiggleMaxLength(int[] nums) {
  public int wiggleMaxLength3(int[] nums) {
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
  //// ---------------- end (Approach3)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach4)-------------------------------------
  // 20200911, can't solve it by myself.
  // refer to leetcode:
  // Approach #2 Dynamic Programming
  // Approach #3 Linear Dynamic Programming
  // Approach #4 Space-Optimized Dynamic Programming

  // 27/27 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 96.19 % of java submissions (36.7 MB)

  public int wiggleMaxLength(int[] nums) {
    // public int wiggleMaxLength3(int[] nums) {
    int n = nums.length;
    if (n < 2)
      return n;

    int up = 1, down = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        up = down + 1;
      } else if (nums[i] < nums[i - 1]) {
        down = up + 1;
      }
    }
    return Math.max(up, down);
  }
  //// ---------------- end (Approach4)-------------------------------------
}
// @lc code=end
