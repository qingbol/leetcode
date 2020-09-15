/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200112)///////////////////////////////////
  ////////////////// first round(20200112)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200112.

  public int maxSubArray1(int[] nums) {
    int res = maxSub(nums, 0, nums.length - 1);
    return res;
  }

  private int maxSub(int[] arr, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;

      int res = Math.max(0, maxSub(arr, start, mid - 1)) + arr[mid]
          + Math.max(0, maxSub(arr, mid + 1, end));
      System.out.format("strat: %d, end: %d, res: %d\n", start, end, res);
      return res;
    }
    return 0;
  }

  //// -------------- end (Approach1)------------------------
  //// --------------start(Approach2)------------------------
  // 20200112

  // public int maxSubArray(int[] nums) {
  public int maxSubArray2(int[] nums) {
    int[] sum = new int[nums.length];
    sum[0] = nums[0];
    int res = sum[0];
    for (int i = 1; i < nums.length; i++) {
      sum[i] = Math.max(0, sum[i - 1]) + nums[i];
      res = Math.max(res, sum[i]);
    }
    return res;
  }

  //// -------------- end (Approach1)------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  //// --------------start(Approach3)------------------------
  // 20200909.
  // refer to :Approach 3: Dynamic Programming (Kadane's algorithm)

  // 202/202 cases passed (1 ms)
  // Your runtime beats 75.65 % of java submissions
  // Your memory usage beats 87.39 % of java submissions (39.3 MB)

  // public int maxSubArray3(int[] nums) {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int maxSum = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] > 0)
        nums[i] += nums[i - 1];
      maxSum = Math.max(maxSum, nums[i]);
    }
    return maxSum;
  }
  //// -------------- end (Approach3)------------------------

}
// @lc code=end
