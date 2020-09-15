/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200117)///////////////////////////////////
  ////////////////// first round(20200117)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200117

  // public void setZeroes(int[][] matrix) {
  public void setZeroes1(int[][] matrix) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200914)///////////////////////////////////
  ////////////////// second round(20200914)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200914, by myself

  public void setZeroes(int[][] matrix) {
    // public void setZeroes2(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean firstRow = false;

    // 1. check first row
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        firstRow = true;
        break;
      }
    }
    // 2. mark the 0 rows and cols
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    // 3. set
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      }
    }
    // 4. set the 1st row.
    if (firstRow) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
