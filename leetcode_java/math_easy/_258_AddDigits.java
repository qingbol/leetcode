/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
  public int addDigits(int num) {
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
}
// @lc code=end
