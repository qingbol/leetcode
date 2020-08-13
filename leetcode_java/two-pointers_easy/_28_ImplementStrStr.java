/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200213)//////////////////////////
  //////////////////////// first round(20200213)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200213

  // 77/77 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 41.85 % of java submissions (39.4 MB)

  // public int strStr(String haystack, String needle) {
  public int strStr1(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.substring(i, i + needle.length()).equals(needle)) {
        return i;
      }
    }
    return -1;
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20200813)//////////////////////////
  //////////////////////// second round(20200813)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20200813

//   77/77 cases passed (37 ms)
// Your runtime beats 7.45 % of java submissions
// Your memory usage beats 5.02 % of java submissions (69.5 MB)

  public int strStr(String haystack, String needle) {
    // public int strStr2(String haystack, String needle) {
    if (needle.length() == 0)
      return 0;
    KMP kmp = new KMP(needle);
    return kmp.search(haystack);
  }

  class KMP {
    int[][] dfa;
    String pat;

    public KMP(String pat) {
      this.pat = pat;
      int M = pat.length();
      int R = 256;
      dfa = new int[M][R];
      // base case;
      dfa[0][pat.charAt(0)] = 1;
      // shadow status
      int X = 0;

      for (int j = 1; j < M; j++) {
        for (int k = 0; k < R; k++) {
          dfa[j][k] = dfa[X][k];
        }
        dfa[j][pat.charAt(j)] = j + 1;
        X = dfa[X][pat.charAt(j)];
      }
    }

    public int search(String txt) {
      int i = 0, N = txt.length();
      int j = 0, M = pat.length();

      for (; i < N && j < M; i++) {
        j = dfa[j][txt.charAt(i)];
      }

      if (j == M)
        return i - M;
      else
        return -1;
    }
  }
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
