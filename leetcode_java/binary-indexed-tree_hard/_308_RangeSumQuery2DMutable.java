/*
 * @lc app=leetcode id=308 lang=java
 *
 * [308] Range Sum Query 2D - Mutable
 */

// @lc code=start
class NumMatrix {
  //// ------------------start(Approach1)------------------------
  // 20200322, 2d binary indexed tree.
  // Your runtime beats 72.26 % of java submissions
  int[][] nums;
  int[][] tree;
  int nr;
  int nc;

  public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    nr = matrix.length;
    nc = matrix[0].length;
    nums = new int[nr][nc];
    tree = new int[nr + 1][nc + 1];

    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        update(i, j, matrix[i][j]);
      }
    }

  }

  public void update(int row, int col, int val) {
    int diff = val - nums[row][col];
    nums[row][col] = val;

    int r = row + 1;
    while (r < nr + 1) {
      int c = col + 1;
      while (c < nc + 1) {
        tree[r][c] += diff;
        c += (c & -c);
      }
      r += (r & -r);
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
  }

  private int getSum(int row, int col) {
    int sum = 0;

    int r = row + 1;
    while (r > 0) {
      int c = col + 1;
      while (c > 0) {
        sum += tree[r][c];
        c -= (c & -c);
      }
      r -= (r & -r);
    }

    return sum;
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); obj.update(row,col,val); int param_2 =
 * obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
