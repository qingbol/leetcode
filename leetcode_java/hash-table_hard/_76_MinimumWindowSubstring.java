/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
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
  public String minWindow(String s, String t) {
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
}
//// ----------------- end (Appraoch2)----------------------
// @lc code=end
