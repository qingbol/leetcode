/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
  public boolean isPalindrome(String s) {
    if (null == s || s.length() < 2) {
      return true;
    }
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
        r--;
      }
      char left = s.charAt(l);
      if (Character.isUpperCase(s.charAt(l))) {
        left = Character.toLowerCase(left);
      }
      char right = s.charAt(r);
      if (Character.isUpperCase(s.charAt(r))) {
        right = Character.toLowerCase(right);
      }
      if (left != right) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
// @lc code=end
