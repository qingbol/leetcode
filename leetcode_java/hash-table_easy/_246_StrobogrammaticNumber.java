/*
 * @lc app=leetcode id=246 lang=java
 *
 * [246] Strobogrammatic Number
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200215)//////////////////////////
  //////////////////////// first round(20200215)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200215
  // By myself
  public boolean isStrobogrammatic1(String num) {
    if (null == num || num.length() < 1) {
      return true;
    }
    Map<Character, Character> map = new HashMap<>();
    map.put('1', '1');
    map.put('0', '0');
    map.put('8', '8');
    map.put('6', '9');
    map.put('9', '6');
    // num = num.replaceAll("6", "9");
    int l = 0;
    int r = num.length() - 1;
    while (l < r) {
      if (map.containsKey(num.charAt(l)) && map.get(num.charAt(l)) == num.charAt(r)) {
        l++;
        r--;
      } else {
        return false;
      }
    }
    if (l == r) {
      char ch = num.charAt(l);
      // System.out.format("ch: %c\n", ch);
      if (ch == '0' || ch == '1' || ch == '8') {
        return true;
      } else {
        return false;
      }
    }
    return true;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // optimal approach
  public boolean isStrobogrammatic(String num) {
    for (int i = 0, j = num.length() - 1; i <= j; i++, j--)
      if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
        return false;
    return true;
  }
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201021)//////////////////////////
  //////////////////////// second round(20201021)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201021. 
  //// ---------- end (Approach3)------------------------------------

}
// @lc code=end
