import java.util.HashMap;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200213)//////////////////////////////////////
  //// -----------------start(Appraoch1)----------------------
  // 20200213.
  // By myself: error, logic confusion

  public String minWindow1(String s, String t) {
    int minl = s.length() - 1;
    int maxr = 0;
    for (char ch : t.toCharArray()) {
      int pos = s.indexOf(ch);
      if (pos == -1) {
        return "";
      } else {
        minl = Math.min(pos, minl);
        maxr = Math.max(maxr, pos);
      }
    }
    // List<Character> lst = Arrays.asList(t.toCharArray());
    // Set<Character> set = new HashSet<>(Arrays.asList(t.toCharArray()));
    Set<Character> set = new HashSet<>(t.length());
    for (char ch : t.toCharArray()) {
      set.add(ch);
    }
    // System.out.format("set: %s\n", set);
    int i = 0;
    int j = 0;
    int match = 0;
    while (j < s.length()) {
      if (match == 0 && set.contains(s.charAt(i))) {
        match++;
        j++;
      } else if (match != 0 && match < set.size() && set.contains(s.charAt(j))) {
        match++;
        j++;
        if (match == set.size()) {
          if (j - i + 1 > maxr - minl + 1) {
            minl = i;
            maxr = j;
          }
          i++;
        }
      } else if (match == set.size()) {

      }
    }

    System.out.format("sub: %s\n", s.substring(minl, maxr));
    return null;
  }

  //// ----------------- end (Appraoch1)----------------------
  //// -----------------start(Appraoch2)----------------------
  // 20200213
  // the second try
  // public String minWindow(String s, String t) {
  public String minWindow2(String s, String t) {
    int fast = 0;
    int slow = 0;

    int[] bucket = new int[256];
    for (char ch : t.toCharArray()) {
      bucket[ch]++;
    }

    int lenToMatch = t.length();
    int windowStart = 0;
    int windowSize = Integer.MAX_VALUE;
    for (; fast < s.length(); fast++) {
      // System.out.format("fast: %d\n", fast);
      // int count = bucket[s.charAt(fast)]--;
      // if (count >= 0) {
      if (bucket[s.charAt(fast)]-- > 0) {
        lenToMatch--;
      }

      // move the slow pointer, this is the key
      while (lenToMatch == 0) {
        // System.out.format("slow: %d\n", slow);
        // when lenToMatch = 0, record the window
        if (fast - slow + 1 < windowSize) {
          windowSize = fast - slow + 1;
          windowStart = slow;
        }
        // check if the element which slow point to is in t
        if (++bucket[s.charAt(slow++)] > 0) {
          lenToMatch++;
        }
        // move the slow pointer
        // slow++;
      }
    }

    return windowSize < Integer.MAX_VALUE ? s.substring(windowStart, windowStart + windowSize) : "";

  }

  //// ----------------- end (Appraoch2)----------------------
  ////////////////// second round(20200727)/////////////////////////////////////
  ////////////////// second round(20200727)/////////////////////////////////////
  //// -----------------start(Appraoch3)----------------------
  // 20200727. by myself, wrong.
  // By myself: error, logic confusion

  // public String minWindow(String s, String t) {
  public String minWindow3(String s, String t) {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    for (char ch : t.toCharArray()) {
      need.put(ch, need.getOrDefault(ch, 0) + 1);
    }

    int left = 0;
    int right = 0;
    int idx = 0;
    int len = Integer.MAX_VALUE;
    while (right < s.length()) {
      char rChar = s.charAt(right);
      right++;
      // core part
      window.put(rChar, window.getOrDefault(rChar, 0) + 1);

      char lChar = s.charAt(left);
      while (!need.containsKey(lChar) || window.get(lChar) > need.get(lChar)) {
        window.put(lChar, window.getOrDefault(lChar, 0) - 1);
        left++;
      }

      boolean flag = true;
      for (char k : need.keySet()) {
        if (!window.containsKey(k) || window.get(k) < need.get(k))
          flag = false;
      }
      if (flag) {
        if (right - left + 1 < len) {
          idx = left;
          len = right - left + 1;
        }
      }

    }

    return s.substring(idx, idx + len);
  }
  //// ----------------- end (Appraoch3)----------------------
  //// -----------------start(Appraoch4)----------------------
  // 20200727.
  // refer to labuladong <滑动窗口解题套路框架>

  // 268/268 cases passed (21 ms)
  // Your runtime beats 30.57 % of java submissions
  // Your memory usage beats 5.97 % of java submissions (44.3 MB)

  public String minWindow(String s, String t) {
    // public String minWindow4(String s, String t) {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    for (char ch : t.toCharArray()) {
      need.put(ch, need.getOrDefault(ch, 0) + 1);
    }
    // for ( char ch : s.toCharArray()) {
    // window.put(ch, window.getOrDefault(ch, 0) + 1);
    // }
    // System.out.format("need: %s\n", need);
    // System.out.format("window: %s\n", window);

    int left = 0, right = 0;
    int start = 0;
    int len = Integer.MAX_VALUE;
    // int start = 0, len = Integer.MAX_VALUE;
    int matched = 0;

    while (right < s.length()) {
      char rChar = s.charAt(right);
      right++;
      if (need.containsKey(rChar)) {
        window.put(rChar, window.getOrDefault(rChar, 0) + 1);
        // if (window.get(rChar) > 300)
        // System.out.format("win: %d, need: %d\n", window.get(rChar), need.get(rChar));
        if ((window.get(rChar)).equals(need.get(rChar)))
          // if (window.get(rChar) == need.get(rChar))
          matched++;
      }

      // debugl
      // System.out.format("matched: %d, window: %s\n", matched, window);
      // if (matched > 0)
      // System.out.format("window:[%d, %d), matched: %d\n", left, right, matched);

      while (matched == need.size()) {
        if (right - left < len) {
          start = left;
          len = right - left;
        }

        char lChar = s.charAt(left);
        left++;
        if (need.containsKey(lChar)) {
          if (need.get(lChar).equals(window.get(lChar))) {
            // if (need.get(lChar) == window.get(lChar)) {
            matched--;
          }
          window.put(lChar, window.get(lChar) - 1);
        }
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
  //// ----------------- end (Appraoch3)----------------------
}
// @lc code=end
