/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200105)///////////////////////////////////
  ////////////////// first round(20200105)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200105

  // public int addDigits(int num) {
  public int addDigits1(int num) {
    int res;
    int round = 0;
    while (num > 9) {
      round++;
      res = num;
      int sum = 0;
      while (res > 0) {
        sum += res % 10;
        res /= 10;
      }
      num = sum;
      System.out.format("round: %d || num: %d\n", round, num);
    }
    return num;
  }
  //// ---------------- end (Approach1)-------------------------------------

  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200906

  // 1101/1101 cases passed (1 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 14.32 % of java submissions (37.2 MB)

  public int addDigits(int num) {
    // public int addDigits2(int num) {
    while (num > 9) {
      int sum = 0;
      while (num > 0) {
        // while (num != 0) {
        sum += num % 10;
        num /= 10;
      }
      num = sum;
    }
    return num;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
