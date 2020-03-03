/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
  public int reverse(int x) {
    long res = 0;
    while (x != 0) {
      res = res * 10 + x % 10;
      x = x / 10;
    }
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
      res = 0;
    }
    return (int) res;
  }
}
// @lc code=end
