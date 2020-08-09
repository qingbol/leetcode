package easy;
/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200103)///////////////////////////////////
  ////////////////// first round(20200103)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200103

  // public boolean isPowerOfTwo(int n) {
  public boolean isPowerOfTwo1(int n) {
    return (n > 0) && ((n & (n - 1)) == 0);
  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------

  public boolean isPowerOfTwo2(int n) {
    if (1 == n) {
      return true;
    }
    int flag = 0;
    while (n > 1 && 0 == flag) {
      flag = n % 2;
      n /= 2;
    }
    return 1 == flag ? false : true;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200803)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200803

  // Wrong Answer
  // 1106/1108 cases passed (N/A)
  // Testcase
  // 0

  // public boolean isPowerOfTwo(int n) {
  public boolean isPowerOfTwo3(int n) {
    return (n & n - 1) == 0;
  }
  //// ---------------- end (Approach3)-------------------------------------
  //// ----------------start(Approach4)-------------------------------------
  // 20200803

  // 1108/1108 cases passed (1 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 28.31 % of java submissions (36.8 MB)

  public boolean isPowerOfTwo(int n) {
    // public boolean isPowerOfTwo4(int n) {
    return n > 0 && (n & n - 1) == 0;
  }
  //// ---------------- end (Approach4)-------------------------------------
}
// @lc code=end
