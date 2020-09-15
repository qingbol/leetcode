/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200110)///////////////////////////////////
  ////////////////// first round(20200110)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200110.

  // public int[] productExceptSelf(int[] nums) {
  public int[] productExceptSelf1(int[] nums) {
    int[] prefixProduct = new int[nums.length];
    prefixProduct[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
    }

    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      prefixProduct[i] *= right;
      right *= nums[i];
    }
    return prefixProduct;
  }
  //// -------------- end (Approach1)------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// --------------start(Approach2)------------------------
  // 20200910.

  // 18/18 cases passed (1 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 76.21 % of java submissions (47.9 MB)

  public int[] productExceptSelf(int[] nums) {
    // public int[] productExceptSelf2(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];
    int[] suffix = new int[n];
    prefix[0] = nums[0];
    suffix[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * nums[i];
    }
    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i];
    }

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        nums[i] = suffix[1];
      } else if (i == n - 1) {
        nums[i] = prefix[n - 2];
      } else {
        nums[i] = prefix[i - 1] * suffix[i + 1];
      }
    }
    return nums;
  }
  //// -------------- end (Approach2)------------------------
}
// @lc code=end
