/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200107)///////////////////////////////////
  ////////////////// first round(20200107)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200107

  // public boolean isUgly(int num) {
  public boolean isUgly1(int num) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200906

  public boolean isUgly(int num) {
    // public boolean isUgly2(int num) {
    if (num == 0)
      return false;
    if (num == 1)
      return true;

    while (num % 2 == 0) {
      num /= 2;
    }
    while (num % 3 == 0) {
      num /= 3;
    }
    while (num % 5 == 0) {
      num /= 5;
    }

    return num == 1;
  }
  //// ---------------- end (Approach2)-------------------------------------

}
// @lc code=end
