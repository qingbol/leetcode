/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200227)////////////////////////
  /////////////////////// first round(20200227)////////////////////////
  //// ------------------start(Approach1)----------------------------
  // 20200227.

  // public void nextPermutation(int[] nums) {
  public void nextPermutation1(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      int j = nums.length - 1;
      while (j > i && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private void reverse(int[] nums, int start) {
    int l = start;
    int r = nums.length - 1;
    while (l < r) {
      swap(nums, l, r);
      l++;
      r--;
    }
  }
  //// ------------------ end (Approach1)----------------------------
  /////////////////////// second round(20200725)////////////////////////
  /////////////////////// second round(20200725)////////////////////////
  //// ------------------start(Approach2)----------------------------
  // 20200725. can't come up by myself. \
  // I can only hanle [1, 5, 4, 3, 2]. can't image case like [4,7,6,5,3,2,1]

  // 265/265 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 9.17 % of java submissions (40 MB)

  //eg. 45876321

  public void nextPermutation(int[] nums) {
    // public void nextPermutation2(int[] nums) {
    int n = nums.length;
    int i = n - 2;
    for (; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        break;
      }
    }

    if (i >= 0) {
      int j = n - 1;
      while (nums[i] >= nums[j])
        j--;
      swap2(nums, i, j);
    }

    reverse2(nums, i + 1);
  }

  private void swap2(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private void reverse2(int[] nums, int start) {
    int hi = nums.length - 1;
    int lo = start;
    while (lo < hi) {
      swap2(nums, lo, hi);
      lo++;
      hi--;
    }
  }
  //// ------------------ end (Approach2)----------------------------
}
// @lc code=end
