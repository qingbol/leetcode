/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)-----------------
  // 20200407, by myself, backtrack.
  // wrong
  public List<List<String>> partition1(String s) {
    List<List<String>> res = new ArrayList<>();
    List<String> lst = new ArrayList<>();
    helper1(s, 0, 0, res, lst);
    return res;
  }

  private void helper1(String s, int start, int len, List<List<String>> res, List<String> lst) {
    System.out.format("start:%d, len:%d\n", start, len);
    if (len > 0) {
      lst.add(s.substring(start, start + len));
    }
    if (start + len == s.length()) {
      // System.out.format("start:%d, len:%d\n", start, len);
      res.add(new ArrayList<>(lst));
      lst.clear();
      return;
    }

    for (int l = 1; l <= s.length(); l++) {
      if (start + len + l <= s.length()) {
        helper1(s, start + len, l, res, lst);
      }
    }
  }

  //// ---------------- end (Approach1)-----------------
  //// ----------------start(Approach2)-----------------
  // 20200407,
  // refer to https://leetcode.wang/leetcode-131-Palindrome-Partitioning.html
  // Your runtime beats 90.97 % of java submissions
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    if (s.length() == 0) {
      return res;
    }

    /// =================head(check palindrome)========
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i + len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }
    /// =================tail(check palindrome)========

    helper2(res, new ArrayList<>(), s, 0, dp);
    return res;
  }

  private void helper2(List<List<String>> res, List<String> lst, String s, int start, boolean[][] dp) {
    if (start == s.length()) {
      res.add(new ArrayList<>(lst));
    }

    for (int i = start; i < s.length(); i++) {
      if (!dp[start][i]) {
        continue;
      }
      lst.add(s.substring(start, i + 1));
      helper2(res, lst, s, i + 1, dp);
      lst.remove(lst.size() - 1);
    }
  }
  //// ---------------- end (Approach2)-----------------
}
// @lc code=end
