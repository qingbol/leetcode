/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
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
      int low = matrix[lo / lenCol][lo % lenCol];
      // System.out.format("lo: %d, low: %d\n", lo, low);
      int high = matrix[hi / lenCol][hi % lenCol];
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
}
// @lc code=end
