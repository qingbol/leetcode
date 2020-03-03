/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
  public boolean isSubsequence(String s, String t) {
    if (null == s || s.length() == 0) {
      return true;
    }
    if (s.length() > t.length()) {
      return false;
    }
    int j = 0;
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == s.charAt(j)) {
        j++;
      }
      if (j == s.length()) {
        return true;
      }
    }
    return false;
  }

  // optimal
  public boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

}
// @lc code=end
