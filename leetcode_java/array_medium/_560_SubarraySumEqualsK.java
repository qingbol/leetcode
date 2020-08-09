/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200805)///////////////////////////////////
  ////////////////// first round(20200805)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200805, sliding window. totally by myself

  // Wrong Answer
  // 30/81 cases passed (N/A)
  // Testcase
  // [-1,-1,1]
  // 0

  // public int subarraySum(int[] nums, int k) {
  public int subarraySum1(int[] nums, int k) {
    int left = 0, right = 0;
    int sum = 0;
    int res = 0;
    while (right < nums.length) {
      int r = nums[right];
      right++;
      sum += r;

      while (sum >= k && left < nums.length) {
        if (sum == k) {
          res++;
        }
        int l = nums[left];
        left++;
        sum -= l;
      }
    }

    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // 20200805, by myself, prefix sum
  // 81/81 cases passed (773 ms)
  // Your runtime beats 5.02 % of java submissions
  // Your memory usage beats 82.07 % of java submissions (40.1 MB)

  // public int subarraySum(int[] nums, int k) {
  public int subarraySum2(int[] nums, int k) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] + nums[i];
    }

    int sum = 0;
    int res = 0;
    for (int lo = 0; lo < nums.length; lo++) {
      for (int hi = lo; hi < nums.length; hi++) {
        sum = lo == 0 ? nums[hi] : nums[hi] - nums[lo - 1];
        if (sum == k)
          res++;
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // 20200805, prefix sum
  // refer to labuladong <前缀和技巧>

  // public int subarraySum(int[] nums, int k) {
  public int subarraySum3(int[] nums, int k) {
    int[] preSum = new int[nums.length + 1];
    preSum[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    }

    int res = 0;
    for (int hi = 1; hi <= nums.length; hi++) {
      for (int lo = 0; lo < hi; lo++) {
        if (preSum[hi] - preSum[lo] == k)
          res++;
      }
    }
    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------
  //// ----------------start(Approach4)-------------------------------------
  // 20200805, prefix sum + hashMap, by myself
  // refer to labuladong <前缀和技巧>

  // Wrong Answer
  // 55/81 cases passed (N/A)
  // Testcase
  // [-1,-1,1]
  // 0

  // reason: preSum[hi] - preSum[lo] == k has a prerequisite: hi > lo

  // public int subarraySum(int[] nums, int k) {
  public int subarraySum4(int[] nums, int k) {
    int[] preSum = new int[nums.length + 1];
    Map<Integer, Integer> map = new HashMap<>();
    preSum[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
      int key = preSum[i + 1] - k;
      map.putIfAbsent(key, 0);
      map.put(key, map.get(key) + 1);
    }

    System.out.format("map: %s\n", map);
    int res = 0;
    for (int lo = 0; lo < nums.length; lo++) {
      if (map.containsKey(preSum[lo]))
        res += map.get(preSum[lo]);
    }
    return res;
  }
  //// ---------------- end (Approach4)-------------------------------------
  //// ----------------start(Approach5)-------------------------------------
  // 20200805, prefix sum + hashMap,
  // refer to labuladong <前缀和技巧>

  // preSum[i] = sum(nums[0...i-1])
  // preSum[i + 1] - preSum[j] = sum(nums[j...i])

  public int subarraySum(int[] nums, int k) {
    // public int subarraySum5(int[] nums, int k) {
    int[] preSum = new int[nums.length + 1];
    Map<Integer, Integer> map = new HashMap<>();
    // base case
    preSum[0] = 0;
    map.put(0, 1);

    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
      int diff = preSum[i + 1] - k;
      if (map.containsKey(diff)) {
        res += map.get(diff);
      }

      // add the current preSum to map
      map.putIfAbsent(preSum[i + 1], 0);
      map.put(preSum[i + 1], map.get(preSum[i + 1]) + 1);
    }

    return res;
  }
  //// ---------------- end (Approach5)-------------------------------------
}
// @lc code=end

