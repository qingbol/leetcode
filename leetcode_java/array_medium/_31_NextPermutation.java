/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
  //// ------------------start(Approach1)----------------------------
  public void nextPermutation(int[] nums) {
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
}
// @lc code=end
