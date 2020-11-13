/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200221)/////////////////////////////
  /////////////////////// first round(20200221)/////////////////////////////
  //// :--------------------start(approach 1)------------------------------
  // 20200221, 
  public int numDistinct1(String s, String t) {
    int m = t.length();
    int n = s.length();

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        // any string can contain one empty string.
        // an empty string can't contain any other string
        if (i == 0) {
          dp[i][j] = 1;
        } else if (j == 0) {
          dp[i][j] = 0;
        } else if (s.charAt(j - 1) == t.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else if (s.charAt(j - 1) != t.charAt(i - 1)) {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }
    return dp[m][n];
  }

  //// ---------------------- end (Approach1)------------------------
  //// ----------------------start(Approach2)------------------------
  // 20200405, by myself. exhaustive method.
  // Time Limit Exceeded. 41/63 cases passed (N/A)
  public int numDistinct2(String s, String t) {
    List<String> lst = new ArrayList<>();
    helper2(s, t, 0, lst, "");
    // System.out.format("lst:%s\n", lst);
    return lst.size();
  }

  private void helper2(String s, String t, int i, List<String> lst, String sub) {
    if (i == s.length()) {
      System.out.format("i: %d, %s\n", i, sub);
      if (sub.length() == t.length()) {
        if (sub.equals(t)) {
          lst.add(sub);
        }
      }
      return;
    }

    helper2(s, t, i + 1, lst, sub + s.charAt(i));
    helper2(s, t, i + 1, lst, sub);
  }

  //// ---------------------- end (Approach2)------------------------
  //// ----------------------start(Approach3)------------------------
  // 20200406, recursion + memo. from right to left.
  // Your runtime beats 6.77 % of java submissions
  public int numDistinct3(String s, String t) {
    int[][] memo = new int[s.length() + 1][t.length() + 1];
    for (int[] mem : memo) {
      Arrays.fill(mem, -1);
    }
    // System.out.format("lst:%s\n", lst);
    return helper3(s, 0, t, 0, memo);
  }

  private int helper3(String s, int i, String t, int j, int[][] memo) {
    if (j == t.length()) {
      return 1;
    }
    if (i == s.length()) {
      return 0;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    int cnt = 0;
    if (s.charAt(i) == t.charAt(j)) {
      cnt += helper3(s, i + 1, t, j + 1, memo);
      cnt += helper3(s, i + 1, t, j, memo);
    } else {
      cnt += helper3(s, i + 1, t, j, memo);
    }

    memo[i][j] = cnt;
    return cnt;
  }

  //// ---------------------- end (Approach3)------------------------
  //// ----------------------start(Approach4)------------------------
  // 20200406, backtracking + memo. from right to left.
  // Your runtime beats 12.92 % of java submissions
  public int numDistinct4(String s, String t) {
    int[] res = new int[1];
    int[][] memo = new int[s.length() + 1][t.length() + 1];
    for (int[] mem : memo) {
      Arrays.fill(mem, -1);
    }

    helper4(s, 0, t, 0, res, memo);
    return res[0];
  }

  private void helper4(String s, int i, String t, int j, int[] res, int[][] memo) {
    if (j == t.length()) {
      res[0]++;
      return;
    }
    if (i == s.length()) {
      return;
    }
    if (memo[i][j] != -1) {
      res[0] += memo[i][j];
      return;
    }

    int resPrev = res[0];
    if (s.charAt(i) == t.charAt(j)) {
      helper4(s, i + 1, t, j + 1, res, memo);
    }

    helper4(s, i + 1, t, j, res, memo);

    int resIncrement = res[0] - resPrev;
    memo[i][j] = resIncrement;
  }

  //// ---------------------- end (Approach4)------------------------
  //// ----------------------start(Approach5)------------------------
  // 20200406, dp +. from right to left. + space: O(n)
  // Your runtime beats 88.86 % of java submissions
  public int numDistinct5(String s, String t) {
    int nr = s.length();
    int nc = t.length();
    int[][] dp = new int[nr + 1][nc + 1];

    // base case
    for (int i = 0; i < nr + 1; i++) {
      dp[i][nc] = 1;
    }

    for (int i = nr - 1; i >= 0; i--) {
      for (int j = nc - 1; j >= 0; j--) {
        if (s.charAt(i) == t.charAt(j)) {
          dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
        } else {
          dp[i][j] = dp[i + 1][j];
        }
      }
    }

    return dp[0][0];
  }

  //// ---------------------- end (Approach5)------------------------
  //// ----------------------start(Approach6)------------------------
  // 20200406, dp + . from right to left. + space:O(1)
  // Your runtime beats 9.09 % of java submissions
  public int numDistinct(String s, String t) {
    int nr = s.length();
    int nc = t.length();
    int[] dp = new int[nc + 1];

    // base case
    dp[nc] = 1;

    for (int i = nr - 1; i >= 0; i--) {
      int prev = dp[nc];
      for (int j = nc - 1; j >= 0; j--) {
        int tmp = dp[j];
        if (s.charAt(i) == t.charAt(j)) {
          dp[j] = dp[j] + prev;
        } else {
          dp[j] = dp[j];
        }
        prev = tmp;
      }
    }

    return dp[0];
  }
  //// ---------------------- end (Approach5)------------------------
  ////////////////// second round(20201031)////////////////////////////////////
  ////////////////// second round(20201031)////////////////////////////////////
  //// ----------------------start(Approach 6)-----------------------------
  // 20201031.
  //// ---------------------- end (Approach 6)-----------------------------
}
// @lc code=end
