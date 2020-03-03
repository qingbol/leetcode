/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
  public int lengthOfLastWord1(String s) {
    String[] str = s.split("\\s");
    if (str.length > 0) {
      return str[str.length - 1].length();
    } else {
      return 0;
    }
  }

  // optimal
  public int lengthOfLastWord(String s) {
    return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
  }
}
// @lc code=end
