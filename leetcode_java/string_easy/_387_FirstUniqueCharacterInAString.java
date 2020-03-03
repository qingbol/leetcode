/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
  public int firstUniqChar(String s) {
    if (null == s || 0 == s.length()) {
      return -1;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      max = Math.max(max, s.charAt(i) - 'a');
    }

    int[] count = new int[max + 1];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i < s.length(); i++) {
      if (1 == count[s.charAt(i) - 'a']) {
        return i;
      }
    }
    return -1;
  }
}
// @lc code=end
