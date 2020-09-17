/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200120.
  public boolean searchMatrix(int[][] matrix, int target) {
    if (null == matrix || matrix.length == 0) {
      return false;
    }
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
      // System.out.format("row:%d, col:%d, val:%d\n", row, col, matrix[row][col]);
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        col--;
      }
    }
    return false;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200916)///////////////////////////////////
  ////////////////// second round(20200916)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200916, by myself.
  //just like approach1
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
