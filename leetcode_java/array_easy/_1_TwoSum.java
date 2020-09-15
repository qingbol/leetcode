/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200112)///////////////////////////////////
  ////////////////// first round(20200112)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200112
  //optimal

  // public int[] twoSum(int[] nums, int target) {
  public int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] {map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200803)///////////////////////////////////
  ////////////////// second round(20200803)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200803, by myself.
  // wrong, sort() will change the index.

  // public int[] twoSum(int[] nums, int target) {
  public int[] twoSum2(int[] nums, int target) {
    Arrays.sort(nums);
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      // int mid = lo + (hi - lo) / 2;
      int locSum = nums[lo] + nums[hi];
      if (locSum == target) {
        return new int[] {lo, hi};
      } else if (locSum > target) {
        hi--;
      } else if (locSum < target) {
        lo++;
      }
    }
    return new int[] {};
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // 20200803.

  public int[] twoSum(int[] nums, int target) {
    // public int[] twoSum3(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    // System.out.format("map: %s\n", map);
    for (int i = 0; i < nums.length; i++) {
      int k = target - nums[i];
      // System.out.format("k: %d\n", k);
      if (map.containsKey(k) && map.get(k) != i) {
        return new int[] {i, map.get(k)};
      }
    }
    return new int[] {};
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
