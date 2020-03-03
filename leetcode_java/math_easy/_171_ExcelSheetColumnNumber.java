/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
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
}
// @lc code=end
