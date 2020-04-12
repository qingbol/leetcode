/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)---------------------
  // 20200120.
  // Wrong answer. 28/85 cases passed (N/A) Testcase
  // [[1,2],[2,3],[3,4],[3,5],[4,5],[5,5],[5,6],[6,7],[7,8]]
  public int maxEnvelopes1(int[][] envelopes) {
    if (null == envelopes || envelopes.length == 0) {
      return 0;
    }
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        if (a[0] != b[0]) {
          return a[0] - b[0];
        } else {
          return b[1] - a[1];
        }
      }
    });
    // System.out.println("Array after sort" + Arrays.deepToString(envelopes));
    int k = 0;
    int res = 1;
    int m = envelopes.length;
    int n = envelopes[0].length;
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == k) {
          break;
        }
        // System.out.format("k: %d, i: %d, [%d, %d], [%d, %d]\n", k, i,
        // envelopes[k][0], envelopes[k][1], envelopes[i][0],
        // envelopes[i][1]);
        if (envelopes[k][0] < envelopes[i][0] && envelopes[k][1] < envelopes[i][1]) {
          k = i;
          res++;
        }
      }
    }
    return res;
  }

  //// ---------------- end (Approach1)---------------------
  //// ----------------start(Approach2)---------------------
  // 20200120.
  // Approach 1: Sort + Longest Increasing Subsequence
  // Your runtime beats 80.31 % of java submissions
  public int maxEnvelopes(int[][] envelopes) {
    if (null == envelopes || 0 == envelopes.length) {
      return 0;
    }
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    // System.out.println("envelopes:" + Arrays.deepToString(envelopes));
    int[] dp = new int[envelopes.length];
    int len = 0;
    for (int[] envelope : envelopes) {
      int idx = binaryFinder(dp, 0, len, envelope[1]);
      dp[idx] = envelope[1];
      if (idx == len) {
        len++;
      }
    }
    return len;
  }

  private int binaryFinder(int[] dp, int start, int length, int target) {
    int lo = start;
    int hi = length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (dp[mid] == target) {
        return mid;
      } else if (dp[mid] > target) {
        hi = mid - 1;
      } else if (dp[mid] < target) {
        lo = mid + 1;
      }
    }
    return lo;
  }

  //// ---------------- end (Approach2)---------------------
  //// ----------------start(Approach3)---------------------
  // 20200409. by myself
  // Your runtime beats 9.85 % of java submissions
  public int maxEnvelopes3(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }
    int nr = envelopes.length;
    int nc = envelopes[0].length;

    // sort
    Arrays.sort(envelopes, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
    // System.out.format("env:%s\n", Arrays.deepToString(envelopes));

    int[] memo = new int[nr];
    Arrays.fill(memo, -1);
    // base case. env[0]
    memo[0] = 1;

    int res = 1;
    for (int i = 1; i < nr; i++) {
      int ret = helper3(envelopes, memo, i);
      res = Math.max(res, ret);
    }
    // System.out.format("memo:%s\n", Arrays.toString(memo));
    return res;
  }

  private int helper3(int[][] env, int[] memo, int pos) {
    if (memo[pos] != -1) {
      return memo[pos];
    }

    int ret = 1;
    for (int i = pos - 1; i >= 0; i--) {
      if (env[pos][0] > env[i][0] && env[pos][1] > env[i][1]) {
        ret = Math.max(ret, 1 + helper3(env, memo, i));
      }
    }

    memo[pos] = ret;
    return ret;
  }
  //// ---------------- end (Approach3)---------------------
}
// @lc code=end
