/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
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
}
// @lc code=end
