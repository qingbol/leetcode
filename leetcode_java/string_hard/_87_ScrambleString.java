/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200114)///////////////////////////////////
  ////////////////// first round(20200114)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200114

  // public boolean isScramble(String s1, String s2) {
  public boolean isScramble1(String s1, String s2) {
    if (s1.equals(s2)) {
      return true;
    }
    int[] letters = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      letters[s1.charAt(i) - 'a']++;
      letters[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (letters[i] != 0) {
        return false;
      }
    }
    int len = s1.length();
    for (int i = 1; i < s1.length(); i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i))
          && isScramble(s1.substring(i), s2.substring(i)))
        return true;
      if (isScramble(s1.substring(0, i), s2.substring(len - i))
          && isScramble(s1.substring(i), s2.substring(0, len - i)))
        return true;
    }
    return false;
  }
  //// --------------------------- end (Approach1)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach2)-----------------------
  // 20200908
  // cant come up with a solution by myself.
  // https://leetcode.com/problems/scramble-string/discuss/29392/Share-my-4ms-c%2B%2B-recursive-solution

  // 285/285 cases passed (2 ms)
  // Your runtime beats 97.78 % of java submissions
  // Your memory usage beats 98.97 % of java submissions (39.1 MB)

  public boolean isScramble(String s1, String s2) {
    // public boolean isScramble2(String s1, String s2) {
    if (s1.equals(s2)) {
      return true;
    }
    int[] count = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0)
        return false;
    }

    int l = s1.length();
    for (int i = 1; i < l; i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i))
          && isScramble(s1.substring(i), s2.substring(i)))
        return true;
      if (isScramble(s1.substring(0, i), s2.substring(l - i))
          && isScramble(s1.substring(i), s2.substring(0, l - i)))
        return true;
    }
    return false;
  }
  //// --------------------------- end (Approach2)-----------------------
}
// @lc code=end
