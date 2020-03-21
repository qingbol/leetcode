/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
  //// -----------------start(Approach1)--------------------
  // 16/16 cases passed (7 ms)
  // Your runtime beats 66.68 % of java submissions
  int[] arr;

  // public NumArray(int[] nums) {
  // arr = new int[nums.length];
  // for (int i = 0; i < nums.length; i++) {
  // if (i == 0) {
  // arr[i] = nums[i];
  // } else {
  // arr[i] = arr[i - 1] + nums[i];
  // }
  // }
  // }

  public int sumRange1(int i, int j) {
    if (i == 0) {
      return arr[j];
    }
    return arr[j] - arr[i - 1];
  }

  //// ----------------- end (Approach1)--------------------
  //// -----------------start(Approach2)--------------------
  // 16/16 cases passed (7 ms)
  // Your runtime beats 66.68 % of java submissions
  public NumArray(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] + nums[i];
    }
    arr = nums;
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return arr[j];
    }
    return arr[j] - arr[i - 1];
  }
  //// ----------------- end (Approach2)--------------------
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
// @lc code=end
