/*
 * @lc app=leetcode id=365 lang=java
 *
 * [365] Water and Jug Problem
 */

// @lc code=start
class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y < z) {
      return false;
    }
    if (x == z || y == z || x + y == z) {
      return true;
    }

    return 0 == z % gcd(x, y);
  }

  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
  HashMap
}
// @lc code=end
