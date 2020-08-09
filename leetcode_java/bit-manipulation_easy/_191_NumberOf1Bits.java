package easy;
/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

public class _191_NumberOf1Bits {
  Solution solution = new Solution();
}


// @lc code=start
class Solution {
  ////////////////// first round(20200103)///////////////////////////////////
  ////////////////// first round(20200103)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200103
  // you need to treat n as an unsigned value

  // public int hammingWeight(int n) {
  public int hammingWeight1(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= n - 1;
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------

  public int hammingWeight2(int n) {
    int res = 0;
    while (n > 0) {
      res += n & 1;
      n >>>= 1;
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200803)///////////////////////////////////
  ////////////////// second round(20200803)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200103

  // 601/601 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 18.84 % of java submissions (36.6 MB)

  public int hammingWeight(int n) {
    // public int hammingWeight3(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= n - 1;
    }
    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
