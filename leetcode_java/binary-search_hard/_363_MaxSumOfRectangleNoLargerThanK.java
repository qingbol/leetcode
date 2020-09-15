/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200117)///////////////////////////////////
  ////////////////// first round(20200117)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200117
  // refer to
  ////////////////// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83636/Java-244ms-Applying

  // public int maxSumSubmatrix(int[][] matrix, int k) {
  public int maxSumSubmatrix1(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;
    int minDif = Integer.MAX_VALUE;
    for (int left = 0; left < n; left++) {
      int[] sumRow = new int[m];
      for (int right = left; right < n; right++) {
        TreeSet<Integer> set = new TreeSet<>();
        int curSum = 0;
        for (int i = 0; i < m; i++) {
          sumRow[i] += matrix[i][right];
          curSum += sumRow[i];
          if (curSum == k) {
            return k;
          } else if (curSum < k) {
            minDif = Math.min(minDif, k - curSum);
          }
          // } else {
          Integer x = set.ceiling(curSum - k);
          if (x != null && curSum - x <= k) {
            minDif = Math.min(minDif, k - curSum + x);
          }
          if (minDif == 0) {
            return k;
          }
          set.add(curSum);
        }
      }
    }
    return k - minDif;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200914)///////////////////////////////////
  ////////////////// second round(20200914)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200914,
  // refer to cspire
  // refer to leetcode:
  //// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83597/Java-Binary-Search-solution-time-complexity-min(mn)2*max(mn)*log(max(mn))

  // 27/27 cases passed (142 ms)
  // Your runtime beats 73.28 % of java submissions
  // Your memory usage beats 65.27 % of java submissions (39.6 MB)

  public int maxSumSubmatrix(int[][] matrix, int k) {
    // public int maxSumSubmatrix2(int[][] matrix, int k) {
    if (matrix.length == 0)
      return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int res = Integer.MIN_VALUE;

    for (int left = 0; left < n; left++) {
      int[] rowSum = new int[m];
      // int curSum = 0;
      for (int right = left; right < n; right++) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int curSum = 0;
        for (int i = 0; i < m; i++) {
          rowSum[i] += matrix[i][right];
          curSum += rowSum[i];
          Integer x = set.ceiling(curSum - k);
          if (x != null) {
            res = Math.max(res, curSum - x);
          }
          set.add(curSum);
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
