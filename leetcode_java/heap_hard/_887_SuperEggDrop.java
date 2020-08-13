/*
 * @lc app=leetcode id=887 lang=java
 *
 * [887] Super Egg Drop
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200810)///////////////////////////////////
  ////////////////// first round(20200810)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200910,
  // refer to labuladong <经典动态规划：高楼扔鸡蛋>

  // Time Limit Exceeded
  // 64/121 cases passed (N/A)
  // Testcase
  // 4
  // 10000

  // public int superEggDrop(int K, int N) {
  public int superEggDrop1(int K, int N) {
    // int[][] memo = new int[K + 1][N + 1];
    Map<Integer, Integer> map = new HashMap<>();
    return helper1(K, N, map);
  }

  private int helper1(int K, int N, Map<Integer, Integer> map) {
    if (K == 1)
      return N;
    if (N == 0)
      return 0;

    if (map.containsKey(N * 100 + K))
      return map.get(N * 100 + K);

    int cnt = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      int broken = helper1(K - 1, i - 1, map);
      int unbroken = helper1(K, N - i, map);
      cnt = Math.min(cnt, Math.max(broken, unbroken) + 1);
    }

    map.put(N * 100 + K, cnt);
    return cnt;
  }
  //// -------------- end (Approach1)------------------------
  //// --------------start(Approach2)------------------------
  // 20200910,
  // refer to labuladong <经典动态规划：高楼扔鸡蛋>

//   121/121 cases passed (620 ms)
// Your runtime beats 5.02 % of java submissions
// Your memory usage beats 34.04 % of java submissions (46.5 MB)

  public int superEggDrop(int K, int N) {
    // public int superEggDrop2(int K, int N) {
    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    return helper2(K, N, map);
  }

  private int helper2(int K, int N, Map<Pair<Integer, Integer>, Integer> map) {
    if (K == 1)
      return N;
    if (N == 0)
      return 0;

    Pair<Integer, Integer> pair = new Pair<>(K, N);
    if (map.containsKey(pair))
      return map.get(pair);

    int ret = Integer.MAX_VALUE;
    int lo = 1, hi = N;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int broken = helper2(K - 1, mid - 1, map);
      int unbroken = helper2(K, N - mid, map);
      if (broken > unbroken) {
        hi = mid - 1;
        ret = Math.min(ret, broken + 1);
      } else {
        lo = mid + 1;
        ret = Math.min(ret, unbroken + 1);
      }
    }

    map.put(pair, ret);
    return ret;
  }
  //// -------------- end (Approach2)------------------------
}
// @lc code=end
