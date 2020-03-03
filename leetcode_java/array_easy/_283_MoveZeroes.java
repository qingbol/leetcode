/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
  private void swap(int[] arrs, int i, int j) {
    int tmp = arrs[i];
    arrs[i] = arrs[j];
    arrs[j] = tmp;
  }

  public void moveZeroes(int[] arr) {
    int startOfZero = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        swap(arr, startOfZero, i);
        startOfZero++;
      }
    }
  }
}
// @lc code=end
