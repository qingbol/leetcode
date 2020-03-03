/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
  public String convert(String s, int numRows) {
    if (1 == numRows) {
      return s;
    }
    List<StringBuilder> lst = new ArrayList<>();
    for (int i = 0; i < Math.min(s.length(), numRows); i++) {
      lst.add(new StringBuilder());
    }
    // System.out.format("lst: %s\n", lst);
    int row = 0;
    boolean goDown = false;
    for (char ch : s.toCharArray()) {
      lst.get(row).append(ch);
      if (row == 0) {
        goDown = true;
      } else if (row == numRows - 1) {
        goDown = false;
      }
      row += goDown ? 1 : -1;
    }

    StringBuilder res = new StringBuilder();
    for (StringBuilder sb : lst) {
      res.append(sb);
    }
    return res.toString();
  }
}
// @lc code=end
