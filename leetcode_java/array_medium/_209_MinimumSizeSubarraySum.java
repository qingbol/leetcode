/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200110)///////////////////////////////////
  ////////////////// first round(20200110)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200110.
  public int minSubArrayLen1(int s, int[] nums) {
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    int localLen = 0;
    // int slide = 0;
    for (int i = 0; i < nums.length; i++) {
      localLen = 1;
      sum += nums[i];
      if (sum >= s) {
        minLen = Math.min(minLen, localLen);
        break;
      }
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        localLen += 1;
        if (sum >= s) {
          minLen = Math.min(minLen, localLen);
          // slide = j;
          break;
        }
      }
    }

    return Integer.MAX_VALUE == minLen ? 0 : minLen;
  }
  //// -------------- end (Approach1)------------------------
  //// --------------start(Approach2)------------------------
  // optimal solution: sliding window

  // public int minSubArrayLen(int s, int[] nums) {
  public int minSubArrayLen2(int s, int[] nums) {
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    int left = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (left <= i && sum >= s) {
        minLen = Math.min(minLen, i - left + 1);
        sum -= nums[left];
        left++;
      }
    }
    return Integer.MAX_VALUE == minLen ? 0 : minLen;
  }
  //// -------------- end (Approach2)------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  //// --------------start(Approach3)------------------------
  // 20200909.
  // sliding window. refer to Approach #4 Using 2 pointers [Accepted]

  // 15/15 cases passed (1 ms)
  // Your runtime beats 99.97 % of java submissions
  // Your memory usage beats 60.26 % of java submissions (39.6 MB)

  public int minSubArrayLen(int s, int[] nums) {
    // public int minSubArrayLen3(int s, int[] nums) {
    int n = nums.length;
    // 1. get the accumulate sum
    // for (int i = 1; i < n; i++) {
    // nums[i] += nums[i - 1];
    // }
    // 2. sliding wendow
    int sum = 0;
    int left = 0, right = 0;
    int res = Integer.MAX_VALUE;
    while (right < n) {
      sum += nums[right];
      while (left <= right && sum >= s) {
        res = Math.min(res, right - left + 1);
        sum -= nums[left];
        left++;
      }
      right++;
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
  //// -------------- end (Approach3)------------------------
}
// @lc code=end
