/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
  //// -------------------stat(Approach1)-------------------
  // 20200322, bymyself
  // Your runtime beats 83.12 % of java submissions
  int[][] subSum;

  public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int nr = matrix.length;
    int nc = matrix[0].length;
    subSum = new int[nr + 1][nc + 1];

    for (int i = 0; i < nr; i++) {
      int r = i + 1;
      for (int j = 0; j < nc; j++) {
        int c = j + 1;
        //// -------------start(simplified version)------------
        subSum[r][c] = subSum[r - 1][c] + subSum[r][c - 1] - subSum[r - 1][c - 1] + matrix[i][j];
        //// ------------- end (simplified version)------------
        //// -------------start(complicated version)------------
        // if (i == 0 && j == 0) {
        // subSum[r][c] = matrix[i][j];
        // } else if (i == 0) {
        // subSum[r][c] = subSum[r][c - 1] + matrix[i][j];
        // } else if (j == 0) {
        // subSum[r][c] = subSum[r - 1][c] + matrix[i][j];
        // } else {
        // subSum[r][c] = subSum[r - 1][c] + subSum[r][c - 1] - subSum[r - 1][c - 1] +
        // matrix[i][j];
        // }
        //// ------------- end(complicated version)------------
      }
    }
    // for (int i = 0; i < nr + 1; i++) {
    // System.out.format("subSum: %s\n", Arrays.toString(subSum[i]));
    // }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    row1++;
    col1++;
    row2++;
    col2++;
    // System.out.format("subSum[row2][col2]:%d\n", subSum[row2][col2]);
    // System.out.format("subSum[row1 - 1][col1 - 1]:%d\n", subSum[row1 - 1][col1 -
    // 1]);
    // System.out.format("subSum[row1 - 1][col2]:%d\n", subSum[row1 - 1][col2]);
    // System.out.format("subSum[row2][col1 - 1]:%d\n", subSum[row2][col1 - 1]);
    return subSum[row2][col2] - subSum[row1 - 1][col2] - subSum[row2][col1 - 1] + subSum[row1 - 1][col1 - 1];
    // return 0;
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
