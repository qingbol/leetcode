/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200120.

  // 136/136 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 91.31 % of java submissions (39 MB)

  public boolean searchMatrix(int[][] matrix, int target) {
    // public boolean searchMatrix1(int[][] matrix, int target) {
    if (null == matrix || matrix.length == 0) {
      return false;
    }
    int lenRow = matrix.length;
    int lenCol = matrix[0].length;
    int lo = 0;
    int hi = (lenRow * lenCol) - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int middle = matrix[mid / lenCol][mid % lenCol];
      // System.out.format("mid: %d, middle: %d\n", mid, middle);
      // int low = matrix[lo / lenCol][lo % lenCol];
      // System.out.format("lo: %d, low: %d\n", lo, low);
      // int high = matrix[hi / lenCol][hi % lenCol];
      // System.out.format("hi: %d, high: %d\n", hi, high);
      if (target == middle) {
        return true;
      } else if (target > middle) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return false;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200916)///////////////////////////////////
  ////////////////// second round(20200916)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200916
  //just like approach1. the key is to know how to convert 2d array to 1d array.
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
