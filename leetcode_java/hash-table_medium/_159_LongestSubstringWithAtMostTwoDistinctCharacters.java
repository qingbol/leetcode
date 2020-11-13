import java.util.Map;

/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200219)///////////////////////////////////
  ////////////////// first round(20200219)///////////////////////////////////
  //// ---------------start(Approach1)----------------------------------
  // 20200219, 
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (null == s || s.length() < 3) {
      return s.length();
    }
    Map<Character, Integer> map = new HashMap<>();
    int res = 0;
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
      if (map.size() > 2) {
        while (map.get(s.charAt(l)) > 1) {
          map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
          l++;
        }
        map.remove(s.charAt(l));
        l++;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;
  }
  //// ----------------- end (Appraoch1)----------------------
  ////////////////// second round(20201025)/////////////////////////////////////
  ////////////////// second round(20201025)/////////////////////////////////////
  //// -----------------start(Appraoch2)----------------------
  //20201025
  //refer to leetcode: Approach 1: Sliding Window
  //int del_idx = Collections.min(hashmap.values());
  //trick: use hashmap to store the index instead of quantity.
  //// ----------------- end (Appraoch2)----------------------
}
// @lc code=end
