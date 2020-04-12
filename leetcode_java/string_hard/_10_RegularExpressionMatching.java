/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)----------------------------------
  // 20200329. recursion, traverse the stringw from right to end
  // 369/447 cases passed (N/A). wrong for test case:
  // "aaa" \n "ab*ac*a"
  public boolean isMatch1(String s, String p) {
    return helper1(s, p, s.length() - 1, p.length() - 1);
  }

  private boolean helper1(String s, String p, int i, int j) {
    if (i == -1 && j == -1) {
      return true;
    }
    // the below logic is wrong
    if (i == -1) {
      if (p.charAt(j) == '*') {
        return true;
      } else {
        return false;
      }
    }

    if (j == -1) {
      return false;
    }

    char ch1 = s.charAt(i);
    char ch2 = p.charAt(j);
    if (ch1 == ch2 || ch2 == '.' || ch2 == '*') {
      // if (ch1 == ch2 || ch2 == '.' || (ch2 == '*' && (p.charAt(j - 1) == '.' ||
      // p.charAt(j - 1) == ch1))) {
      if (helper1(s, p, i - 1, j - 1)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  //// --------------- end (Approach1)----------------------------------
  //// ---------------start(Approach2)----------------------------------
  // 20200329. recursion, traverse the strings from left to right
  // Your runtime beats 28.76 % of java submissions
  public boolean isMatch2(String s, String p) {
    return helper2(s, p, 0, 0);
  }

  private boolean helper2(String s, String p, int i, int j) {
    // if (i == -1 && j == -1) {
    // return true;
    // }
    if (j == p.length()) {
      return i == s.length();
    }

    boolean isFirstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

      if (isFirstMatch && helper2(s, p, i + 1, j)) {
        return true;
      }

      // if (j + 2 < p.length() && helper2(s, p, i, j + 2)) {
      if (helper2(s, p, i, j + 2)) {
        return true;
      }
    }

    if (isFirstMatch && helper2(s, p, i + 1, j + 1)) {
      return true;
    }

    return false;
  }

  //// --------------- end (Approach2)----------------------------------
  //// ---------------start(Approach3)----------------------------------
  // 20200329. recursion, traverse the strings from left to right
  // leetcode. Approach 1: Recursion
  public boolean isMatch3(String text, String pattern) {
    // System.out.format("text:%s, patter:%s\n", text, pattern);
    if (pattern.isEmpty())
      return text.isEmpty();
    boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
    // System.out.format("firstMatch:%b\n", first_match);

    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
    } else {
      return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
  }

  //// --------------- end (Approach3)----------------------------------
  //// ---------------start(Approach4)----------------------------------
  // 20200329. recursion, traverse the strings from left to right
  // leetcode. Approach 1: Recursion + memoization
  // Your runtime beats 100 % of java submissions
  public boolean isMatch4(String text, String pattern) {
    Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
    // System.out.format("memo:%s\n", Arrays.deepToString(memo));
    return helper4(memo, text, pattern, 0, 0);
  }

  private boolean helper4(Boolean[][] memo, String t, String p, int i, int j) {
    // System.out.format("i: %d, j: %d\n", i, j);
    if (memo[i][j] != null) {
      return memo[i][j];
    }

    // base case
    if (j == p.length()) {
      return i == t.length();
    }

    boolean ret = false;
    boolean firstMatch = (i < t.length() && (t.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      ret = helper4(memo, t, p, i, j + 2) || (firstMatch && helper4(memo, t, p, i + 1, j));
    } else {
      ret = firstMatch && helper4(memo, t, p, i + 1, j + 1);
    }

    memo[i][j] = ret;
    return ret;
  }

  //// --------------- end (Approach4)----------------------------------
  //// ---------------start(Approach5)----------------------------------
  // 20200329. dp, traverse the strings from left to right
  // leetcode. Approach 2: dp
  // Your runtime beats 75.3 % of java submissions
  public boolean isMatch5(String text, String pattern) {
    boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
    dp[text.length()][pattern.length()] = true;

    for (int i = text.length(); i >= 0; i--) {
      // for (int i = text.length() - 1; i >= 0; i--) {
      for (int j = pattern.length() - 1; j >= 0; j--) {
        boolean firstMatch = (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'));
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
          dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
        } else {
          dp[i][j] = firstMatch && dp[i + 1][j + 1];
        }
      }
    }
    return dp[0][0];
  }

  //// --------------- end (Approach5)----------------------------------
  //// ---------------start(Approach6)----------------------------------
  // 20200330. recusion + memoization, traverse the strings from right to left. by
  //// myself
  // Your runtime beats 100 % of java submissions
  public boolean isMatch6(String text, String pattern) {
    Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
    // helper6(memo, text, pattern, -1, -1);
    boolean res = helper6(memo, text, pattern, text.length() - 1, pattern.length() - 1);
    // System.out.format("res:%s\n", Arrays.deepToString(memo));
    return res;
  }

  private boolean helper6(Boolean[][] memo, String t, String p, int r, int c) {
    // System.out.format("r:%d, c:%d\n", r, c);
    if (memo[r + 1][c + 1] != null) {
      return memo[r + 1][c + 1];
    }

    if (r == -1 && c == -1) {
      memo[r + 1][c + 1] = true;
      return true;
    }
    if (r == -1) {
      if (p.charAt(c) == '*') {
        // System.out.format("checkpoint_1\n");
        memo[r + 1][c + 1] = helper6(memo, t, p, r, c - 2);
        // System.out.format("checkpoint_2\n");
        // System.out.format("r+1:%d, c - 1: %d, %b\n", r + 1, c + 1, memo[r + 1][c +
        // 1]);
        return memo[r + 1][c + 1];
      } else {
        memo[r + 1][c + 1] = false;
        return false;
      }
    }

    if (c == -1) {
      memo[r + 1][c + 1] = false;
      return false;
    }

    boolean ret = false;
    boolean curMatch = t.charAt(r) == p.charAt(c) || p.charAt(c) == '.';
    boolean prevMatch = c > 0 && (t.charAt(r) == p.charAt(c - 1) || p.charAt(c - 1) == '.');

    if (p.charAt(c) == '*') {
      ret = helper6(memo, t, p, r, c - 2) || prevMatch && helper6(memo, t, p, r - 1, c);
    } else {
      ret = curMatch && helper6(memo, t, p, r - 1, c - 1);
    }

    memo[r + 1][c + 1] = ret;
    return ret;
  }

  //// --------------- end (Approach6)----------------------------------
  //// ---------------start(Approach7)----------------------------------
  // 20200330. recusion + memoization, improvement of Approach6
  // traverse the strings from right to left. by myself
  public boolean isMatch7(String text, String pattern) {
    Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
    // helper6(memo, text, pattern, -1, -1);
    boolean res = helper7(memo, text, pattern, text.length() - 1, pattern.length() - 1);
    // System.out.format("res:%s\n", Arrays.deepToString(memo));
    return res;
  }

  private boolean helper7(Boolean[][] memo, String t, String p, int r, int c) {
    // System.out.format("r:%d, c:%d\n", r, c);
    if (memo[r + 1][c + 1] != null) {
      return memo[r + 1][c + 1];
    }

    if (r == -1 && c == -1) {
      memo[r + 1][c + 1] = true;
      return true;
    }

    //// merge the following special case (r = -1) to main stream
    // if (r == -1) {
    // if (p.charAt(c) == '*') {
    // // System.out.format("checkpoint_1\n");
    // memo[r + 1][c + 1] = helper6(memo, t, p, r, c - 2);
    // // System.out.format("checkpoint_2\n");
    // // System.out.format("r+1:%d, c - 1: %d, %b\n", r + 1, c + 1, memo[r + 1][c +
    // // 1]);
    // return memo[r + 1][c + 1];
    // } else {
    // memo[r + 1][c + 1] = false;
    // return false;
    // }
    // }

    if (c == -1) {
      memo[r + 1][c + 1] = false;
      return false;
    }

    boolean ret = false;
    boolean curMatch = r >= 0 && c >= 0 && (t.charAt(r) == p.charAt(c) || p.charAt(c) == '.');
    boolean prevMatch = r >= 0 && c > 0 && (t.charAt(r) == p.charAt(c - 1) || p.charAt(c - 1) == '.');

    if (p.charAt(c) == '*') {
      ret = helper6(memo, t, p, r, c - 2) || prevMatch && helper6(memo, t, p, r - 1, c);
    } else {
      ret = curMatch && helper6(memo, t, p, r - 1, c - 1);
      // System.out.format("checkpoint_1\n");
    }

    memo[r + 1][c + 1] = ret;
    return ret;
  }

  //// --------------- end (Approach7)----------------------------------
  //// ---------------start(Approach8)----------------------------------
  // 20200330. dp,
  // traverse the strings from right to left. by myself
  // Your runtime beats 75.3 % of java submissions:w
  public boolean isMatch(String text, String pattern) {
    boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];

    dp[0][0] = true;
    for (int j = 0; j < pattern.length(); j++) {
      dp[0][j + 1] = pattern.charAt(j) == '*' ? dp[0][j - 1] : false;
    }

    for (int i = 0; i < text.length(); i++) {
      for (int j = 0; j < pattern.length(); j++) {
        if (pattern.charAt(j) == '*') {
          boolean noMatch = dp[i + 1][j - 1];
          boolean prevMatch = pattern.charAt(j - 1) == text.charAt(i) || pattern.charAt(j - 1) == '.';
          boolean match = prevMatch && dp[i][j + 1];
          dp[i + 1][j + 1] = noMatch || match;
        } else {
          boolean curMatch = pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.';
          dp[i + 1][j + 1] = curMatch && dp[i][j];
        }
      }
    }
    // System.out.format("dp:%s\n", Arrays.deepToString(dp));

    return dp[text.length()][pattern.length()];
  }
  //// --------------- end (Approach8)----------------------------------
}
// @lc code=end
