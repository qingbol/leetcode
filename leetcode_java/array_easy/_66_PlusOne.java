/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200104)///////////////////////////////////
  ////////////////// first round(20200104)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200104

  // public int[] plusOne(int[] digits) {
  public int[] plusOne1(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }

    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200905)///////////////////////////////////
  ////////////////// second round(20200905)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200905
  // refer to standard solution

  // 109/109 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 96.94 % of java submissions (37.6 MB)

  public int[] plusOne(int[] digits) {
    // public int[] plusOne2(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }

    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
