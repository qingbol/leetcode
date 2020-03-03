/*
 * @lc app=leetcode id=325 lang=java
 *
 * [325] Maximum Size Subarray Sum Equals k
 */

// @lc code=start
class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
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
}
// @lc code=end
