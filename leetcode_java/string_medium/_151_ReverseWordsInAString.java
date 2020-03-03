/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
  public String reverseWords(String s) {
    String[] str = s.trim().split("\\s+");
    // System.out.format("str: %s\n", Arrays.toString(str));
    int l = 0;
    int r = str.length - 1;
    while (l < r) {
      String tmp = str[l];
      str[l++] = str[r];
      str[r--] = tmp;
    }
    // System.out.format("str: %s\n", Arrays.toString(str));
    StringBuilder sb = new StringBuilder();
    for (String ss : str) {
      sb.append(ss).append(" ");
    }
    return sb.toString().trim();
  }
}
// @lc code=end
