/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */

// @lc code=start
class Solution {
  //// :---------------start(approach 1)--------------------------------------
  //// :By myself, wrong, some cases cant pass.
  //// eg. "abbacd"
  public String shortestPalindrome1(String s) {
    if (null == s || s.length() < 2 || isValid(s)) {
      return s;
    }
    String res = "";
    int mid = (s.length()) / 2;
    while (mid >= 0) {
      int lo = mid;
      int hi = mid;
      boolean flag = true;
      while (lo >= 0 && hi < s.length()) {
        if (s.charAt(lo) != s.charAt(hi)) {
          flag = false;
          break;
        }
        lo--;
        hi++;
      }
      if (flag == true) {
        res = new StringBuilder(s.substring(hi)).reverse().toString() + s;
        break;
      }
      mid--;
    }
    return res;
  }

  private boolean isValid(String ss) {
    for (int l = 0, r = ss.length() - 1; l < r; l++, r--) {
      if (ss.charAt(l) != ss.charAt(r)) {
        return false;
      }
    }
    return true;
  }

  //// :--------------- end (approach 1)--------------------------------------
  public String shortestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    String res = "";
    int len = s.length();
    int upper = len - 1;
    for (; upper >= 0; upper--) {
      int l = 0;
      int r = upper;
      // System.out.format("upper: %d\n", upper);
      boolean flag = true;
      for (; l < r; l++, r--) {
        // System.out.format("l: %d, r: %d\n", l, r);
        if (s.charAt(l) != s.charAt(r)) {
          flag = false;
          break;
        }
      }

      if (flag == true) {
        res = new StringBuilder(s.substring(upper + 1)).reverse().toString() + s;
        break;
      }
    }
    return res;
  }
  //// :---------------start(approach 2)--------------------------------------
  //// :--------------- end (approach 2)--------------------------------------
  //// :---------------start(approach 3)--------------------------------------
  //// :--------------- end (approach 3)--------------------------------------
  //// :---------------start(approach 4)--------------------------------------
  //// :--------------- end (approach 4)--------------------------------------
}
// @lc code=end
