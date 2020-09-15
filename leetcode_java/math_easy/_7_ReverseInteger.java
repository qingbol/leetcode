/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200104)///////////////////////////////////
  ////////////////// first round(20200104)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200104

  // public int reverse(int x) {
  public int reverse1(int x) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200904)///////////////////////////////////
  ////////////////// second round(20200904)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200104
  // first we need to remove the last digit every iteration.
  // second append this digit to the result.
  // another trick is how to avoid overflow

  // 1032/1032 cases passed (1 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 65.57 % of java submissions (36.9 MB)

  public int reverse(int x) {
    // public int reverse2(int x) {
    long res = 0;
    while (x != 0) {
      res = res * 10 + x % 10;
      x /= 10;
    }
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
