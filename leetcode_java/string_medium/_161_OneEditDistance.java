/*
 * @lc app=leetcode id=161 lang=java
 *
 * [161] One Edit Distance
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200213)//////////////////////////
  //////////////////////// first round(20200213)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200213
  public boolean isOneEditDistance1(String s, String t) {
    if (s.length() > t.length()) {
      String tmp = "";
      tmp = s;
      s = t;
      t = tmp;
    }
    int cnt = 0;
    if (s.length() == t.length()) {
      // if (s.length() == 0)
      // return false;
      for (int i = 0; i < s.length(); i++) {
        // System.out.format("i: %c, j: %c\n", s.charAt(i), t.charAt(i));
        if (s.charAt(i) != t.charAt(i)) {
          cnt++;
        }
      }
      if (cnt != 1) {
        return false;
      }
    } else if (s.length() + 1 == t.length()) {
      int i = 0;
      int j = 0;
      if (s.length() == 0 && t.length() == 1) {
        return true;
      }
      while (i < s.length() && j < t.length()) {
        // System.out.format("i: %c, j: %c\n", s.charAt(i), t.charAt(j));
        if (s.charAt(i) != t.charAt(j)) {
          cnt++;
          i--;
        }
        i++;
        j++;
      }
      if (cnt > 1 || j < t.length() && cnt > 0) {
        return false;
      }
    } else {
      return false;
    }
    return true;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // better
  public boolean isOneEditDistance(String s, String t) {
    if (null == s || null == t) {
      return false;
    }
    if (s.length() > t.length()) {
      return isOneEditDistance(t, s);
    }

    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) != t.charAt(j)) {
        return s.substring(i + 1).equals(t.substring(j + 1)) || s.substring(i).equals(t.substring(j + 1));
      }
      i++;
      j++;
    }

    return t.length() - 1 == j;
  }
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201020
  //// ---------- end (Approach3)------------------------------------
}
// @lc code=end
