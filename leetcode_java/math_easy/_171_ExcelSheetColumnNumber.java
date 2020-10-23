/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200213)//////////////////////////
  //////////////////////// first round(20200213)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200213
  public int titleToNumber(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    int res = 0;
    for (char ch : s.toUpperCase().toCharArray()) {
      res = res * 26 + (ch - 'A' + 1);
    }
    return res;
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201020
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
