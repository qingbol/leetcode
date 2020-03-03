/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
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
    System.out.println("Array after sort" + Arrays.deepToString(envelopes));
    int k = 0;
    int res = 1;
    int m = envelopes.length;
    int n = envelopes[0].length;
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == k) {
          break;
        }
        System.out.format("k: %d, i: %d, [%d, %d], [%d, %d]\n", k, i, envelopes[k][0], envelopes[k][1], envelopes[i][0],
            envelopes[i][1]);
        if (envelopes[k][0] < envelopes[i][0] && envelopes[k][1] < envelopes[i][1]) {
          k = i;
          res++;
        }
      }
    }
    return res;
  }

  // Approach 1: Sort + Longest Increasing Subsequence
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
}
// @lc code=end
