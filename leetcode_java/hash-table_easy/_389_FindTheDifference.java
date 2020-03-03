package easy;
/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
  public char findTheDifference(String s, String t) {
    int strLen = t.length();
    char target = t.charAt(strLen - 1);

    for (int i = 0; i < s.length(); i++) {
      target ^= s.charAt(i);
      target ^= t.charAt(i);
    }
    return target;
  }
}
// @lc code=end
