/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
  ///////////////// first round(20200215)//////////////////////
  //// ---------------start(Approach1)------------------------
  // 20200215.
  // public boolean isSubsequence(String s, String t) {
  public boolean isSubsequence1(String s, String t) {
    if (null == s || s.length() == 0) {
      return true;
    }
    if (s.length() > t.length()) {
      return false;
    }
    int j = 0;
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == s.charAt(j)) {
        j++;
      }
      if (j == s.length()) {
        return true;
      }
    }
    return false;
  }

  //// --------------- end (Approach1)------------------------
  //// ---------------start(Approach2)------------------------
  // optimal
  // public boolean isSubsequence(String s, String t) {
  public boolean isSubsequence2(String s, String t) {
    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

  //// --------------- end (Approach2)------------------------
  ///////////////// second round(20200722)//////////////////////
  //// ---------------start(Approach3)------------------------
  // 20200722. two pointer, by myself

  // 15/15 cases passed (1 ms)
  // Your runtime beats 83.66 % of java submissions
  // Your memory usage beats 20.73 % of java submissions (38.6 MB)

  // public boolean isSubsequence(String s, String t) {
  public boolean isSubsequence3(String s, String t) {
    if (s.length() == 0)
      return true;

    int ptr = 0;
    for (char ch : t.toCharArray()) {
      // dont forget the "ptr < s.length()"
      // System.out.format("ptr: %d ", ptr);
      if (ptr < s.length() && s.charAt(ptr) == ch) {
        ptr++;
      }
    }

    return ptr == s.length();
  }
  //// --------------- end (Approach3)------------------------
  //// ---------------start(Approach4)------------------------
  // 20200722. dp , by myself.
  // 15/15 cases passed (4 ms)
  // Your runtime beats 13.01 % of java submissions
  // Your memory usage beats 11.19 % of java submissions (39.4 MB)

  // public boolean isSubsequence(String s, String t) {
  public boolean isSubsequence4(String s, String t) {
    // dp[i + 1][j + 1] means s[0...i] vs t[0...j]
    int m = s.length();
    int n = t.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    Arrays.fill(dp[0], true);
    // for (int i = 1; i <= m; i++) {
    // dp[i][0] = false;
    // }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (dp[i][j - 1] || (s.charAt(i - 1) == t.charAt(j - 1) && dp[i - 1][j - 1])) {
          dp[i][j] = true;
        }
      }
    }

    return dp[m][n];
  }
  //// --------------- end (Approach4)------------------------
  //// ---------------start(Approach5)------------------------
  // 20200722. binary search
  // refer to labuladong <二分查找高效判定子序列>.

  // 15/15 cases passed (3 ms)
  // Your runtime beats 17.89 % of java submissions
  // Your memory usage beats 14.41 % of java submissions (39.2 MB)

  public boolean isSubsequence(String s, String t) {
    // public boolean isSubsequence5(String s, String t) {
    //// 1. build indices dictionary
    HashMap<Character, ArrayList<Integer>> dict = buildDict(t);
    // System.out.format("dict: %s\n", dict);

    //// 2. match s with t
    int curPtr = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!dict.containsKey(ch))
        return false;
      int pos = leftBound(dict.get(ch), curPtr);
      if (pos == dict.get(ch).size())
        return false;
      //// note: remember to convert pos to index
      // curPtr = pos + 1;
      curPtr = dict.get(ch).get(pos) + 1;
    }

    return true;
  }

  private HashMap<Character, ArrayList<Integer>> buildDict(String t) {
    HashMap<Character, ArrayList<Integer>> dic = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      dic.putIfAbsent(t.charAt(i), new ArrayList<>());
      dic.get(ch).add(i);
    }
    return dic;
  }

  private int leftBound(ArrayList<Integer> indices, int curPtr) {
    int lo = 0, hi = indices.size();
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (indices.get(mid) < curPtr) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }

    return lo;
  }
  //// --------------- end (Approach5)------------------------
}
// @lc code=end
