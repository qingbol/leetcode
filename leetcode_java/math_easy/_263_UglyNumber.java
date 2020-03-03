/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
  public boolean isUgly(int num) {
    if (0 == num) {
      return false;
    }
    if (1 == num) {
      return true;
    }
    while (0 == num % 2) {
      num /= 2;
    }
    while (0 == num % 3) {
      num /= 3;
    }
    while (0 == num % 5) {
      num /= 5;
    }
    return 1 == num;
  }
}
// @lc code=end
