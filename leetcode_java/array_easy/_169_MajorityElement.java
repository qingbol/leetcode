/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200111

  public int majorityElement1(int[] nums) {
    // public int majorityElement(int[] nums) {
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // Approach 6: Boyer-Moore Voting Algorithm

  // public int majorityElement(int[] nums) {
  public int majorityElement2(int[] nums) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200911, can't come up a solution with O(n) & O(1).
  // refer to : Approach 6: Boyer-Moore Voting Algorithm

  // 46/46 cases passed (1 ms)
  // Your runtime beats 99.93 % of java submissions
  // Your memory usage beats 97.33 % of java submissions (42.4 MB)

  // public int majorityElement2(int[] nums) {
  public int majorityElement(int[] nums) {
    int n = nums.length;
    // 1. initialization
    int count = 1;
    int candidate = nums[0];
    for (int i = 1; i < n; i++) {
      if (count == 0) {
        candidate = nums[i];
      }
      count += nums[i] == candidate ? 1 : -1;
    }
    return candidate;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
