/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200113

  // public boolean containsDuplicate(int[] nums) {
  public boolean containsDuplicate1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        return true;
      } else {
        map.put(num, 1);
      }
    }
    return false;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200911,

  // 18/18 cases passed (6 ms)
  // Your runtime beats 65.43 % of java submissions
  // Your memory usage beats 62.53 % of java submissions (45.5 MB)

  // public boolean containsDuplicate(int[] nums) {
  public boolean containsDuplicate2(int[] nums) {
    var map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        return true;
      } else {
        map.put(num, 1);
      }
    }
    return false;
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // 20200911,

  // 18/18 cases passed (4 ms)
  // Your runtime beats 87.18 % of java submissions
  // Your memory usage beats 95.32 % of java submissions (43.2 MB)

  public boolean containsDuplicate(int[] nums) {
    // public boolean containsDuplicate2(int[] nums) {
    var set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
