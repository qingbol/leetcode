/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)----------------------------------
  // 20200218
  public int lengthOfLongestSubstring1(String s) {
    if (null == s || s.length() < 2) {
      return s.length();
    }
    Map<Character, Integer> map = new HashMap<>();
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      map.clear();
      for (int j = i; j < s.length(); j++) {
        if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) > 0) {
          break;
        } else {
          map.put(s.charAt(j), 1);
          res = Math.max(res, j - i + 1);
        }
      }
    }
    return res;
  }

  //// --------------- end (Approach1)----------------------------------
  //// ---------------start(Approach2)----------------------------------
  // optimal solution
  public int lengthOfLongestSubstring(String s) {
    if (null == s || s.length() < 2) {
      return s.length();
    }
    Set<Character> set = new HashSet<>();
    int i = 0;
    int j = 0;
    int res = Integer.MIN_VALUE;
    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        res = Math.max(res, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return res;
  }
  //// --------------- end (Approach2)----------------------------------
}
// @lc code=end
