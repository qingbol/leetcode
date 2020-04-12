/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)---------------------
  // 20200405. exhaustive method
  // Time Limit Exceeded 42/43 cases passed (N/A)
  public int minimumTotal1(List<List<Integer>> triangle) {
    int[] min = new int[1];
    min[0] = Integer.MAX_VALUE;
    helper1(triangle, 0, 0, 0, min);
    // System.out.format("min:%d\n", min[0]);
    return min[0];
  }

  private void helper1(List<List<Integer>> triangle, int r, int c, int sum, int[] min) {
    if (r >= triangle.size()) {
      min[0] = Math.min(min[0], sum);
      return;
    }

    sum += triangle.get(r).get(c);
    helper1(triangle, r + 1, c, sum, min);
    helper1(triangle, r + 1, c + 1, sum, min);
  }

  //// --------------- end (Approach1)---------------------
  //// ---------------start(Approach2)---------------------
  // 20200405. by myself.exhaustive method + memoization
  // Your runtime beats 15.74 % of java submissions
  public int minimumTotal2(List<List<Integer>> triangle) {
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    return helper2(triangle, 0, 0, memo);
  }

  private int helper2(List<List<Integer>> triangle, int r, int c, Map<Pair<Integer, Integer>, Integer> memo) {
    if (memo.containsKey(new Pair(r, c))) {
      return memo.get(new Pair(r, c));
    }
    if (r >= triangle.size()) {
      return 0;
    }

    int left = helper2(triangle, r + 1, c, memo);
    int right = helper2(triangle, r + 1, c + 1, memo);
    int sum = triangle.get(r).get(c) + Math.min(left, right);

    memo.put(new Pair(r, c), sum);
    return sum;
  }

  //// --------------- end (Approach2)---------------------
  //// ---------------start(Approach3)---------------------
  // 20200405. by myself. dp
  // Your runtime beats 5.27 % of java submissions
  public int minimumTotal3(List<List<Integer>> triangle) {
    int r = triangle.size();
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
    for (int j = 0; j < triangle.get(r - 1).size(); j++) {
      dp.put(new Pair(r - 1, j), triangle.get(r - 1).get(j));
    }

    for (int i = r - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int left = dp.get(new Pair(i + 1, j));
        int right = dp.get(new Pair(i + 1, j + 1));
        int minChild = Math.min(left, right);
        dp.put(new Pair(i, j), minChild + triangle.get(i).get(j));
      }
    }
    // System.out.format("dp:%s\n", dp);
    return dp.get(new Pair(0, 0));
  }

  //// --------------- end (Approach3)---------------------
  //// ---------------start(Approach4)---------------------
  // 20200405. improvement of approach3.
  // Your runtime beats 41.11 % of java submissions
  public int minimumTotal(List<List<Integer>> triangle) {
    int r = triangle.size();
    Integer[] dp = new Integer[triangle.get(r - 1).size()];
    dp = triangle.get(r - 1).toArray(dp);

    for (int i = r - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int minChild = Math.min(dp[j], dp[j + 1]);
        dp[j] = triangle.get(i).get(j) + minChild;
      }
    }
    // System.out.format("dp:%s\n", dp);
    return dp[0];
  }
  //// --------------- end (Approach4)---------------------
}
// @lc code=end
