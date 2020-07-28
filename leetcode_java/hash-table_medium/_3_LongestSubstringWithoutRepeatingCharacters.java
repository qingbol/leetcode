/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200218)///////////////////////////////////
  ////////////////// first round(20200218)///////////////////////////////////
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

  // 987/987 cases passed (19 ms)
  // Your runtime beats 21.64 % of java submissions
  // Your memory usage beats 5.01 % of java submissions (43 MB)

  // public int lengthOfLongestSubstring(String s) {
    public int lengthOfLongestSubstring2(String s) {
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
  ////////////////// second round(20200728)///////////////////////////////////
  ////////////////// second round(20200728)///////////////////////////////////
  //// ---------------start(Approach3)----------------------------------
  // 20200728. by myself
  // refer to labuladong <滑动窗口解题套路框架>

  // 987/987 cases passed (11 ms)
  // Your runtime beats 40.06 % of java submissions
  // Your memory usage beats 5.01 % of java submissions (41.5 MB)

  public int lengthOfLongestSubstring3(String s) {
    // public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> window = new HashMap<>();

    int left = 0, right = 0;
    int res = 0;
    boolean isRepeat = false;

    while (right < s.length()) {
      char r = s.charAt(right);
      right++;
      window.put(r, window.getOrDefault(r, 0) + 1);
      if (window.get(r) > 1)
        isRepeat = true;

      // System.out.format("window before:[%d, %d)\n", left, right);

      while (isRepeat && left < right) {
        // while (isRepeat && left < s.length()) {
        char l = s.charAt(left);
        left++;
        if (window.containsKey(l)) {
          if (window.get(l) > 1)
            isRepeat = false;
          window.put(l, window.get(l) - 1);
        }

      }

      res = Math.max(res, right - left);
      // System.out.format("window after:[%d, %d), res: %d\n", left, right, res);
    }
    return res;
  }
  //// --------------- end (Approach3)----------------------------------
  //// ---------------start(Approach3)----------------------------------
  // 20200728. 
  // refer to labuladong <滑动窗口解题套路框架>

  //987/987 cases passed (11 ms)
// Your runtime beats 40.06 % of java submissions
// Your memory usage beats 5.01 % of java submissions (41.6 MB)

  // public int lengthOfLongestSubstring4(String s) {
    public int lengthOfLongestSubstring(String s) {
      HashMap<Character,Integer> window = new HashMap<>();

      int left = 0, right = 0;
      int res = 0; 

      while (right < s.length()) {
        char r = s.charAt(right);
        right++;
        window.put(r, window.getOrDefault(r, 0) + 1);

        while (window.get(r) > 1) {
          char l = s.charAt(left);
          left++;
          window.put(l, window.get(l) - 1);
        }

        res =Math.max(res, right -left);
      }
      return res;
  }
  //// --------------- end (Approach3)----------------------------------
}
// @lc code=end
