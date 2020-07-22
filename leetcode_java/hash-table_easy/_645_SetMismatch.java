/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)-----------------------------
  // 20200720, by myself. Using HashMap
  // 49/49 cases passed (23 ms)
  // Your runtime beats 13.43 % of java submissions
  // Your memory usage beats 12.01 % of java submissions (41.9 MB)

  // public int[] findErrorNums(int[] nums) {
  public int[] findErrorNums1(int[] nums) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(i + 1, 0);
    }

    for (int num : nums) {
      map.put(num, map.get(num) + 1);
    }

    for (int i = 0; i < nums.length; i++) {
      if (map.get(i + 1) == 2) {
        res[0] = i + 1;
      } else if (map.get(i + 1) == 0) {
        res[1] = i + 1;
      }
    }

    return res;
  }
  //// ---------------- end (Approach1)-----------------------------
  //// ----------------start(Approach2)-----------------------------
  // 20200720.
  // refer to labuladong < 如何同时寻找缺失和重复的元素>
  // and refer to leetcode standard solution: Approach 6: Using Constant Space

  // 49/49 cases passed (2 ms)
  // Your runtime beats 89.83 % of java submissions
  // Your memory usage beats 75.14 % of java submissions (40.8 MB)

  public int[] findErrorNums(int[] nums) {
    // public int[] findErrorNums2(int[] nums) {
    int dup = -1, miss = -1;

    for (int num : nums) {
      if (nums[Math.abs(num) - 1] < 0) {
        dup = Math.abs(num);
      } else {
        nums[Math.abs(num) - 1] *= -1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        miss = i + 1;
      }
    }

    return new int[] { dup, miss };
  }
  //// ---------------- end (Approach2)-----------------------------
}
// @lc code=end
