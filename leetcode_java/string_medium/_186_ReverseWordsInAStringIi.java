/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200215)//////////////////////////
  //////////////////////// first round(20200215)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200215
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
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201020
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
