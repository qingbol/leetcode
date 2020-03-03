/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 */

// @lc code=start
class Solution {
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);
    int left = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == ' ') {
        reverse(s, left, i - 1);
        left = i + 1;
      }
    }
    if (left < s.length - 1) {
      reverse(s, left, s.length - 1);
    }
  }

  private void reverse(char[] s, int l, int r) {
    while (l < r) {
      char tmp = s[l];
      s[l++] = s[r];
      s[r--] = tmp;
    }
  }
}
// @lc code=end
