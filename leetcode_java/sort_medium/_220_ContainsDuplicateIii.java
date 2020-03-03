/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
    for (int i = 0; i < nums.length; i++) {
      int lo = Math.max(0, i - k);
      int hi = Math.min(nums.length, i + k);
      long tmp = (long) nums[i];
      for (int j = lo; j < i; j++) {
        if (i == j)
          continue;
        if (Math.abs(tmp - nums[j]) <= t) {
          return true;
        }
      }
    }
    return false;
  }

  //
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
      long bucket = remappedNum / ((long) t + 1);
      // System.out.format("%d", bucket);
      if (map.containsKey(bucket) || map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t
          || map.containsKey(bucket + 1) && (map.get(bucket + 1) - remappedNum) <= t) {
        return true;
      }
      if (map.size() >= k) {
        long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
        map.remove(lastBucket);
      }
      map.put(bucket, remappedNum);
    }
    return false;
  }
}
// @lc code=end
