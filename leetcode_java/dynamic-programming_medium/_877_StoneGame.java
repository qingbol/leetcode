/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200721)//////////////////////////
  //////////////////////// first round(20200721)//////////////////////////
  //// -------------------start(Appraoch1)-------------------------------
  // 20200721. backtracking, by myself
  // the result is right. but the process(logic) is wrong

  // Time Limit Exceeded
  // 26/46 cases passed (N/A)

  // public boolean stoneGame(int[] piles) {
  public boolean stoneGame1(int[] piles) {
    int sum = 0;
    for (int pile : piles) {
      sum += pile;
    }
    // System.out.format("sum: %d\n", sum);

    int alex = helper1(piles, 0, piles.length - 1);
    return 2 * alex > sum;
  }

  private int helper1(int[] piles, int l, int r) {
    if (l > r) {
      return 0;
    }

    int chooseLeft = piles[l] + helper1(piles, l + 1, r);
    int chooseRight = piles[r] + helper1(piles, l, r - 1);

    return chooseLeft > chooseRight ? chooseLeft : chooseRight;
  }

  //// ------------------- end (Appraoch1)-------------------------------
  //// -------------------start(Appraoch2)-------------------------------
  // 20200721. backtracking + memoizaiton. by meself
  // the result is right. but the process(logic) is wrong

  // 46/46 cases passed (11 ms)
  // Your runtime beats 33.63 % of java submissions
  // Your memory usage beats 26.77 % of java submissions (40.4 MB)

  // public boolean stoneGame(int[] piles) {
  public boolean stoneGame2(int[] piles) {
    int n = piles.length;
    int sum = 0;
    for (int pile : piles) {
      sum += pile;
    }

    // memo[l][r] means the largest alex num when there are piles[l...r] left.
    int[][] memo = new int[n][n];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
    // for (int i = 0; i < n; i++) {
    // for (int j = i - 1; j >= 0; j--) {
    // memo[i][j] = 0;
    // }
    // }
    // System.out.format("%s\n", Arrays.deepToString(memo));

    int alex = helper2(piles, 0, n - 1, memo);
    return 2 * alex > sum;
  }

  private int helper2(int[] piles, int l, int r, int[][] memo) {
    if (l > r) {
      return 0;
    }
    if (memo[l][r] != -1) {
      return memo[l][r];
    }

    int left = piles[l] + helper2(piles, l + 1, r, memo);
    int right = piles[r] + helper2(piles, l, r - 1, memo);

    memo[l][r] = left > right ? left : right;
    return memo[l][r];
  }
  //// ------------------- end (Appraoch2)-------------------------------
  //// -------------------start(Appraoch3)-------------------------------
  // 20200721. backtracking + memoizaiton.
  // refer to leetcode discussion <[Java] This is minimax + dp (fully detailed
  //// explanation +
  //// generalization + easy understand code)>
  // https://leetcode.com/problems/stone-game/discuss/154660/Java-This-is-minimax-%2B-dp-(fully-detailed-explanation-%2B-generalization-%2B-easy-understand-code)

  // 46/46 cases passed (23 ms)
  // Your runtime beats 14.6 % of java submissions
  // Your memory usage beats 17.85 % of java submissions (45.4 MB)

  public boolean stoneGame3(int[] piles) {
    // public boolean stoneGame(int[] piles) {
    int n = piles.length;
    if (n == 0)
      return true;
    int[][] memo = new int[n][n];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));

    int diff = helper3(piles, 0, n - 1, memo, true);
    return diff > 0;
  }

  private int helper3(int[] piles, int l, int r, int[][] memo, boolean isAlex) {
    if (l > r)
      return 0;
    if (memo[l][r] != -1) {
      return memo[l][r];
    }

    if (isAlex) {
      memo[l][r] = Math.max(piles[l] + helper3(piles, l + 1, r, memo, !isAlex),
          piles[r] + helper3(piles, l, r - 1, memo, !isAlex));
    } else {
      memo[l][r] = Math.min(-piles[l] + helper3(piles, l + 1, r, memo, !isAlex),
          -piles[r] + helper3(piles, l, r - 1, memo, !isAlex));
    }

    return memo[l][r];
  }
  //// ------------------- end (Appraoch3)-------------------------------
  //// -------------------start(Appraoch4)-------------------------------
  // 20200721. backtracking + memoizaiton.
  // refer to leetcode standard solution

  // 46/46 cases passed (24 ms)
  // Your runtime beats 14.25 % of java submissions
  // Your memory usage beats 17.85 % of java submissions (45.4 MB)

  public boolean stoneGame4(int[] piles) {
    // public boolean stoneGame(int[] piles) {
    int n = piles.length;
    // int[][] dp = new int[n + 2][n + 2];
    int[][] dp = new int[n][n];

    for (int size = 1; size <= n; size++) {
      for (int l = 0; l < n - size + 1; l++) {
        // for (int l = 0; l < n - size + 1; l++) {
        int r = l + size - 1;
        boolean isAlex = size % 2 == 0;
        if (isAlex) {
          // dp[l+1][r+1] = the value of the game [plles[l], ..., plles[r]].
          // dp[l + 1][r + 1] = Math.max(piles[l] + dp[l + 2][r + 1], piles[r] + dp[l +
          // 1][r]);
          dp[l][r] = Math.max(piles[l] + dp[l + 1][r], piles[r] + dp[l][r - 1]);
        } else {
          dp[l + 1][r + 1] = Math.min(-piles[l] + dp[l + 2][r + 1], -piles[r] + dp[l + 1][r]);
        }
      }
    }
    return dp[1][n] > 0;
  }
  //// ------------------- end (Appraoch4)-------------------------------
  //// -------------------start(Appraoch5)-------------------------------
  // 20200811. dp
  // refer to labuladong<动态规划之博弈问题>

  // 46/46 cases passed (19 ms)
  // Your runtime beats 17.29 % of java submissions
  // Your memory usage beats 12.88 % of java submissions (49.3 MB)

  class Pair {
    // class Pair<T> {
    // T first, second;
    int first, second;

    public Pair(int first, int second) {
      // public Pair(T first, T second) {
      this.first = first;
      this.second = second;
    }
  }

  // public boolean stoneGame5(int[] piles) {
  public boolean stoneGame(int[] piles) {
    int n = piles.length;
    // Pair<Integer>[][] dp = (Pair<Integer>)new Object[n][n];
    // Pair<Integer>[][] dp = new Pair<>[n][n];
    Pair[][] dp = new Pair[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = new Pair(0, 0);
      }
    }

    for (int i = 0; i < n; i++) {
      dp[i][i].first = piles[i];
      dp[i][i].second = 0;
    }

    // System.out.format("dp:%s\n", dp);
    for (int l = 2; l <= n; l++) {
      for (int i = 0; i <= n - l; i++) {
        int j = i + l - 1;
        int left = piles[i] + dp[i + 1][j].second;
        int right = piles[j] + dp[i][j - 1].second;
        if (left > right) {
          dp[i][j].first = left;
          dp[i][j].second = dp[i + 1][j].first;
        } else {
          dp[i][j].first = right;
          dp[i][j].second = dp[i][j - 1].first;
        }
      }
    }

    Pair res = dp[0][n - 1];
    return res.first - res.second > 0;
  }
  //// ------------------- end (Appraoch5)-------------------------------
}
// @lc code=end
