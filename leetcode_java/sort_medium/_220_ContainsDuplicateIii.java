/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200113
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

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
  public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
      long bucket = remappedNum / ((long) t + 1);
      // System.out.format("%d", bucket);
      if (map.containsKey(bucket)
          || map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200911, can't come up with this approach by myself
  // refer to leetcode: Approach #3 (Buckets) [Accepted]
  // very tricky.

  // 53/53 cases passed (14 ms)
  // Your runtime beats 76.21 % of java submissions
  // Your memory usage beats 19.23 % of java submissions (42.3 MB)

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    // public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
    if (t < 0)
      return false;
    // 1.design buckets
    // detail1: bucket size should be t + 1 instead of t.
    long bucketSize = (long) t + 1;
    // int bucketSize = t + 1;
    var bucket = new HashMap<Long, Long>();
    // 2. distribute
    for (int i = 0; i < nums.length; i++) {
      // long key = getKey1(nums[i], bucketSize);
      long key = getKey2(nums[i], bucketSize);
      if (bucket.containsKey(key))
        return true;
      if (bucket.containsKey(key - 1) && Math.abs(bucket.get(key - 1) - nums[i]) <= t)
        return true;
      if (bucket.containsKey(key + 1) && Math.abs(bucket.get(key + 1) - nums[i]) <= t)
        return true;

      bucket.put(key, (long) nums[i]);

      // remove the obsolete num
      // System.out.format("i: %d, bucket size: %d\n", i, bucket.size());
      if (i >= k) {
        // if (bucket.size() >= k) {
        // key = getKey1(nums[i - k], bucketSize);
        key = getKey2(nums[i - k], bucketSize);
        bucket.remove(key);
      }
    }
    return false;
  }

  private long getKey1(long num, long bucketSize) {
    return ((long) num - Integer.MIN_VALUE) / bucketSize;
  }

  private long getKey2(long num, long bucketSize) {
    return num < 0 ? (num + 1) / bucketSize - 1 : num / bucketSize;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
