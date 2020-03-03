/*
 * @lc app=leetcode id=294 lang=java
 *
 * [294] Flip Game II
 */

// @lc code=start
class Solution {
  public boolean canWin(String s) {
    if (null == s || s.length() < 2) {
      return false;
    }
    Map<String, Boolean> map = new HashMap<>();
    return canWinHelper(s, map);
  }

  private boolean canWinHelper(String s, Map<String, Boolean> map) {
    if (map.containsKey(s)) {
      return map.get(s);
    }
    int idx = -1;
    while ((idx = s.indexOf("++", idx + 1)) != -1) {
      String t = s.substring(0, idx) + "--" + s.substring(idx + 2);
      if (!canWinHelper(t, map)) {
        map.put(s, true);
        return true;
      }
    }
    map.put(s, false);
    return false;
  }
}
// @lc code=end
