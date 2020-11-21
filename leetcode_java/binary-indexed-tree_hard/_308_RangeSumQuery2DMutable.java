/*
 * @lc app=leetcode id=308 lang=java
 *
 * [308] Range Sum Query 2D - Mutable
 */

// @lc code=start
////////////////// first round(20200322)///////////////////////////////////
////////////////// first round(20200322)///////////////////////////////////
//// ------------------start(Approach1)---------------------------
// 20200322, 2d binary indexed tree.
// refer to: Java 2D Binary Indexed Tree Solution clean and short 17ms
// https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms

// Your runtime beats 72.26 % of java submissions

class NumMatrix1 {
  // public class NumMatrix {
  int[][] nums;
  int[][] tree;
  int nr;
  int nc;

  // public NumMatrix(int[][] matrix) {
  public NumMatrix1(int[][] matrix) {
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
    return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2)
        + getSum(row1 - 1, col1 - 1);
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

//// ---------------- end (Approach1)----------------------------------
/////////////////////////// second round(20201120)///////////////////////
/////////////////////////// second round(20201120)///////////////////////
//// ----------------start(Approach2)----------------------------------
// 20201120.
//segemnt tree + iterative
// refer to : Java 2D Segment Tree Solution
// https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/779185/Java-2D-Segment-Tree-Solution
// This is what I was looking for..exactly extension to the 'Range Sum Query' problem. Thanks..

// 17/17 cases passed (17 ms)
// Your runtime beats 38.47 % of java submissions
// Your memory usage beats 55.52 % of java submissions (45.1 MB)

public class NumMatrix {
  // class NumMatrix1 {

  int[][] matrixSegmentsSum;
  int n;

  public NumMatrix(int[][] matrix) {
    // public NumMatrix1(int[][] matrix) {

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return;
    n = matrix[0].length;

    matrixSegmentsSum = new int[matrix.length][1];

    for (int i = 0; i < matrix.length; i++) {
      matrixSegmentsSum[i] = constructSegmentTree(matrix[i]);
    }
  }

  public int[] constructSegmentTree(int[] array) {
    int rowSum[] = new int[this.n * 2];
    for (int i = 0; i < this.n; i++) {
      rowSum[this.n + i] = array[i];
    }

    for (int i = n - 1; i > 0; i--) {
      rowSum[i] = rowSum[i * 2] + rowSum[i * 2 + 1];
    }

    return rowSum;
  }


  public void update(int row, int col, int val) {
    updateSegmentsSum(matrixSegmentsSum[row], col, val);
  }

  public void updateSegmentsSum(int[] array, int col, int val) {

    int pos = col + n;
    array[pos] = val;

    while (pos > 0) {
      int start = pos;
      int end = pos;

      if (start % 2 == 0) {
        end++;
      } else {
        start--;
      }
      array[pos / 2] = array[start] + array[end];
      pos /= 2;
    }

  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;

    for (int row = row1; row <= row2; row++) {
      sum += getRangeSum(matrixSegmentsSum[row], col1, col2);
    }

    return sum;
  }

  public int getRangeSum(int[] array, int start, int end) {

    start = start + n;
    end = end + n;
    int sum = 0;

    while (start <= end) {

      if (start % 2 == 1) {
        sum += array[start];
        start++;
      }

      if (end % 2 == 0) {
        sum += array[end];
        end--;
      }

      start /= 2;
      end /= 2;
    }

    return sum;
  }

}

//// ---------------- end (Approach2)----------------------------------
/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new
 * NumMatrix(matrix); obj.update(row,col,val); int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
