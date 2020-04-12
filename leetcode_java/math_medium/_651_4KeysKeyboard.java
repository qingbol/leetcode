/*
 * @lc app=leetcode id=651 lang=java
 *
 * [651] 4 Keys Keyboard
 */

// @lc code=start
class Solution {
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
  public int maxA(int N) {
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
}
// @lc code=end
