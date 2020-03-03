/*
 * @lc app=leetcode id=293 lang=java
 *
 * [293] Flip Game
 */

// @lc code=start
class Solution {
  public List<String> generatePossibleNextMoves1(String s) {
    List<String> lst = new ArrayList<>();
    int idx = s.indexOf("++");
    int left = idx;
    while (idx != -1) {
      String t = s.substring(0, left) + s.substring(left).replaceFirst("\\+\\+", "--");
      lst.add(t);
      idx = s.substring(left + 1).indexOf("++");
      left = left + 1 + idx;
      // System.out.format("idx: %d s: %s\n", idx, s);
    }
    return lst;
    // return lst.isEmpty() ? null : lst;
    // return lst.isEmpty() ? Arrays.asList("") : lst;
  }

  // better
  public List<String> generatePossibleNextMoves(String s) {
    List<String> lst = new ArrayList<>();
    int idx = -1;
    while ((idx = s.indexOf("++", idx + 1)) != -1) {
      lst.add(s.substring(0, idx) + "--" + s.substring(idx + 2));
    }
    return lst;
  }
}
// @lc code=end
