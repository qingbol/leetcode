package easy;
/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200102)///////////////////////////////////
  ////////////////// first round(20200102)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  //20200102

  // public char findTheDifference(String s, String t) {
  public char findTheDifference1(String s, String t) {
    int strLen = t.length();
    char target = t.charAt(strLen - 1);

    for (int i = 0; i < s.length(); i++) {
      target ^= s.charAt(i);
      target ^= t.charAt(i);
    }
    return target;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200904)///////////////////////////////////
  ////////////////// second round(20200904)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  //20200904

  public char findTheDifference(String s, String t) {
  // public char findTheDifference2(String s, String t) {
    int l = s.length();
    char res = t.charAt(l);

    for (int i = 0;  i < l; i++) {
      res ^= s.charAt(i);
      res ^= t.charAt(i);
    }

    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
