/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (0 == matrix.length) {
      return list;
    }
    int rowBegin = 0;
    int rowEnd = matrix.length;
    // System.out.println("rowEnd: " + rowEnd);
    int colBegin = 0;
    int colEnd = matrix[0].length;
    // System.out.println("colEnd: " + colEnd);

    while (rowBegin < rowEnd && colBegin < colEnd) {
      // System.out.println("--------------------");
      for (int j = colBegin; j < colEnd; j++) {
        list.add(matrix[rowBegin][j]);
        // System.out.println("matrix: " + matrix[rowBegin][j]);
      }
      rowBegin++;
      // System.out.println("rowBegin: " + rowBegin);
      for (int i = rowBegin; i < rowEnd; i++) {
        list.add(matrix[i][colEnd - 1]);
        // System.out.println("matrix: " + matrix[i][colEnd - 1]);
      }
      colEnd--;
      // System.out.println("colEnd: " + colEnd);
      if (rowBegin < rowEnd) {
        for (int j = colEnd - 1; j >= colBegin; j--) {
          // System.out.println("matrix: " + matrix[rowEnd - 1][j]);
          list.add(matrix[rowEnd - 1][j]);
        }
      }
      rowEnd--;
      // System.out.println("rowEnd: " + rowEnd);
      if (colBegin < colEnd) {
        for (int i = rowEnd - 1; i >= rowBegin; i--) {
          list.add(matrix[i][colBegin]);
          // System.out.println("matrix: " + matrix[i][colBegin]);
        }
      }
      colBegin++;
      // System.out.println("colBegin: " + colBegin);
    }

    return list;
  }
}
// @lc code=end
