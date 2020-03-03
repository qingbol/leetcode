/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
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

  // optimal solution
  public int minSubArrayLen(int s, int[] nums) {
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
}
// @lc code=end
