/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200213)//////////////////////////
  //////////////////////// first round(20200213)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200213

  // public String longestCommonPrefix(String[] strs) {
  public String longestCommonPrefix1(String[] strs) {
    if (null == strs || 0 == strs.length) {
      return "";
    }
    // int minLen = Integer.MAX_VALUE;
    // for (int i = 0; i < strs.length; i++) {
    // minLen = Math.min(minLen, strs[i].length());
    // }
    // StringBuilder sb = new StringBuilder();

    for (int i = 0; i < strs[0].length(); i++) {
      boolean flag = true;
      // Set<Character> set = new HashSet<>();
      char tmp = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        // set.add(strs[j].charAt(i));
        // if (set.size() > 1) {
        if (i == strs[j].length() || strs[j].charAt(i) != tmp) {
          // if (strs[j].charAt(i) != tmp) {
          // System.out.format("size: %d\n", set.size());
          return strs[0].substring(0, i);
          // flag = false;
          // break;
        }
      }
      // if (flag == true) {
      // sb.append(strs[0].charAt(i));
      // } else {
      // break;
      // }
    }
    // return sb.length() == 0 ? "" : sb.toString();
    return strs[0];
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201019)//////////////////////////
  //////////////////////// second round(20201019)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201019
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
