/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200106)///////////////////////////////////
  ////////////////// first round(20200106)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200106
  // binary search

  public boolean isPerfectSquare1(int num) {
    // public boolean isPerfectSquare(int num) {
    // if (1 == num) {
    // return 1;
    // }
    int low = 1;
    int high = num;
    while (low <= high) {
      long mid = low + (high - low) / 2;
      if (mid * mid > num) {
        high = (int) mid - 1;
      } else if (mid * mid < num) {
        low = (int) mid + 1;
      } else if (mid * mid == num) {
        return true;
      }
    }
    return false;
  }

  //// ---------------- end (Approach1)-------------------------
  //// ----------------start(Approach2)-------------------------
  // newton method

  // public boolean isPerfectSquare(int num) {
  public boolean isPerfectSquare2(int num) {
    long x = num;
    while (x * x > num) {
      x = (x + num / x) / 2;
    }
    if (x * x == num) {
      return true;
    } else {
      return false;
    }
  }
  //// ---------------- end (Approach2)-------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------

  // 70/70 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 94.59 % of java submissions (35.9 MB)

  public boolean isPerfectSquare(int num) {
    // public boolean isPerfectSquare2(int num) {
    if (num == 1)
      return true;
    // int lo = 1, hi = num;
    int lo = 1, hi = num / 2;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      long midSquare = (long) mid * mid;
      if (midSquare == num) {
        return true;
      } else if (midSquare > num) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return false;
  }
  //// ---------------- end (Approach3)-------------------------
}
// @lc code=end
