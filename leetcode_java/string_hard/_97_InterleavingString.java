/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
  //// ---------------------start(Approach1)----------------------------
  // 20200406, by myself. backtraking
  // Your runtime beats 6.49 % of java submissions
  public boolean isInterleave1(String s1, String s2, String s3) {
    return helper1(s1, s2, s3, 0, 0, 0);
  }

  private boolean helper1(String s1, String s2, String s3, int i, int j, int k) {
    if (i == s1.length() && j == s2.length() && k == s3.length()) {
      // System.out.format("i:%d, j:%d, k:%d\n", i, j, k);
      return true;
    }
    if (k == s3.length()) {
      return false;
    }

    boolean ret = false;
    if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
      ret = helper1(s1, s2, s3, i + 1, j, k + 1);
    }
    if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
      ret = ret || helper1(s1, s2, s3, i, j + 1, k + 1);
    }
    // ret = ret || helper1(s1, s2, s3, i, j, k + 1);

    return ret;

  }

  //// --------------------- end (Approach1)----------------------------
  //// ---------------------start(Approach2)----------------------------
  // 20200406, by myself. backtraking + memoization
  // Your runtime beats 89.23 % of java submissions
  public boolean isInterleave2(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    Map<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();
    return helper2(s1, s2, s3, 0, 0, 0, memo);
  }

  private boolean helper2(String s1, String s2, String s3, int i, int j, int k,
      Map<Pair<Integer, Integer>, Boolean> memo) {
    if (i == s1.length() && j == s2.length() && k == s3.length()) {
      // System.out.format("i:%d, j:%d, k:%d\n", i, j, k);
      return true;
    }
    if (k == s3.length()) {
      return false;
    }

    if (memo.containsKey(new Pair(i, j))) {
      return memo.get(new Pair(i, j));
    }

    boolean ret = false;
    if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
      ret = helper2(s1, s2, s3, i + 1, j, k + 1, memo);
    }
    if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
      ret = ret || helper2(s1, s2, s3, i, j + 1, k + 1, memo);
    }
    // ret = ret || helper1(s1, s2, s3, i, j, k + 1);

    memo.put(new Pair(i, j), ret);
    return ret;

  }

  //// --------------------- end (Approach2)----------------------------
  //// ---------------------start(Approach3)----------------------------
  // 20200406, dp + space:O(n)
  // Your runtime beats 16.51 % of java submissions
  public boolean isInterleave3(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    int n1 = s1.length();
    int n2 = s2.length();
    boolean[][] dp = new boolean[n1 + 1][n2 + 1];

    // base case
    dp[0][0] = true;
    // s1 == ""
    for (int j = 1; j < n2 + 1; j++) {
      dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
    }
    // s2 == ""
    for (int i = 1; i < n1 + 1; i++) {
      dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
    }

    for (int i = 1; i < n1 + 1; i++) {
      for (int j = 1; j < n2 + 1; j++) {
        dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[i - 1][j];
        dp[i][j] |= (s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[i][j - 1];
      }
    }
    return dp[n1][n2];
  }

  //// --------------------- end (Approach3)----------------------------
  //// ---------------------start(Approach3)----------------------------
  // 20200406, dp + space:O(1)
  // Your runtime beats 31.75 % of java submissions
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    int n1 = s1.length();
    int n2 = s2.length();

    boolean[] dp = new boolean[n2 + 1];
    // base case;
    dp[0] = true;
    for (int j = 1; j < n2 + 1; j++) {
      dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
    }

    for (int i = 1; i < n1 + 1; i++) {
      for (int j = 0; j < n2 + 1; j++) {
        if (j == 0) {
          dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
        } else {
          dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
          dp[j] |= dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        }
      }
    }

    return dp[n2];
  }
  //// --------------------- end (Approach3)----------------------------

}
// @lc code=end
