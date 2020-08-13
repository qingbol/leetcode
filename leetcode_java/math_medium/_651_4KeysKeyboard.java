/*
 * @lc app=leetcode id=651 lang=java
 *
 * [651] 4 Keys Keyboard
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200330)//////////////////////////
  //////////////////////// first round(20200330)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200330, by myself. backtradk.
  // Time Limit Exceeded, 14/50 cases passed (N/A)

  public int maxA1(int N) {
    return helper1("A", "", "", N - 1);
  }

  private int helper1(String s, String strCtrA, String strCtrC, int cnt) {
    if (cnt == 0) {
      return s.length();
    }

    int[] len = new int[4];
    len[0] = helper1(s + "A", strCtrA, strCtrC, cnt - 1);
    len[1] = helper1(s, s, strCtrC, cnt - 1);
    len[2] = helper1(s, strCtrA, strCtrA, cnt - 1);
    len[3] = helper1(s + strCtrC, strCtrA, strCtrC, cnt - 1);

    int max = len[0];
    for (int i = 1; i < len.length; i++) {
      max = Math.max(max, len[i]);
    }
    return max;
  }

  //// ---------- end (Approach1)------------------------------------
  //// ----------start(Approach2)------------------------------------
  // 20200330, backtrack + memoization
  // To get the max value, CtrlA + CtrlC must show up continuously.
  // Time Limit Exceeded, 23/50 cases passed (N/A))

  public int maxA2(int N) {
    return helper2(1, 0, N - 1);
  }

  private int helper2(int s, int strCtrC, int cnt) {
    if (cnt <= 0) {
      return s;
    }

    int[] len = new int[3];
    len[0] = helper2(s + 1, strCtrC, cnt - 1);
    // len[1], CtrA + CtrC
    len[1] = helper2(s, s, cnt - 2);
    len[2] = helper2(s + strCtrC, strCtrC, cnt - 1);
    // len[2] = helper1(s, strCtrA, strCtrA, cnt - 1);
    // len[3] = helper1(s + strCtrC, strCtrA, strCtrC, cnt - 1);

    int max = len[0];
    for (int i = 1; i < len.length; i++) {
      max = Math.max(max, len[i]);
    }
    return max;
  }

  //// ---------- end (Approach2)------------------------------------
  //// ----------start(Approach3)------------------------------------
  // 20200330, dp
  // Your runtime beats 30.24 % of java submissions

  // public int maxA(int N) {
  public int maxA3(int N) {
    int[] dp = new int[N + 1];
    dp[0] = 0;

    for (int i = 1; i <= N; i++) {
      // press A
      dp[i] = dp[i - 1] + 1;

      for (int j = 2; j < i; j++) {
        dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
      }
    }

    return dp[N];
  }
  //// ---------- end (Approach3)------------------------------------
  //////////////////////// second round(20200811)//////////////////////////
  //////////////////////// second round(20200811)//////////////////////////
  //// ----------start(Approach4)------------------------------------
  // 20200811. by myself

  // without memo
  // Time Limit Exceeded
  // 23/50 cases passed (N/A)
  // Testcase
  // 24

  // with memo
  // Wrong Answer
  // 6/50 cases passed (N/A)
  // Testcase
  // 7
  // Answer
  // 7
  // Expected Answer
  // 9

  public int maxA4(int N) {
    // public int maxA(int N) {
    int[] memo = new int[N + 1];
    return helper4(0, 0, N, memo);
  }

  private int helper4(int screen, int buff, int cnt, int[] memo) {
    if (cnt < 0)
      return 0;
    if (cnt == 0)
      return screen;

    if (memo[cnt] != 0)
      return memo[cnt];

    int ret = 0;
    // key1
    int opt1 = helper4(screen + 1, buff, cnt - 1, memo);
    // key2 + key3
    int opt2 = helper4(screen, screen, cnt - 2, memo);
    // key4
    int opt3 = helper4(screen + buff, buff, cnt - 1, memo);

    ret = Math.max(opt1, Math.max(opt2, opt3));

    memo[cnt] = ret;
    return ret;
  }
  //// ---------- end (Approach4)------------------------------------
  //// ----------start(Approach5)------------------------------------
  // 20200811. by myself
  // refer to labuladong <动态规划之四键键盘>

  // Time Limit Exceeded
  // 37/50 cases passed (N/A)
  // Testcase
  // 38

  public int maxA5(int N) {
    // public int maxA(int N) {
    // int[] memo = new int[N + 1];
    Map<String, Integer> memo = new HashMap<>();
    return helper5(0, 0, N, memo);
  }

  private int helper5(int screen, int buff, int cnt, Map<String, Integer> memo) {
    if (cnt < 0)
      return screen;
    // return 0;
    if (cnt == 0)
      return screen;

    String key = Integer.toString(screen) + Integer.toString(buff) + Integer.toString(cnt);
    if (memo.containsKey(key))
      return memo.get(key);

    int ret = 0;
    // key1
    int opt1 = helper5(screen + 1, buff, cnt - 1, memo);
    // key2 + key3
    int opt2 = helper5(screen, screen, cnt - 2, memo);
    // key4
    int opt3 = helper5(screen + buff, buff, cnt - 1, memo);

    ret = Math.max(opt1, Math.max(opt2, opt3));

    memo.put(key, ret);
    return ret;
  }
  //// ---------- end (Approach5)------------------------------------
  //// ----------start(Approach6)------------------------------------
  // 20200811. by myself
  // refer to labuladong <动态规划之四键键盘>

  // 50/50 cases passed (1 ms)
  // Your runtime beats 65.35 % of java submissions
  // Your memory usage beats 64.47 % of java submissions (36.2 MB)

  // public int maxA6(int N) {
  public int maxA(int N) {
    int[] dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      // key1
      dp[i] = dp[i - 1] + 1;
      for (int j = 3; j <= i; j++) {
        // System.out.format("i: %d, j: %d, dp:%s\n", i, j, Arrays.toString(dp));
        dp[i] = Math.max(dp[i], dp[j - 3] + dp[j - 3] * (i - j + 1));
        // dp[i] = Math.max(dp[i], dp[j - 3] * (i - j + 1));
      }
    }

    return dp[N];
  }
  //// ---------- end (Approach6)------------------------------------
}
// @lc code=end
