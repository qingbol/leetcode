import java.util.Map;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)----------------------------
  // 20200324, by myself, backtracking + memoization.
  // Your runtime beats 5.33 % of java submissions
  public boolean wordBreak1(String s, List<String> wordDict) {
    // Set<String> dict = new HashSet<>(wordDict);
    Map<String, Boolean> dict = new HashMap<>();
    for (String str : wordDict) {
      dict.put(str, true);
    }
    // System.out.format("dict: %s\n", dict);
    return helper1(dict, s);
  }

  private boolean helper1(Map<String, Boolean> dict, String s) {
    // if (dict.getOrDefault(s, false)) {
    if (dict.containsKey(s)) {
      return dict.get(s);
    }

    for (int i = 1; i < s.length(); i++) {
      if (helper1(dict, s.substring(0, i)) && helper1(dict, s.substring(i))) {
        dict.put(s, true);
        return true;
      }
    }

    dict.put(s, false);
    return false;
  }

  //// --------------- end (Approach1)----------------------------
  //// ---------------start(Approach2)----------------------------
  // 20200324, improvement of approach1. backtrack + memo
  // Your runtime beats 79.07 % of java submissions:w
  public boolean wordBreak2(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    // memo[i] = true, means s.substring[i] is in the dict.
    // boolean[] memo = new boolean[s.length()];
    Boolean[] memo = new Boolean[s.length()];
    return helper2(dict, memo, s, 0);
  }

  private boolean helper2(Set<String> dict, Boolean[] memo, String s, int start) {
    if (start == s.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }

    for (int newStart = start + 1; newStart <= s.length(); newStart++) {
      if (dict.contains(s.substring(start, newStart)) && helper2(dict, memo, s, newStart)) {
        memo[start] = true;
        return true;
      }
    }

    memo[start] = false;
    return false;

  }

  //// --------------- end (Approach2)----------------------------
  //// ---------------start(Approach3)----------------------------
  // 20200324, dp
  // without break: Your runtime beats 54.33 % of java submissions
  // with break: Your runtime beats 69.26 % of java submissions
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    // important: i & j is the segment point.
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && dict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }
  //// --------------- end (Approach3)----------------------------
}
// @lc code=end
