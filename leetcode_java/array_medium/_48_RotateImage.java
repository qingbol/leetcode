/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200110)///////////////////////////////////
  ////////////////// first round(20200110)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200110

  // public void rotate(int[][] matrix) {
  public void rotate1(int[][] matrix) {
    // transpose
    int len = matrix.length;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }

    // a reflection across the vertical line of symmetry
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][len - 1 - j];
        matrix[i][len - 1 - j] = tmp;
      }
    }
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200913)///////////////////////////////////
  ////////////////// second round(20200913)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200913
  // refer to leetcode: Approach 2 : Rotate four rectangles
  // Approach 3 : Rotate four rectangles in one single loop
  // the key is: swap(matrix[i][j], matrix[n - 1 - j][i]);

  // 21/21 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 96.81 % of java submissions (39.2 MB)

  public void rotate(int[][] matrix) {
    // public void rotate2(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < (n + 1) / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        // matrix[n - 1 -(n - 1 - j)][n - 1 - i] = matrix[j][n - 1 - i]
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = tmp;
      }
    }

  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
