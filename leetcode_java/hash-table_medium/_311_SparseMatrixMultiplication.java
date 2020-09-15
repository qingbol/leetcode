/*
 * @lc app=leetcode id=311 lang=java
 *
 * [311] Sparse Matrix Multiplication
 */

// @lc code=start
class Solution {
  ////////////////// second round(20200914)///////////////////////////////////
  ////////////////// second round(20200914)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200914,

  // 13/13 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 20.39 % of java submissions (41.9 MB)

  public int[][] multiply(int[][] A, int[][] B) {
    // public int[][] multiply1(int[][] A, int[][] B) {
    int m = A.length, nA = A[0].length, nB = B[0].length;
    int[][] res = new int[m][nB];

    for (int i = 0; i < m; i++) {
      for (int k = 0; k < nA; k++) {
        if (A[i][k] != 0) {
          for (int j = 0; j < nB; j++) {
            if (B[k][j] != 0)
              res[i][j] += A[i][k] * B[k][j];
          }
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end

