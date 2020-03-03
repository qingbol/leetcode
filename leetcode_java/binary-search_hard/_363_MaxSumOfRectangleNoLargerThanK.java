/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
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
}
// @lc code=end
