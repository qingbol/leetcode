import java.util.Map;

/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 */

// @lc code=start
class Solution {
  // by myself
  public int lengthOfLongestSubstringKDistinct1(String s, int k) {
    if (null == s || s.length() == 0 || k == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int r = 0;
    int l = 0;
    int res = Integer.MIN_VALUE;
    while (r < s.length() && l < s.length()) {
      // System.out.format("l: %d, r: %d\n", l, r);
      if (map.size() < k || map.size() == k && map.containsKey(s.charAt(r))) {
        // System.out.format("map in 1: %s\n", map);
        map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
        res = Math.max(res, r - l + 1);
        r++;
      } else {
        System.out.format("map in 2: %s\n", map);
        if (map.get(s.charAt(l)) > 1) {
          map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
        } else {
          map.remove(s.charAt(l));
        }
        l++;
      }
    }
    return res;
  }

  // improved
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (null == s || s.length() == 0 || k == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int r = 0;
    int l = 0;
    int res = Integer.MIN_VALUE;
    while (r < s.length()) {
      map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
      // System.out.format("map in 2: %s\n", map);
      if (map.size() > k) {
        while (map.get(s.charAt(l)) > 1) {
          map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
          l++;
        }
        map.remove(s.charAt(l));
        l++;
      }

      // valid, record the length
      // System.out.format("l: %d, r: %d\n", l, r);
      res = Math.max(res, r - l + 1);

      // after recording, move the right pointer.
      // this must be the last step in the loop
      r++;
    }
    return res;
  }
}
// @lc code=end
