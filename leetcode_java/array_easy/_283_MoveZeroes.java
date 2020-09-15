/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200108)///////////////////////////////////
  ////////////////// first round(20200108)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200108

  private void swap(int[] arrs, int i, int j) {
    int tmp = arrs[i];
    arrs[i] = arrs[j];
    arrs[j] = tmp;
  }

  // public void moveZeroes(int[] arr) {
  public void moveZeroes1(int[] arr) {
    int startOfZero = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        swap(arr, startOfZero, i);
        startOfZero++;
      }
    }
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200907, by myself.

  // 21/21 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 81.44 % of java submissions (39.7 MB)

  public void moveZeroes(int[] arr) {
    // public void moveZeroes2(int[] arr) {
    int n = arr.length;
    int pos = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        arr[pos++] = arr[i];
      }
    }

    for (; pos < n; pos++) {
      arr[pos] = 0;
    }
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
