/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
  public boolean isScramble(String s1, String s2) {
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
      if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
        return true;
      if (isScramble(s1.substring(0, i), s2.substring(len - i))
          && isScramble(s1.substring(i), s2.substring(0, len - i)))
        return true;
    }
    return false;
  }
}
// @lc code=end
