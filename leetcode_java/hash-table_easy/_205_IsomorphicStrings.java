/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200115)///////////////////////////////////
  ////////////////// first round(20200115)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200115
  // cant come up with this approach by myself.

  public boolean isIsomorphic1(String s, String t) {
    // public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        s = s.substring(0, i) + map.get(s.charAt(i)) + s.substring(i + 1);
        if (!s.substring(0, i + 1).equals(t.substring(0, i + 1))) {
          return false;
        }
      } else if (!map.containsValue(t.charAt(i))) {
        map.put(s.charAt(i), t.charAt(i));
        s = s.substring(0, i) + map.get(s.charAt(i)) + s.substring(i + 1);
      } else {
        return false;
      }
      // System.out.format("s: %c, t: %c, map:%s, s: %s\n", s.charAt(i), t.charAt(i),
      // map, s);
    }
    return true;
  }

  //// --------------------------- end (Approach1)-----------------------
  //// ---------------------------start(Approach2)-----------------------
  //
  public boolean isIsomorphic2(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        // s = s.substring(0, i) + map.get(s.charAt(i)) + s.substring(i + 1);
        // if (!s.substring(0, i + 1).equals(t.substring(0, i + 1))) {
        if (map.get(s.charAt(i)) != t.charAt(i)) {
          return false;
        }
      } else {
        if (!map.containsValue(t.charAt(i))) {
          map.put(s.charAt(i), t.charAt(i));
        } else {
          return false;
        }
      }
      // System.out.format("s: %c, t: %c, map:%s, s: %s\n", s.charAt(i), t.charAt(i),
      // map, s);
    }
    return true;
  }
  //// --------------------------- end (Approach2)-----------------------
  //// ---------------------------start(Approach3)-----------------------

  // public boolean isIsomorphic(String s, String t) {
  public boolean isIsomorphic3(String s, String t) {
    int[] countS = new int[256];
    int[] countT = new int[256];
    for (int i = 0; i < s.length(); i++) {
      if (countS[s.charAt(i)] != countT[t.charAt(i)]) {
        return false;
      } else {
        // System.out.format("s.i: %c, t.i: %c\n", s.charAt(i), t.charAt(i));
        countS[s.charAt(i)] = countT[t.charAt(i)] = t.charAt(i);
      }
    }
    return true;
  }
  //// --------------------------- end (Approach3)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach4)-----------------------
  // 20200908
  // cant come up with a solution by myself.
  // refer to My 6 lines solution
  // https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution

  // the idea is similar to union find.

  // 32/32 cases passed (4 ms)
  // Your runtime beats 92.46 % of java submissions
  // Your memory usage beats 66.41 % of java submissions (39.7 MB)

  // public boolean isIsomorphic4(String s, String t) {
  public boolean isIsomorphic(String s, String t) {
    int[] mapS = new int[256];
    int[] mapT = new int[256];
    for (int i = 0; i < s.length(); i++) {
      if (mapS[s.charAt(i)] != mapT[t.charAt(i)])
        return false;
      mapS[s.charAt(i)] = i + 1;
      mapT[t.charAt(i)] = i + 1;
    }
    return true;
  }
  //// --------------------------- end (Approach4)-----------------------
}
// @lc code=end
