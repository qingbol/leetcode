/*
 * @lc app=leetcode id=365 lang=java
 *
 * [365] Water and Jug Problem
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200106)///////////////////////////////////
  ////////////////// first round(20200106)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200106
  // public boolean canMeasureWater(int x, int y, int z) {
  public boolean canMeasureWater1(int x, int y, int z) {
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
  //// ---------------- end (Approach1)-------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------
  //2020096
  //cant come up by myself

  public boolean canMeasureWater(int x, int y, int z) {
  // public boolean canMeasureWater2(int x, int y, int z) {
    

  }
  //// ---------------- end (Approach2)-------------------------
}
// @lc code=end
