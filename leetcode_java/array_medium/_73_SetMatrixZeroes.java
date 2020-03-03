/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
  public void setZeroes(int[][] matrix) {
    // check the first row
    boolean is1stRow0 = false;
    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        is1stRow0 = true;
        break;
      }
    }

    // check the other row
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = matrix[i][0] = 0;
        }
      }
    }

    // set the elements to 0
    for (int i = 1; i < matrix.length; i++) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // set the first row
    if (is1stRow0 == true) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }

  }
}
// @lc code=end
