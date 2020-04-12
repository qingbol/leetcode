/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
  //// --------------start(Approach1)------------------------
  // 20200112.
  public int maxSubArray1(int[] nums) {
    int res = maxSub(nums, 0, nums.length - 1);
    return res;
  }

  private int maxSub(int[] arr, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;

      int res = Math.max(0, maxSub(arr, start, mid - 1)) + arr[mid] + Math.max(0, maxSub(arr, mid + 1, end));
      System.out.format("strat: %d, end: %d, res: %d\n", start, end, res);
      return res;
    }
    return 0;
  }

  //// -------------- end (Approach1)------------------------
  //// --------------start(Approach2)------------------------
  // 20200112
  public int maxSubArray(int[] nums) {
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
  //// --------------start(Approach3)------------------------
  public int maxSubArray(int[] nums) {
  }
  //// -------------- end (Approach3)------------------------

}
// @lc code=end
