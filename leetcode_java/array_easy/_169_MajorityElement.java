/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
  public int majorityElement1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int key : map.keySet()) {
      if (map.get(key) > nums.length / 2) {
        return key;
      }
    }
    return -1;
  }

  public int majorityElement(int[] nums) {
    int count = 0;
    int res = 0;
    for (int num : nums) {
      if (0 == count) {
        res = num;
      }
      if (res != num) {
        count--;
      } else {
        count++;
      }
    }

    return res;
  }
}
// @lc code=end
