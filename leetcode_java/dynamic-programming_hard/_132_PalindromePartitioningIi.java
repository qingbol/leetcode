/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)--------------------------
  // 20200408. by myselft. backtracking
  // Memory Limit Exceeded 24/29 cases passed (N/A)
  public int minCut1(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i + len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }

    int[] cut = new int[1];
    cut[0] = Integer.MAX_VALUE;
    List<List<String>> res = new ArrayList<>();
    helper1(s, 0, cut, dp, res, new ArrayList<>());
    // System.out.format("res: %s\n", res);
    return cut[0];
  }

  private void helper1(String s, int pos, int[] cut, boolean[][] dp, List<List<String>> res, List<String> lst) {
    if (pos == s.length()) {
      res.add(new ArrayList<>(lst));
      // System.out.format("cut:%d\n", cut);
      cut[0] = Math.min(cut[0], lst.size() - 1);
      return;
    }

    int ret = 0;
    for (int i = s.length() - 1; i >= pos; i--) {
      if (!dp[pos][i]) {
        continue;
      }
      lst.add(s.substring(pos, i + 1));
      helper1(s, i + 1, cut, dp, res, lst);
      lst.remove(lst.size() - 1);
    }
  }

  //// --------------- end (Approach1)--------------------------
  //// ---------------start(Approach2)--------------------------
  // 20200408. by myselft. backtracking
  // Time Limit Exceeded 24/29 cases passed (N/A)
  public int minCut2(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i + len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }

    int[] cut = new int[1];
    cut[0] = Integer.MAX_VALUE;
    // List<List<String>> res = new ArrayList<>();
    helper2(s, 0, cut, dp, 0);
    // System.out.format("res: %s\n", res);
    return cut[0];
  }

  private void helper2(String s, int pos, int[] cut, boolean[][] dp, int cnt) {
    if (pos == s.length()) {
      // System.out.format("cut:%d\n", cut);
      cut[0] = Math.min(cut[0], cnt - 1);
      return;
    }

    int ret = 0;
    for (int i = s.length() - 1; i >= pos; i--) {
      if (!dp[pos][i]) {
        continue;
      }
      // lst.add(s.substring(pos, i + 1));
      helper2(s, i + 1, cut, dp, cnt + 1);
      // lst.remove(lst.size() - 1);
    }
  }

  //// --------------- end (Approach2)--------------------------
  //// ---------------start(Approach3)--------------------------
  // 20200408. backtracking + memo[]
  // Your runtime beats 41.51 % of java submissions
  public int minCut3(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i + len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }

    int[] memo = new int[s.length() + 1];
    Arrays.fill(memo, -1);

    int[] res = new int[1];
    res[0] = Integer.MAX_VALUE;

    helper3(s, 0, res, 0, dp, memo);
    return res[0];
  }

  private void helper3(String s, int pos, int[] res, int cut, boolean[][] dp, int[] memo) {
    if (memo[pos] != -1) {
      res[0] = Math.min(res[0], cut + memo[pos]);
      return;
    }

    if (dp[pos][s.length() - 1]) {
      res[0] = Math.min(res[0], cut);
      return;
    }

    for (int i = pos; i < s.length() - 1; i++) {
      if (!dp[pos][i]) {
        continue;
      }
      helper3(s, i + 1, res, cut + 1, dp, memo);
    }

    if (res[0] > cut) {
      memo[pos] = res[0] - cut;
    }
  }

  //// --------------- end (Approach3)--------------------------
  //// ---------------start(Approach4)--------------------------
  // 20200408. backtracking + hashmap memo
  // Your runtime beats 33.79 % of java submissions
  public int minCut4(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i + len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }

    Map<Integer, Integer> memo = new HashMap<>();

    int[] res = new int[1];
    res[0] = Integer.MAX_VALUE;

    helper3(s, 0, res, 0, dp, memo);
    return res[0];
  }

  private void helper3(String s, int pos, int[] res, int cut, boolean[][] dp, Map<Integer, Integer> memo) {
    if (memo.containsKey(pos)) {
      res[0] = Math.min(res[0], cut + memo.get(pos));
      return;
    }

    if (dp[pos][s.length() - 1]) {
      res[0] = Math.min(res[0], cut);
      return;
    }

    for (int i = pos; i < s.length() - 1; i++) {
      if (!dp[pos][i]) {
        continue;
      }
      helper3(s, i + 1, res, cut + 1, dp, memo);
    }

    if (res[0] > cut) {
      memo.put(pos, res[0] - cut);
    }
  }

  //// --------------- end (Approach4)--------------------------
  //// ---------------start(Approach5)--------------------------
  // 20200408. divide and conquer
  // Your runtime beats 38.58 % of java submissions
  public int minCut5(String s) {
    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    for (int r = 0; r < s.length(); r++) {
      for (int l = 0; l <= r; l++) {
        isPalindrome[l][r] = s.charAt(l) == s.charAt(r) && (l + 1 > r - 1 || isPalindrome[l + 1][r - 1]);
      }
    }

    int[] memo = new int[s.length()];
    Arrays.fill(memo, -1);

    return helper5(s, s.length() - 1, isPalindrome, memo);
  }

  // s.substring(0, pos + 1)
  private int helper5(String s, int pos, boolean[][] isPal, int[] memo) {
    if (memo[pos] != -1) {
      return memo[pos];
    }

    // base case. no need to split anymore
    if (isPal[0][pos]) {
      return 0;
    }

    int ret = Integer.MAX_VALUE;
    for (int i = pos; i >= 0; i--) {
      if (!isPal[i][pos]) {
        continue;
      }
      ret = Math.min(ret, helper5(s, i - 1, isPal, memo) + 1);
    }

    memo[pos] = ret;
    return ret;

  }

  //// --------------- end (Approach5)--------------------------
  //// ---------------start(Approach6)--------------------------
  // 20200408. dp
  // Your runtime beats 44.43 % of java submissions
  public int minCut(String s) {
    boolean[][] isPal = new boolean[s.length()][s.length()];
    for (int r = 0; r < s.length(); r++) {
      for (int l = 0; l <= r; l++) {
        isPal[l][r] = s.charAt(l) == s.charAt(r) && (l + 1 > r - 1 || isPal[l + 1][r - 1]);
      }
    }

    int[] dp = new int[s.length() + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    // base case. s.substring(0, 0); empty string. means this cut is
    // invalid/unnecessary.
    dp[0] = -1;
    // base case. s.substring(0, 1); the first character
    dp[1] = 0;

    for (int r = 1; r < s.length(); r++) {
      for (int l = 0; l <= r; l++) {
        if (isPal[l][r]) {
          dp[r + 1] = Math.min(dp[r + 1], 1 + dp[l]);
        }
      }
    }

    return dp[s.length()];
  }
  //// --------------- end (Approach6)--------------------------

}
// @lc code=end
