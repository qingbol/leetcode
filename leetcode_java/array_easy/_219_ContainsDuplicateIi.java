/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200113

  // public boolean containsNearbyDuplicate(int[] nums, int k) {
  public boolean containsNearbyDuplicate1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int pivot = nums[i];
      if (map.containsKey(nums[i])) {
        if (Math.abs(i - map.get(nums[i])) <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    return false;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200911, by myself

  // 23/23 cases passed (11 ms)
  // Your runtime beats 37.17 % of java submissions
  // Your memory usage beats 68.94 % of java submissions (44.5 MB)

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    // public boolean containsNearbyDuplicate2(int[] nums, int k) {
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      } else {
        map.putIfAbsent(nums[i], i);
        map.put(nums[i], i);
      }
    }
    return false;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
