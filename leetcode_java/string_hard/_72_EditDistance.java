/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200328)///////////////////////////////////
  ////////////////// first round(20200328)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200328, by myself. recursion
  // Time Limit Exceeded
  // 25/1146 cases passed (N/A)
  public int minDistance1(String word1, String word2) {
    return helper1(word1, word2, word1.length() - 1, word2.length() - 1);
  }

  private int helper1(String word1, String word2, int p, int t) {

    // We need to insert t characters into word1.
    if (p < 0) {
      return t + 1;
    }
    // We need to delete p characters into word1.
    if (t < 0) {
      return p + 1;
    }

    if (word1.charAt(p) == word2.charAt(t)) {
      return helper1(word1, word2, p - 1, t - 1);
    }

    int res = Integer.MAX_VALUE;
    // substitute
    res = Math.min(res, helper1(word1, word2, p - 1, t - 1) + 1);
    // remove
    res = Math.min(res, helper1(word1, word2, p - 1, t) + 1);
    // insert
    res = Math.min(res, helper1(word1, word2, p, t - 1) + 1);
    return res;

  }

  //// -------------- end (Approach1)------------------------
  //// --------------start(Approach2)------------------------
  // 20200328, by myself. dp
  // Your runtime beats 5.98 % of java submissions

  // public int minDistance(String word1, String word2) {
  public int minDistance2(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if (m == 0) {
      return n;
    }
    if (n == 0) {
      return m;
    }

    int[][] dp = new int[m + 1][n + 1];
    // n == 0. word2 is empty. we need to delete word1
    for (int p = 0; p < m + 1; p++) {
      dp[p][0] = p;
    }
    // m == 0. word1 is empty. we need to insert word2
    for (int t = 0; t < n + 1; t++) {
      dp[0][t] = t;
    }

    for (int p = 1; p < m + 1; p++) {
      for (int t = 1; t < n + 1; t++) {
        if (word1.charAt(p - 1) == word2.charAt(t - 1)) {
          dp[p][t] = dp[p - 1][t - 1];
        } else {
          dp[p][t] = 1 + Math.min(dp[p - 1][t - 1], Math.min(dp[p][t - 1], dp[p - 1][t]));
        }
      }
    }

    return dp[m][n];

  }
  //// -------------- end (Approach2)------------------------
  ////////////////// second round(20200810)///////////////////////////////////
  ////////////////// second round(20200810)///////////////////////////////////
  //// --------------start(Approach3)------------------------
  // 20200328, by myself. dp
  //refer to labuladong<经典动态规划：编辑距离>

  // 1146/1146 cases passed (4 ms)
  // Your runtime beats 95.57 % of java submissions
  // Your memory usage beats 67.86 % of java submissions (39.6 MB)

  // public int minDistance3(String word1, String word2) {
  public int minDistance(String word1, String word2) {
    int n1 = word1.length(), n2 = word2.length();
    int[][] dp = new int[n1 + 1][n2 + 2];
    for (int i = 1; i <= n1; i++)
      dp[i][0] = i;
    for (int j = 1; j <= n2; j++)
      dp[0][j] = j;

    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }

    return dp[n1][n2];
  }
  //// -------------- end (Approach3)------------------------
}
// @lc code=end
