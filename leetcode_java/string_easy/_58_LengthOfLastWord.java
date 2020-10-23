/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200213)//////////////////////////
  //////////////////////// first round(20200213)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200213
  public int lengthOfLastWord1(String s) {
    String[] str = s.split("\\s");
    if (str.length > 0) {
      return str[str.length - 1].length();
    } else {
      return 0;
    }
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // optimal
  public int lengthOfLastWord(String s) {
    return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
  }
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201020
  //// ---------- end (Approach3)------------------------------------
}
// @lc code=end
