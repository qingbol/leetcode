/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
  public boolean wordPattern1(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    String[] strs = str.split("\\s+");
    if (pattern.length() != strs.length) {
      return false;
    }

    for (int i = 0; i < pattern.length(); i++) {
      if (map.containsKey(pattern.charAt(i))) {
        if (!map.get(pattern.charAt(i)).equals(strs[i])) {
          return false;
        }
      } else {
        if (map.values().contains(strs[i])) {
          return false;
        }
        map.put(pattern.charAt(i), strs[i]);
      }
    }
    return true;
  }

  // better
  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      if (!Objects.equals(map.put(pattern.charAt(i) + "", i), map.put(words[i], i))) {
        return false;
      }
    }
    return true;
  }
}
// @lc code=end
