/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.substring(i, i + needle.length()).equals(needle)) {
        return i;
      }
    }
    return -1;
  }
}
// @lc code=end
