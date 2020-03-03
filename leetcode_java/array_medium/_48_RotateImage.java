/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
  public void rotate(int[][] matrix) {
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
}
// @lc code=end
