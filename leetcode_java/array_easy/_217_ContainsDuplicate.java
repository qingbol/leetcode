/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
  public boolean containsDuplicate(int[] nums) {
    Map<Integer,Integer> map = new HashMap<>();
      for (int num : nums) {
          if (map.containsKey(num)) {
            return true;
          } else {
            map.put(num, 1);
          }
      }
      return false;
    }
}
