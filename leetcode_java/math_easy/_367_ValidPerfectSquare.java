/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
  // binary search
  public boolean isPerfectSquare1(int num) {
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

  // newton method
  public boolean isPerfectSquare(int num) {
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
}
// @lc code=end
