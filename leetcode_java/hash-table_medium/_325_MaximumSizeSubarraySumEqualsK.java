/*
 * @lc app=leetcode id=325 lang=java
 *
 * [325] Maximum Size Subarray Sum Equals k
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200112)///////////////////////////////////
  ////////////////// first round(20200112)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200112.
  // public int maxSubArrayLen(int[] nums, int k) {
  public int maxSubArrayLen1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }

    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i] - k)) {
        res = Math.max(res, i - map.get(nums[i] - k));
      }
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], i);
      }
    }
    return res;
  }
  //// -------------- end (Approach1)------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  //// --------------start(Approach2)------------------------
  // 20200909. part by myself.

//   35/35 cases passed (8 ms)
// Your runtime beats 98.97 % of java submissions
// Your memory usage beats 85.01 % of java submissions (40.5 MB)

  public int maxSubArrayLen(int[] nums, int k) {
    // public int maxSubArrayLen2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    // 1. accumulate the sum
    for (int i = 1; i < n; i++) {
      nums[i] += nums[i - 1];
    }
    // 2. use map to get res
    int res = 0;
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i] - k)) {
        res = Math.max(res, i - map.get(nums[i] - k));
      }
      if (!map.containsKey(nums[i]))
        map.put(nums[i], i);
    }
    return res;
  }
  //// -------------- end (Approach2)------------------------
}
// @lc code=end
