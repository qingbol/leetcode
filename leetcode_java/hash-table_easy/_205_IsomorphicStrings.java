/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
  public boolean isIsomorphic1(String s, String t) {
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

  public boolean isIsomorphic(String s, String t) {
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
}
// @lc code=end
