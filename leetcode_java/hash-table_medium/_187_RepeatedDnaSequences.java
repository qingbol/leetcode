/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200221)/////////////////////////////
  /////////////////////// first round(20200221)/////////////////////////////
  //// :--------------------start(approach 1)------------------------------
  // 20200221, 
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length() - 9; i++) {
      String ss = s.substring(i, i + 10);
      map.put(ss, map.getOrDefault(ss, 0) + 1);
    }
    // System.out.format("map: %s\n", map);
    for (String str : map.keySet()) {
      if (map.get(str) >= 2) {
        res.add(str);
      }
    }
    return res;
  }
  //// ---------------------- end (Approach1)------------------------
  ////////////////// second round(20201110)////////////////////////////////////
  ////////////////// second round(20201110)////////////////////////////////////
  //// ----------------------start(Approach 2)-----------------------------
  // 20201110.
  //// ---------------------- end (Approach 2)-----------------------------
}
// @lc code=end
